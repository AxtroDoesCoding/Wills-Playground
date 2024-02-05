package net.axtro.willsplayground.entity.client;

import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.entity.custom.ChameleonEntity;
import net.minecraft.client.model.EntityModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

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
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
