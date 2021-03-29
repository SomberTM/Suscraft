package com.somber.suscraft.setup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;

public class SusItems {

    public static final RegistryObject<Item> SUSITE_INGOT = Registration.ITEMS.register("susite_ingot", () -> {
        Item.Properties properties = new Item.Properties();
        properties.tab(ItemGroup.TAB_MATERIALS);
        Item item = new Item(properties);
        return item;
    });

    public static final RegistryObject<Item> SUS_PLACEHOLDER = Registration.ITEMS.register("sus_placeholder", () -> {
        Item.Properties properties = new Item.Properties();
        properties.tab(ItemGroup.TAB_MATERIALS);
        properties.stacksTo(1);
        Item item = new Item(properties);
        return item;
    });

    static void register() {}

}
