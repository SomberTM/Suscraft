package com.somber.suscraft.setup;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class SusArmorItems {

    public static final RegistryObject<Item> SUSITE_HELMET = Registration.ITEMS.register("susite_helmet", () -> {
        Item.Properties properties = new Item.Properties();
        properties.tab(ItemGroup.TAB_COMBAT);
        Item item = new ArmorItem(ArmorMaterial.IRON, EquipmentSlotType.HEAD, properties);
        return item;
    });

    public static final RegistryObject<Item> SUSITE_CHESTPLATE = Registration.ITEMS.register("susite_chestplate", () -> {
        Item.Properties properties = new Item.Properties();
        properties.tab(ItemGroup.TAB_COMBAT);
        Item item = new ArmorItem(ArmorMaterial.IRON, EquipmentSlotType.CHEST, properties);
        return item;
    });

    public static final RegistryObject<Item> SUSITE_LEGGINGS = Registration.ITEMS.register("susite_leggings", () -> {
        Item.Properties properties = new Item.Properties();
        properties.tab(ItemGroup.TAB_COMBAT);
        Item item = new ArmorItem(ArmorMaterial.IRON, EquipmentSlotType.LEGS, properties);
        return item;
    });

    public static final RegistryObject<Item> SUSITE_BOOTS = Registration.ITEMS.register("susite_boots", () -> {
        Item.Properties properties = new Item.Properties();
        properties.tab(ItemGroup.TAB_COMBAT);
        Item item = new ArmorItem(ArmorMaterial.IRON, EquipmentSlotType.FEET, properties);
        return item;
    });

    static void register() {}

}
