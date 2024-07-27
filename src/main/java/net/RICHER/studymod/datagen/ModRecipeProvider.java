package net.RICHER.studymod.datagen;

import net.RICHER.studymod.StudyMod;
import net.RICHER.studymod.block.ModBlocks;
import net.RICHER.studymod.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CompletableFuture;



public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> CUBIUM_SMELTABLES = List.of(ModItems.RAW_CUBIUM.get(),
            ModBlocks.CUBIUM_ORE.get(), ModBlocks.DEEPSLATE_CUBIUM_ORE.get(), ModBlocks.NETHER_CUBIUM_ORE.get(),
            ModBlocks.END_CUBIUM_ORE.get());

    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries) {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        oreSmelting(recipeOutput, CUBIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CUBIUM.get(), 0.8f, 200, "cubium");
        oreBlasting(recipeOutput, CUBIUM_SMELTABLES, RecipeCategory.MISC, ModItems.CUBIUM.get(), 0.4f, 100, "cubium");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.CUBIUM.get(), 9)
                .requires(ModBlocks.CUBIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.CUBIUM_BLOCK.get()), has(ModBlocks.CUBIUM_BLOCK.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RAW_CUBIUM.get(), 9)
                .requires(ModBlocks.RAW_CUBIUM_BLOCK.get())
                .unlockedBy(getHasName(ModBlocks.RAW_CUBIUM_BLOCK.get()), has(ModBlocks.RAW_CUBIUM_BLOCK.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.PINE_CONE.get(), 4)
                .requires(Items.SPRUCE_LEAVES, 4)
                .unlockedBy(getHasName(Items.SPRUCE_LEAVES), has(Items.SPRUCE_LEAVES))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.CUBERRY.get(), 8)
                .requires(Items.GLOW_BERRIES,8)
                .requires(ModItems.CUBIUM.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(Items.GLOW_BERRIES))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.CUBIUM_BLOCK.get())
                .pattern("CCC")
                .pattern("CCC")
                .pattern("CCC")
                .define('C', ModItems.CUBIUM.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RAW_CUBIUM_BLOCK.get())
                .pattern("RRR")
                .pattern("RRR")
                .pattern("RRR")
                .define('R', ModItems.RAW_CUBIUM.get())
                .unlockedBy(getHasName(ModItems.RAW_CUBIUM.get()), has(ModItems.RAW_CUBIUM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.METAL_DETECTOR.get())
                .pattern("  R")
                .pattern(" BB")
                .pattern("C  ")
                .define('C', ModItems.CUBIUM.get())
                .define('B', Items.BLAZE_ROD)
                .define('R', Items.REDSTONE)
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.CUBIUM_STAFF.get())
                .pattern("  C")
                .pattern(" B ")
                .pattern("c  ")
                .define('C', ModBlocks.CUBIUM_BLOCK.get())
                .define('B', Items.BREEZE_ROD)
                .define('c', ModItems.CUBIUM.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUBIUM_STAIRS.get(),4)
                .pattern("#  ").pattern("## ").pattern("###")
                .define('#', ModItems.CUBIUM.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUBIUM_SLAB.get(), 6)
                .pattern("###")
                .define('#', ModItems.CUBIUM.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUBIUM_WALL.get(), 6)
                .pattern("###").pattern("###")
                .define('#', ModItems.CUBIUM.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.CUBIUM_FENCE.get(), 6)
                .pattern("W#W").pattern("W#W")
                .define('W', ModBlocks.CUBIUM_BLOCK.get()).define('#', ModItems.CUBIUM.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.CUBIUM_FENCE_GATE.get(), 2)
                .pattern("#W#").pattern("#W#")
                .define('#', ModItems.CUBIUM.get()).define('W', ModBlocks.CUBIUM_BLOCK.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.REDSTONE, ModBlocks.CUBIUM_BUTTON.get())
                .requires(ModItems.CUBIUM.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        pressurePlateBuilder(RecipeCategory.REDSTONE, ModBlocks.CUBIUM_PRESSURE_PLATE.get(), Ingredient.of(ModItems.CUBIUM.get()))
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.CUBIUM_DOOR.get())
                .pattern("##").pattern("##").pattern("##")
                .define('#', ModItems.CUBIUM.get())
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.REDSTONE, ModBlocks.CUBIUM_TRAPDOOR.get(), 2)
                .pattern("#G#").pattern("###")
                .define('#', ModItems.CUBIUM.get()).define('G', Items.GLASS_PANE)
                .unlockedBy(getHasName(ModItems.CUBIUM.get()), has(ModItems.CUBIUM.get()))
                .save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput pRecipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pRecipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    private static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput pRecipeOutput, RecipeSerializer<T> pSerializer, AbstractCookingRecipe
            .Factory<T> pRecipeFactory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pSuffix) {
        Iterator var10 = pIngredients.iterator();

        while(var10.hasNext()) {
            ItemLike itemlike = (ItemLike)var10.next();
            SimpleCookingRecipeBuilder.generic(Ingredient
                    .of(new ItemLike[]{itemlike}), pCategory, pResult, pExperience, pCookingTime, pSerializer, pRecipeFactory)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pRecipeOutput, StudyMod.MOD_ID + ":" + getItemName(pResult) + pSuffix + "_" + getItemName(itemlike));
        }

    }
}