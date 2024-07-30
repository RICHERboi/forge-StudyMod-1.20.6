package net.RICHER.studymod.item;

import net.RICHER.studymod.util.ModTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;



public class ModToolTiers {
    public static final Tier TIER_CUBIUM = new ForgeTier(800, 7f, 2f, 20, ModTags.Blocks.NEEDS_CUBIUM_TOOL,
            () -> Ingredient.of(ModItems.CUBIUM.get()), ModTags.Blocks.INCORRECT_FOR_CUBIUM_TOOL);
}
