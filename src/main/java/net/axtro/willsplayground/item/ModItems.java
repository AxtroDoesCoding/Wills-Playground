package net.axtro.willsplayground.item;

import net.axtro.willsplayground.WillsPlayground;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WillsPlayground.MOD_ID);

    public static final RegistryObject<Item> BEER = ITEMS.register("beer",
            () -> new Item(new Item.Properties().food(ModFoods.BEER)));

    public static final RegistryObject<Item> ENZORITE = ITEMS.register("enzorite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> RAW_ENZORITE = ITEMS.register("raw_enzorite",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
