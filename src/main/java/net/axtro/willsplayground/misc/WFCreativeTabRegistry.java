package net.axtro.willsplayground.misc;

import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.block.WPBlockRegistry;
import net.axtro.willsplayground.item.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class WFCreativeTabRegistry {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WillsPlayground.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PLAYGROUND_TAB = CREATIVE_MODE_TABS.register("playground_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BEER.get()))
                    .title(Component.translatable("creativetab.playground_tab"))
                    .displayItems((pParameters, pOutput) -> {

                        pOutput.accept(ModItems.METAL_DETECTOR.get());
                        pOutput.accept(ModItems.BEER.get());

                        pOutput.accept(ModItems.ENZORITE.get());
                        pOutput.accept(ModItems.RAW_ENZORITE.get());
                        pOutput.accept(ModItems.BIO_FUEL.get());
                        pOutput.accept(ModItems.RIDEABLE_GOAT_EGG.get());
                        pOutput.accept(ModItems.CHAMELEON_EGG.get());



                        pOutput.accept(WPBlockRegistry.ENZORITE_BLOCK.get());
                        pOutput.accept(WPBlockRegistry.RAW_ENZORITE_BLOCK.get());
                        pOutput.accept(WPBlockRegistry.DEEPSLATE_ENZORITE_ORE.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
