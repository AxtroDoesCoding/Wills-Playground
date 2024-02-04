package net.axtro.willsplayground.entity;

import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.entity.custom.ChameleonEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WillsPlayground.MOD_ID);

    public static final RegistryObject<EntityType<ChameleonEntity>> CHAMELEON =
            ENTITY_TYPES.register("chameleon",
                    () -> EntityType.Builder.of(ChameleonEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.5f)
                            .build(new ResourceLocation(WillsPlayground.MOD_ID, "chameleon").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
