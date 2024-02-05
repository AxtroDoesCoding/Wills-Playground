package net.axtro.willsplayground.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.entity.custom.ChameleonEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class ChameleonRenderer extends GeoEntityRenderer<ChameleonEntity> {
    public ChameleonRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ChameleonModel());


    }

    @Override
    public ResourceLocation getTextureLocation(ChameleonEntity animatable) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "textures/entity/chameleon.png");
    }

    @Override
    public float getMotionAnimThreshold(ChameleonEntity animatable) {
        return 0.00000001f;
    }




    @Override
    public void render(ChameleonEntity entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.6f,0.6f,0.6f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
