package net.RICHER.studymod.datagen;

import net.RICHER.studymod.StudyMod;
import net.RICHER.studymod.block.ModBlocks;
import net.RICHER.studymod.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, StudyMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        this.tag(ModTags.Blocks.METAL_DETECTOR_VALUABLES)
                .add(ModBlocks.CUBIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_CUBIUM_ORE.get(),
                        ModBlocks.NETHER_CUBIUM_ORE.get(),
                        ModBlocks.END_CUBIUM_ORE.get(),
                        Blocks.RAW_IRON_BLOCK)
                .addTag(Tags.Blocks.ORES);

        this.tag(ModTags.Blocks.INCORRECT_FOR_CUBIUM_TOOL)
                .addTag(Tags.Blocks.ORES_NETHERITE_SCRAP)
                .addTag(Tags.Blocks.OBSIDIAN);

        this.tag(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.CUBIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_CUBIUM_ORE.get(),
                        ModBlocks.NETHER_CUBIUM_ORE.get(),
                        ModBlocks.CUBIUM_BLOCK.get(),
                        ModBlocks.RAW_CUBIUM_BLOCK.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.END_CUBIUM_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL);

        this.tag(ModTags.Blocks.NEEDS_CUBIUM_TOOL)
                .add(Blocks.REINFORCED_DEEPSLATE);

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.CUBIUM_ORE.get(),
                        ModBlocks.DEEPSLATE_CUBIUM_ORE.get(),
                        ModBlocks.NETHER_CUBIUM_ORE.get(),
                        ModBlocks.END_CUBIUM_ORE.get(),
                        ModBlocks.CUBIUM_BLOCK.get(),
                        ModBlocks.RAW_CUBIUM_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_AXE)
                .add(ModBlocks.SOUND_BLOCK.get());

        this.tag(BlockTags.FENCES).add(ModBlocks.CUBIUM_FENCE.get());
        this.tag(BlockTags.FENCE_GATES).add(ModBlocks.CUBIUM_FENCE_GATE.get());
        this.tag(BlockTags.WALLS).add(ModBlocks.CUBIUM_WALL.get());

    }
}
