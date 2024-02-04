package net.axtro.willsplayground.event;


import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.entity.ModEntities;
import net.axtro.willsplayground.entity.custom.ChameleonEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WillsPlayground.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntities.CHAMELEON.get(), ChameleonEntity.setAttributes());
    }
}
