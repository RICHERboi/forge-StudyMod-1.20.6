package net.RICHER.studymod.datagen;

import net.RICHER.studymod.StudyMod;
import net.RICHER.studymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, StudyMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CUBIUM_BLOCK);
        blockWithItem(ModBlocks.RAW_CUBIUM_BLOCK);

        blockWithItem(ModBlocks.CUBIUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_CUBIUM_ORE);
        blockWithItem(ModBlocks.NETHER_CUBIUM_ORE);
        blockWithItem(ModBlocks.END_CUBIUM_ORE);
        blockWithItem(ModBlocks.SOUND_BLOCK);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
