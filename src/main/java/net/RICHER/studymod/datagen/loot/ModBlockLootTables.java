package net.RICHER.studymod.datagen.loot;

import net.RICHER.studymod.block.ModBlocks;
import net.RICHER.studymod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.CUBIUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_CUBIUM_BLOCK.get());
        this.dropSelf(ModBlocks.SOUND_BLOCK.get());

        this.dropSelf(ModBlocks.CUBIUM_STAIRS.get());
        this.dropSelf(ModBlocks.CUBIUM_FENCE.get());
        this.dropSelf(ModBlocks.CUBIUM_FENCE_GATE.get());
        this.dropSelf(ModBlocks.CUBIUM_WALL.get());
        this.dropSelf(ModBlocks.CUBIUM_BUTTON.get());
        this.dropSelf(ModBlocks.CUBIUM_PRESSURE_PLATE.get());
        this.dropSelf(ModBlocks.CUBIUM_TRAPDOOR.get());

        this.add(ModBlocks.CUBIUM_SLAB.get(),
                block -> createSlabItemTable(ModBlocks.CUBIUM_SLAB.get()));
        this.add(ModBlocks.CUBIUM_DOOR.get(),
                block -> createDoorTable(ModBlocks.CUBIUM_DOOR.get()));

        this.add(ModBlocks.CUBIUM_ORE.get(),
                block -> createCubiumOreDrops(ModBlocks.CUBIUM_ORE.get(), ModItems.RAW_CUBIUM.get()));
        this.add(ModBlocks.DEEPSLATE_CUBIUM_ORE.get(),
                block -> createCubiumOreDrops(ModBlocks.DEEPSLATE_CUBIUM_ORE.get(), ModItems.RAW_CUBIUM.get()));
        this.add(ModBlocks.NETHER_CUBIUM_ORE.get(),
                block -> createMinusCubiumOreDrops(ModBlocks.NETHER_CUBIUM_ORE.get(), ModItems.RAW_CUBIUM.get()));
        this.add(ModBlocks.END_CUBIUM_ORE.get(),
                block -> createPlusCubiumOreDrops(ModBlocks.END_CUBIUM_ORE.get(), ModItems.RAW_CUBIUM.get()));
    }

    protected LootTable.Builder createCubiumOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 4.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.FORTUNE))));
    }
    protected LootTable.Builder createPlusCubiumOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 6.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.FORTUNE))));
    }
    protected LootTable.Builder createMinusCubiumOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
                        .apply(ApplyBonusCount.addOreBonusCount(Enchantments.FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
