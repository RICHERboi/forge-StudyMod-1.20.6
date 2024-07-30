package net.RICHER.studymod.util;

import net.RICHER.studymod.StudyMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> METAL_DETECTOR_VALUABLES = tag("metal_detector_valuables");
        public static final TagKey<Block> NEEDS_CUBIUM_TOOL = tag("needs_cubium_tool");
        public static final TagKey<Block> INCORRECT_FOR_CUBIUM_TOOL = tag("incorrect_for_cubium_tool");

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(StudyMod.MOD_ID, name));
        }
    }

    private static class Items {

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(new ResourceLocation(StudyMod.MOD_ID, name));
        }
    }
}
