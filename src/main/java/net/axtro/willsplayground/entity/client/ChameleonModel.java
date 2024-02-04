package net.axtro.willsplayground.entity.client;

import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.entity.custom.ChameleonEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;

public class ChameleonModel extends GeoModel<ChameleonEntity> {
    @Override
    public ResourceLocation getModelResource(ChameleonEntity chameleonEntity) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "geo/chameleon.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChameleonEntity chameleonEntity) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "textures/entity/chameleon.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChameleonEntity chameleonEntity) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "animations/chameleon.animation.json");

    }

    @Override
    public void setCustomAnimations(ChameleonEntity animatable, long instanceId, AnimationState<ChameleonEntity> animationState) {
        super.setCustomAnimations(animatable, instanceId, animationState);
    }
}
