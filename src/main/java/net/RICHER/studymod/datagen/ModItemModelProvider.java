package net.RICHER.studymod.datagen;

import net.RICHER.studymod.StudyMod;
import net.RICHER.studymod.block.ModBlocks;
import net.RICHER.studymod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, StudyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.CUBIUM);
        simpleItem(ModItems.RAW_CUBIUM);

        simpleItem(ModItems.METAL_DETECTOR);

        simpleItem(ModItems.CUBERRY);
        simpleItem(ModItems.PINE_CONE);

        simpleBlockItem(ModBlocks.CUBIUM_DOOR);

        fenceItem(ModBlocks.CUBIUM_FENCE, ModBlocks.CUBIUM_BLOCK);
        buttonItem(ModBlocks.CUBIUM_BUTTON, ModBlocks.CUBIUM_BLOCK);
        wallItem(ModBlocks.CUBIUM_WALL, ModBlocks.CUBIUM_BLOCK);

        evenSimplerBlockItem(ModBlocks.CUBIUM_STAIRS);
        evenSimplerBlockItem(ModBlocks.CUBIUM_SLAB);
        evenSimplerBlockItem(ModBlocks.CUBIUM_PRESSURE_PLATE);
        evenSimplerBlockItem(ModBlocks.CUBIUM_FENCE_GATE);

        trapdoorItem(ModBlocks.CUBIUM_TRAPDOOR);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StudyMod.MOD_ID, "item/" + item.getId().getPath()));
    }

    private void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture", new ResourceLocation(StudyMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private void buttonItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/button_inventory"))
                .texture("texture", new ResourceLocation(StudyMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }

    private void wallItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(), mcLoc("block/wall_inventory"))
                .texture("wall", new ResourceLocation(StudyMod.MOD_ID,
                        "block/" + ForgeRegistries.BLOCKS.getKey(baseBlock.get()).getPath()));
    }
    private void trapdoorItem(RegistryObject<Block> block) {
        this.withExistingParent(ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath() + "_bottom"));
    }
// thx for oskar-jas1! ^w^ trapdoorItem and evenSimplerBlockItem methods are from him
// (source: https://github.com/oskar-jas1/Forge-First-Mod-1.20.6/blob/master/src/main/java/net/o/tutorialmod/datagen/ModItemModelProvider.java)
    private void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(StudyMod.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(StudyMod.MOD_ID, "item/" + item.getId().getPath()));
    }
}

