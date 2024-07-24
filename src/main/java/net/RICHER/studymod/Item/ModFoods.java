package net.RICHER.studymod.Item;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {

    public static final FoodProperties CUBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationModifier(0.2f).effect(new MobEffectInstance(MobEffects.GLOWING, 50), 1f).build();
}
