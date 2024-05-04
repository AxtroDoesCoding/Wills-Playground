package net.axtro.willsplayground.item;

import net.axtro.willsplayground.WillsPlayground;
import net.axtro.willsplayground.entity.WPEntityRegistry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WPItemRegistry {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, WillsPlayground.MOD_ID);
    public static final RegistryObject<Item> TABLOGO = ITEMS.register("tablogo", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BEER = ITEMS.register("beer", () -> new Item(new Item.Properties().food(new FoodProperties.Builder().alwaysEat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600), 0.6f).build())));
    public static final RegistryObject<Item> ENZORITE = ITEMS.register("enzorite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_ENZORITE = ITEMS.register("raw_enzorite", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector", () -> new ItemOreDetector(new Item.Properties().durability(100)));
    public static final RegistryObject<Item> BIO_FUEL = ITEMS.register("bio_fuel", () -> new ItemBioFuel(new Item.Properties(), 400));

    public static final RegistryObject<Item> MARINOR = ITEMS.register("marinor", () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> RIDEABLE_GOAT_EGG = ITEMS.register("rideable_goat_egg", () -> new ForgeSpawnEggItem(WPEntityRegistry.RIDEABLE_GOAT, 0x7d8c86, 0xace6cf, new Item.Properties()));
    public static final RegistryObject<Item> CHAMELEON_EGG = ITEMS.register("chameleon_egg", () -> new ForgeSpawnEggItem(WPEntityRegistry.CHAMELEON, 0x3a6346, 0x8abf9a, new Item.Properties()));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
