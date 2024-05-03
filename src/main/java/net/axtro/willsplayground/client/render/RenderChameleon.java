package net.axtro.willsplayground.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.client.model.ModelChameleon;
import net.axtro.willsplayground.entity.EntityChameleon;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderChameleon extends GeoEntityRenderer<EntityChameleon> {
    public RenderChameleon(EntityRendererProvider.Context renderManager) {
        super(renderManager, new ModelChameleon());


    }

    @Override
    public ResourceLocation getTextureLocation(EntityChameleon animatable) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "textures/entity/chameleon.png");
    }

    @Override
    public float getMotionAnimThreshold(EntityChameleon animatable) {
        return 0.00000001f;
    }




    @Override
    public void render(EntityChameleon entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.6f,0.6f,0.6f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
