package net.RICHER.studymod.datagen;

import net.RICHER.studymod.StudyMod;
import net.RICHER.studymod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
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

        stairsBlock(((StairBlock) ModBlocks.CUBIUM_STAIRS.get()), blockTexture(ModBlocks.CUBIUM_BLOCK.get()));
        slabBlock(((SlabBlock) ModBlocks.CUBIUM_SLAB.get()), blockTexture(ModBlocks.CUBIUM_BLOCK.get()), blockTexture(ModBlocks.CUBIUM_BLOCK.get()));

        buttonBlock(((ButtonBlock) ModBlocks.CUBIUM_BUTTON.get()), blockTexture(ModBlocks.CUBIUM_BLOCK.get()));
        pressurePlateBlock(((PressurePlateBlock) ModBlocks.CUBIUM_PRESSURE_PLATE.get()), blockTexture(ModBlocks.CUBIUM_BLOCK.get()));

        fenceBlock(((FenceBlock) ModBlocks.CUBIUM_FENCE.get()), blockTexture(ModBlocks.CUBIUM_BLOCK.get()));
        fenceGateBlock(((FenceGateBlock) ModBlocks.CUBIUM_FENCE_GATE.get()), blockTexture(ModBlocks.CUBIUM_BLOCK.get()));
        wallBlock(((WallBlock) ModBlocks.CUBIUM_WALL.get()), blockTexture(ModBlocks.CUBIUM_BLOCK.get()));

        doorBlockWithRenderType(((DoorBlock) ModBlocks.CUBIUM_DOOR.get()), modLoc("block/cubium_door_bottom"),
                modLoc("block/cubium_door_top"), "cutout");
        trapdoorBlockWithRenderType(((TrapDoorBlock) ModBlocks.CUBIUM_TRAPDOOR.get()), modLoc("block/cubium_trapdoor"), true, "cutout");
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
