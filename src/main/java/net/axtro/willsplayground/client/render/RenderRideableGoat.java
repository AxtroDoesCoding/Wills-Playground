package net.axtro.willsplayground.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.client.model.RideableGoatModel;
import net.axtro.willsplayground.entity.EntityRideableGoat;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class RenderRideableGoat extends GeoEntityRenderer<EntityRideableGoat> {
    public RenderRideableGoat(EntityRendererProvider.Context renderManager) {
        super(renderManager, new RideableGoatModel());
        this.shadowRadius = 0.6F;
    }

    @Override
    public ResourceLocation getTextureLocation(EntityRideableGoat animatable) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "textures/entity/goat.png");
    }

    @Override
    public void render(EntityRideableGoat entity, float entityYaw, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight) {
            poseStack.scale(1f,1f,1f);
        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
        }




}
