package com.somber.suscraft.setup;

import com.somber.suscraft.block.susitefurnace.SusiteFurnaceBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class SusBlocks {

    public static final RegistryObject<Block> SUSITE_ORE = register("susite_ore", () -> {
        AbstractBlock.Properties properties = AbstractBlock.Properties.of(Material.STONE);
        properties.strength(3, 10)
                .harvestLevel(2)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops();
        Block block = new Block(properties);
        return block;
    });

    public static final RegistryObject<Block> SUSITE_BLOCK = register("susite_block", () -> {
        AbstractBlock.Properties properties = AbstractBlock.Properties.of(Material.METAL);
        properties.strength(3, 10)
                .harvestLevel(2)
                .sound(SoundType.METAL)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops();
        Block block = new Block(properties);
        return block;
    });

    public static final RegistryObject<SusiteFurnaceBlock> SUSITE_FURNACE = register("susite_furnace", () -> {
        AbstractBlock.Properties properties = AbstractBlock.Properties.of(Material.STONE);
        properties.strength(4, 20)
                .harvestLevel(1)
                .sound(SoundType.STONE)
                .harvestTool(ToolType.PICKAXE)
                .requiresCorrectToolForDrops();
        SusiteFurnaceBlock block = new SusiteFurnaceBlock(properties);
        return block;
    });

    static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoItem(String name, Supplier<T> block) {
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> obj = registerNoItem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(obj.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        return obj;
    }

}
