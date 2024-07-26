package net.RICHER.studymod.item;

import net.RICHER.studymod.block.ModBlocks;
import net.RICHER.studymod.StudyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, StudyMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> STUDY_TAB = CREATIVE_MODE_TABS.register("study_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.CUBIUM.get()))
                    .title(Component.translatable("creativetab.study_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.CUBERRY.get());
                        output.accept(ModItems.METAL_DETECTOR.get());
                        output.accept(ModItems.PINE_CONE.get());

                        output.accept(ModBlocks.SOUND_BLOCK.get());

                        output.accept(ModItems.CUBIUM.get());
                        output.accept(ModBlocks.CUBIUM_BLOCK.get());

                        output.accept(ModBlocks.CUBIUM_STAIRS.get());
                        output.accept(ModBlocks.CUBIUM_SLAB.get());
                        output.accept(ModBlocks.CUBIUM_WALL.get());
                        output.accept(ModBlocks.CUBIUM_FENCE.get());
                        output.accept(ModBlocks.CUBIUM_FENCE_GATE.get());
                        output.accept(ModBlocks.CUBIUM_DOOR.get());
                        output.accept(ModBlocks.CUBIUM_TRAPDOOR.get());
                        output.accept(ModBlocks.CUBIUM_BUTTON.get());
                        output.accept(ModBlocks.CUBIUM_PRESSURE_PLATE.get());

                        output.accept(ModItems.RAW_CUBIUM.get());
                        output.accept(ModBlocks.RAW_CUBIUM_BLOCK.get());

                        output.accept(ModBlocks.CUBIUM_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_CUBIUM_ORE.get());
                        output.accept(ModBlocks.NETHER_CUBIUM_ORE.get());
                        output.accept(ModBlocks.END_CUBIUM_ORE.get());
                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
