package net.axtro.willsplayground.client.model;

import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.entity.EntityChameleon;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class ModelChameleon extends GeoModel<EntityChameleon> {
    @Override
    public ResourceLocation getModelResource(EntityChameleon entityChameleon) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "geo/chameleon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityChameleon entityChameleon) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "textures/entity/chameleon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityChameleon entityChameleon) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "animations/chameleon.animation.json");

    }

    @Override
    public void setCustomAnimations(EntityChameleon animatable, long instanceId, AnimationState<EntityChameleon> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}