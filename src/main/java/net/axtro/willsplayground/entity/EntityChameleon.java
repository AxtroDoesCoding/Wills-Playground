package net.axtro.willsplayground.entity;


import com.google.common.collect.Sets;
import net.axtro.willsplayground.entity.util.Maths;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.ShoulderRidingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.scores.Team;
import net.minecraftforge.event.ForgeEventFactory;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import net.minecraft.world.entity.ai.goal.LandOnOwnersShoulderGoal;

import java.util.Set;



public class EntityChameleon extends ShoulderRidingEntity implements GeoEntity {
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);
    private int rideCooldown = 0;

    public EntityChameleon(EntityType<? extends ShoulderRidingEntity> entityType, Level level) {
        super(entityType, level);
    }


    private static final Set<Item> TAME_FOOD = Sets.newHashSet(Items.APPLE);

    private static final EntityDataAccessor<Boolean> SITTING =
            SynchedEntityData.defineId(EntityChameleon.class, EntityDataSerializers.BOOLEAN);


    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 16D)
                .add(Attributes.MOVEMENT_SPEED, 0.15f).build();


    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new SitWhenOrderedToGoal(this));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1d, 10f, 2f, false));
        this.goalSelector.addGoal(3, new MeleeAttackGoal(this, 1.2, false));
        this.goalSelector.addGoal(3, new LandOnOwnersShoulderGoal(this));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 5.0F));
        this.goalSelector.addGoal(7, new PanicGoal(this, 1.0D));
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return WPEntityRegistry.CHAMELEON.get().create(level);

    }


    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<GeoAnimatable>(this, "controller", 0, this::predicate));

    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> tAnimationState) {
        if (tAnimationState.isMoving()) {
            tAnimationState.getController().setAnimationSpeed(1.5f).setAnimation(RawAnimation.begin().then("animation.chameleon.walk", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;
        }

        if (this.isInSittingPose()) {
            tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.chameleon.sitting", Animation.LoopType.LOOP));
            return PlayState.CONTINUE;

        }

        tAnimationState.getController().setAnimation(RawAnimation.begin().then("animation.chameleon.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }


    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        setSitting(tag.getBoolean("isSitting"));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        tag.putBoolean("isSitting", this.isSitting());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(SITTING, false);
    }

    public void setSitting(boolean sitting) {
        this.entityData.set(SITTING, sitting);
        this.setOrderedToSit(sitting);
    }

    public boolean isSitting() {
        return this.entityData.get(SITTING);
    }

    @Override
    public Team getTeam() {
        return super.getTeam();
    }

    public boolean canBeLeashed(Player player) {
        return false;
    }

    public void rideTick() {
        final Entity entity = this.getVehicle();
        if (this.isPassenger() && !entity.isAlive()) {
            this.stopRiding();
        } else if (isTame() && entity instanceof LivingEntity && isOwnedBy((LivingEntity) entity)) {
            this.setDeltaMovement(0, 0, 0);
            this.tick();
            if (this.isPassenger()) {
                final Entity mount = this.getVehicle();
                final int i = mount.getPassengers().indexOf(this);
                final float radius = 0.43F;
                final float angle = (Maths.STARTING_ANGLE * (((LivingEntity) mount).yBodyRot + (i == 0 ? -90 : 90)));
                final double extraX = radius * Mth.sin(Mth.PI + angle);
                final double extraZ = radius * Mth.cos(angle);
                final double extraY = (mount.isShiftKeyDown() ? 1.25D : 1.45D);
                this.yHeadRot = ((Player) mount).yHeadRot;
                this.yRotO = ((Player) mount).yHeadRot;
                this.setPos(mount.getX() + extraX, mount.getY() + extraY, mount.getZ() + extraZ);
                if (!mount.isAlive() || rideCooldown == 0 && mount.isShiftKeyDown() || ((Player) mount).isFallFlying() || this.getTarget() != null && this.getTarget().isAlive()) {
                    this.removeVehicle();

                }
            }
        } else {
            super.rideTick();
        }
    }


    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if (!this.isTame() && TAME_FOOD.contains(itemstack.getItem())) {
            if (!player.getAbilities().instabuild) {
                itemstack.shrink(1);
            }
            if (!ForgeEventFactory.onAnimalTame(this, player)) {
                if (!this.level().isClientSide) {
                    super.tame(player);
                    this.navigation.recomputePath();
                    this.setTarget(null);
                    this.level().broadcastEntityEvent(this, (byte) 7);
                    setSitting(true);
                }
            }
            return InteractionResult.SUCCESS;
        }
        if (isTame() && !this.level().isClientSide && hand == InteractionHand.MAIN_HAND) {
            setSitting(!isSitting());
            return InteractionResult.SUCCESS;
        }
        if (itemstack.getItem() == TAME_FOOD) {
            return InteractionResult.PASS;
        }
        if (player.isShiftKeyDown() && player.getPassengers().isEmpty()) {
            this.startRiding(player);
            rideCooldown = 20;
            return InteractionResult.SUCCESS;

            }
            return super.mobInteract(player, hand);
        }
    }
