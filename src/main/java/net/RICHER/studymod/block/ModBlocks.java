package net.RICHER.studymod.block;

import net.RICHER.studymod.block.custom.SoundBlock;
import net.RICHER.studymod.item.ModItems;
import net.RICHER.studymod.StudyMod;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, StudyMod.MOD_ID);

    public static final RegistryObject<Block> CUBIUM_BLOCK = registerBlock("cubium_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> RAW_CUBIUM_BLOCK = registerBlock("raw_cubium_block",
            () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> SOUND_BLOCK = registerBlock("sound_block",
                () -> new SoundBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_PLANKS).requiresCorrectToolForDrops().strength(2f)));

    public static final RegistryObject<Block> CUBIUM_ORE = registerBlock("cubium_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,7), BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_ORE)
                                .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_CUBIUM_ORE = registerBlock("deepslate_cubium_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,7), BlockBehaviour.Properties.ofFullCopy(Blocks.DEEPSLATE_IRON_ORE)
                                .requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> NETHER_CUBIUM_ORE = registerBlock("nether_cubium_ore",
            () -> new DropExperienceBlock(UniformInt.of(4,6), BlockBehaviour.Properties.ofFullCopy(Blocks.NETHER_QUARTZ_ORE)
                    .strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> END_CUBIUM_ORE = registerBlock("end_cubium_ore",
            () -> new DropExperienceBlock(UniformInt.of(5,6), BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE)
                    .strength(2.2f).requiresCorrectToolForDrops()));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
