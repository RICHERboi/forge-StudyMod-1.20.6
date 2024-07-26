package net.RICHER.studymod.item;

import net.RICHER.studymod.item.custom.FuelItem;
import net.RICHER.studymod.item.custom.MetalDetectorItem;
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
    public static final RegistryObject<Item> CUBERRY = ITEMS.register("cuberry",
            () -> new Item(new Item.Properties().food(ModFoods.CUBERRY)));
    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new MetalDetectorItem(new Item.Properties().durability(128)));
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 100));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
