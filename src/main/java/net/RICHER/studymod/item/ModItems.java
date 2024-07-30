package net.RICHER.studymod.item;

import net.RICHER.studymod.item.custom.FuelItem;
import net.RICHER.studymod.item.custom.MetalDetectorItem;
import net.RICHER.studymod.StudyMod;
import net.minecraft.world.item.*;
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
            () -> new MetalDetectorItem(new Item.Properties().stacksTo(1)
                    .rarity(Rarity.UNCOMMON).durability(128)));
    public static final RegistryObject<Item> PINE_CONE = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 100));
    public static final RegistryObject<Item> CUBIUM_STAFF = ITEMS.register("cubium_staff",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE).stacksTo(1)));

    public static final RegistryObject<Item> CUBIUM_SWORD = ITEMS.register("cubium_sword",
            () -> new SwordItem(ModToolTiers.TIER_CUBIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.TIER_CUBIUM, 3, -2.4f))));
    public static final RegistryObject<Item> CUBIUM_PICKAXE = ITEMS.register("cubium_pickaxe",
            () -> new PickaxeItem(ModToolTiers.TIER_CUBIUM, new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(ModToolTiers.TIER_CUBIUM, 1, -2.8f))));
    public static final RegistryObject<Item> CUBIUM_AXE = ITEMS.register("cubium_axe",
            () -> new AxeItem(ModToolTiers.TIER_CUBIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.TIER_CUBIUM, 6, -3.1f))));
    public static final RegistryObject<Item> CUBIUM_SHOVEL = ITEMS.register("cubium_shovel",
            () -> new ShovelItem(ModToolTiers.TIER_CUBIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.TIER_CUBIUM, 1, -3f))));
    public static final RegistryObject<Item> CUBIUM_HOE = ITEMS.register("cubium_hoe",
            () -> new HoeItem(ModToolTiers.TIER_CUBIUM, new Item.Properties()
                    .attributes(SwordItem.createAttributes(ModToolTiers.TIER_CUBIUM, -1, 0f))));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
