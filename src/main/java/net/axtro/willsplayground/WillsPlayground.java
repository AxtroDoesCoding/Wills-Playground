package net.axtro.willsplayground;

import com.mojang.logging.LogUtils;
import net.axtro.willsplayground.block.WPBlockRegistry;
import net.axtro.willsplayground.client.render.RenderRideableGoat;
import net.axtro.willsplayground.client.sound.WPSoundRegistry;
import net.axtro.willsplayground.entity.WPEntityRegistry;
import net.axtro.willsplayground.client.render.RenderChameleon;
import net.axtro.willsplayground.misc.WPCreativeTabRegistry;
import net.axtro.willsplayground.item.WPItemRegistry;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(WillsPlayground.MOD_ID)
public class WillsPlayground {
    public static final String MOD_ID = "willsplayground";
    private static final Logger LOGGER = LogUtils.getLogger();

    public WillsPlayground() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        WPCreativeTabRegistry.register(modEventBus);

        WPItemRegistry.register(modEventBus);
        WPBlockRegistry.register(modEventBus);

        WPEntityRegistry.register(modEventBus);

        GeckoLib.initialize();

        modEventBus.addListener(this::commonSetup);

        WPSoundRegistry.register(modEventBus);

        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        {
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(WPEntityRegistry.CHAMELEON.get(), RenderChameleon::new);
            EntityRenderers.register(WPEntityRegistry.RIDEABLE_GOAT.get(), RenderRideableGoat::new);
        }
    }
}
