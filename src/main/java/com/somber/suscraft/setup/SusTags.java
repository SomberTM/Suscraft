package com.somber.suscraft.setup;

import com.somber.suscraft.Suscraft;
import com.somber.suscraft.block.susitefurnace.SusiteFurnaceBlock;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

import java.util.function.Function;

public class SusTags {

    private static final class Path {
        public static final String ORES_SUSITE = "ores/susite";
        public static final String STORAGE_BLOCKS_SUSITE = "storage_blocks/susite";
        public static final String TILE_ENTITY_SUSITE_FURNACE = "tile_entity/susite_furnace";

        public static final String INGOTS_SUSITE = "ingots/susite";

        public static final String ARMOR_SUSITE_HELMET = "armor/susite_helmet";
        public static final String ARMOR_SUSITE_CHESTPLATE = "armor/susite_chestplate";
        public static final String ARMOR_SUSITE_LEGGINGS = "armor/susite_leggings";
        public static final String ARMOR_SUSITE_BOOTS = "armor/susite_boots";
    }

    private static final class Bind {
        public static final Function<String, ITag.INamedTag<Block>> Block = BlockTags::bind;
        public static final Function<String, ITag.INamedTag<Item>> Item = ItemTags::bind;

        public static ITag.INamedTag<Block> forgeBlock(String path) { return forge(path, Bind.Block); }
        public static ITag.INamedTag<Item> forgeItem(String path) { return forge(path, Bind.Item); }
    }

    private static <T> ITag.INamedTag<T> bind(String path, String base, Function<String, ITag.INamedTag<T>> binder) {
        return binder.apply(new ResourceLocation(base, path).toString());
    }

    private static <T> ITag.INamedTag<T> forge(String path, Function<String, ITag.INamedTag<T>> binder) {
        return bind(path, "forge", binder);
    }

    private static <T> ITag.INamedTag<T> mod(String path, Function<String, ITag.INamedTag<T>> binder) {
        return bind(path, Suscraft.MOD_ID, binder);
    }

    public static final class Blocks {
        public static final ITag.INamedTag<Block> ORES_SUSITE = Bind.forgeBlock(Path.ORES_SUSITE);
        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_SUSITE = Bind.forgeBlock(Path.STORAGE_BLOCKS_SUSITE);
        public static final ITag.INamedTag<Block> TILE_ENTITY_SUSITE_FURNACE = Bind.forgeBlock(Path.TILE_ENTITY_SUSITE_FURNACE);
    }

    public static final class Items {
        // "Block" items
        public static final ITag.INamedTag<Item> ORES_SUSITE = Bind.forgeItem(Path.ORES_SUSITE);
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_SUSITE = Bind.forgeItem(Path.STORAGE_BLOCKS_SUSITE);
        public static final ITag.INamedTag<Item> TILE_ENTITY_SUSITE_FURNACE = Bind.forgeItem(Path.TILE_ENTITY_SUSITE_FURNACE);

        // Items
        public static final ITag.INamedTag<Item> INGOTS_SUSITE = Bind.forgeItem(Path.INGOTS_SUSITE);

        // Armor
        public static final ITag.INamedTag<Item> ARMOR_SUSITE_HELMET = Bind.forgeItem(Path.ARMOR_SUSITE_HELMET);
        public static final ITag.INamedTag<Item> ARMOR_SUSITE_CHESTPLATE = Bind.forgeItem(Path.ARMOR_SUSITE_CHESTPLATE);
        public static final ITag.INamedTag<Item> ARMOR_SUSITE_LEGGINGS = Bind.forgeItem(Path.ARMOR_SUSITE_LEGGINGS);
        public static final ITag.INamedTag<Item> ARMOR_SUSITE_BOOTS = Bind.forgeItem(Path.ARMOR_SUSITE_BOOTS);
    }

}
