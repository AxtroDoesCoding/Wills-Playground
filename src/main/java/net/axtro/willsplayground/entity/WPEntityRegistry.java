package net.axtro.willsplayground.entity;

import net.axtro.willsplayground.WillsPlayground;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WPEntityRegistry {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WillsPlayground.MOD_ID);

    public static final RegistryObject<EntityType<EntityChameleon>> CHAMELEON = ENTITY_TYPES.register("chameleon", () -> EntityType.Builder.of(EntityChameleon::new, MobCategory.CREATURE).sized(0.5f, 0.5f).build(new ResourceLocation(WillsPlayground.MOD_ID, "chameleon").toString()));
    public static final RegistryObject<EntityType<EntityRideableGoat>> RIDEABLE_GOAT = ENTITY_TYPES.register("rideable_goat", () -> EntityType.Builder.of(EntityRideableGoat::new, MobCategory.CREATURE).sized(0.9f, 1.3f).build(new ResourceLocation(WillsPlayground.MOD_ID, "rideable_goat").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
