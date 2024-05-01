package net.axtro.willsplayground.client.model;

import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.entity.EntityRideableGoat;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class RideableGoatModel extends GeoModel<EntityRideableGoat> {
    @Override
    public ResourceLocation getModelResource(EntityRideableGoat entityRideableGoat) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "geo/goat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(EntityRideableGoat entityRideableGoat) {
        return new ResourceLocation(WillsPlayground.MOD_ID, "textures/entity/goat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(EntityRideableGoat entityRideableGoat) {
        return null;
    }
}
