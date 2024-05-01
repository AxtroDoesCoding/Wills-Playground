package net.axtro.willsplayground.event;


import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.entity.EntityRideableGoat;
import net.axtro.willsplayground.entity.WPEntityRegistry;
import net.axtro.willsplayground.entity.EntityChameleon;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WillsPlayground.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(WPEntityRegistry.CHAMELEON.get(), EntityChameleon.setAttributes());
            event.put(WPEntityRegistry.RIDEABLE_GOAT.get(), EntityRideableGoat.setAttributes());
    }
}
