package net.axtro.willsplayground.item;

import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WillsPlayground.MOD_ID);

    public static final RegistryObject<CreativeModeTab> PLAYGROUND_TAB = CREATIVE_MODE_TABS.register("playground_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.BEER.get()))
                    .title(Component.translatable("creativetab.playground_tab"))
                    .displayItems((pParameters, pOutput) -> {


                        pOutput.accept(ModItems.BEER.get());
                        pOutput.accept(ModItems.ENZORITE.get());
                        pOutput.accept(ModItems.RAW_ENZORITE.get());
                        pOutput.accept(ModBlocks.ENZORITE_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_ENZORITE_BLOCK.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ENZORITE_ORE.get());


                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
