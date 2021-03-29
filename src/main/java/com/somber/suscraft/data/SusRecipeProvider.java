package com.somber.suscraft.data;

import com.somber.suscraft.Suscraft;
import com.somber.suscraft.setup.SusBlocks;
import com.somber.suscraft.setup.SusItems;

import net.minecraft.block.Blocks;
import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;

import java.util.function.Consumer;

public class SusRecipeProvider extends RecipeProvider {

    public SusRecipeProvider(DataGenerator generator) { super(generator); }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

        ShapelessRecipeBuilder.shapeless(SusItems.SUSITE_INGOT.get(), 9)
                .requires(SusBlocks.SUSITE_BLOCK.get())
                .unlockedBy("has_item", has(SusBlocks.SUSITE_BLOCK.get()))
                .save(consumer, Suscraft.getID("susite_ingot"));

        ShapedRecipeBuilder.shaped(SusBlocks.SUSITE_FURNACE.get())
                .define('F', Blocks.FURNACE)
                .define('#', SusItems.SUSITE_INGOT.get())
                .pattern("###")
                .pattern("#F#")
                .pattern("###")
                .unlockedBy("has_item", has(SusItems.SUSITE_INGOT.get()))
                .save(consumer, Suscraft.getID("susite_furnace"));

        ShapedRecipeBuilder.shaped(SusBlocks.SUSITE_BLOCK.get())
                .define('#', SusItems.SUSITE_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(SusItems.SUSITE_INGOT.get()))
                .save(consumer, Suscraft.getID("susite_block"));

        // Sus pickaxe (cyan)
        ShapedRecipeBuilder.shaped(SusItems.SUS_PLACEHOLDER.get())
                .define('#', SusItems.SUSITE_INGOT.get())
                .define('|', Tags.Items.RODS_WOODEN)
                .pattern("###")
                .pattern(" | ")
                .pattern(" | ")
                .unlockedBy("has_item", has(SusItems.SUSITE_INGOT.get()))
                .save(consumer, Suscraft.getID("susite_pickaxe"));

        CookingRecipeBuilder.smelting(Ingredient.of(SusBlocks.SUSITE_ORE.get()), SusItems.SUSITE_INGOT.get(), 0.5F, 200)
                .unlockedBy("has_item", has(SusItems.SUSITE_INGOT.get()))
                .save(consumer, Suscraft.getID("susite_ingot_smelting"));

        CookingRecipeBuilder.blasting(Ingredient.of(SusBlocks.SUSITE_ORE.get()), SusItems.SUSITE_INGOT.get(), 0.5F, 100)
                .unlockedBy("has_item", has(SusItems.SUSITE_INGOT.get()))
                .save(consumer, Suscraft.getID("susite_ingot_blasting"));

    }

}
