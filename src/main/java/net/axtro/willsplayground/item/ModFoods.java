package net.axtro.willsplayground.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties BEER = new FoodProperties.Builder()
            .alwaysEat().effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 600), 0.6f).build();



}

