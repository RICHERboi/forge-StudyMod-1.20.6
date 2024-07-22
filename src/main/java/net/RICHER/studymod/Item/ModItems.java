package net.RICHER.studymod.Item;

import net.RICHER.studymod.Item.Custom.MetalDetectorItem;
import net.RICHER.studymod.StudyMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, StudyMod.MOD_ID);

    public static final RegistryObject<Item> CUBIUM = ITEMS.register("cubium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAW_CUBIUM = ITEMS.register("raw_cubium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(128)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
