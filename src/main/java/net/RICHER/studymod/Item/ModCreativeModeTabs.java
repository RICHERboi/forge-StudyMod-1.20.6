package net.RICHER.studymod.Item;

import net.RICHER.studymod.Block.ModBlocks;
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
                       output.accept(ModItems.RAW_CUBIUM.get());
                       output.accept(ModItems.CUBIUM.get());
                       output.accept(ModItems.METAL_DETECTOR.get());

                       output.accept(ModBlocks.CUBIUM_BLOCK.get());
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
