package com.somber.suscraft.data.recipes;

import com.somber.suscraft.Suscraft;
import com.somber.suscraft.setup.SusArmorItems;
import com.somber.suscraft.setup.SusItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;

import java.util.function.Consumer;

public class SusArmorRecipesProvider extends RecipeProvider {

    public SusArmorRecipesProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {

        ShapedRecipeBuilder.shaped(SusArmorItems.SUSITE_HELMET.get())
                .define('#', SusItems.SUSITE_INGOT.get())
                .pattern("###")
                .pattern("# #")
                .pattern("   ")
                .unlockedBy("has_item", has(SusItems.SUSITE_INGOT.get()))
                .save(consumer, Suscraft.getID("susite_helmet"));

        ShapedRecipeBuilder.shaped(SusArmorItems.SUSITE_CHESTPLATE.get())
                .define('#', SusItems.SUSITE_INGOT.get())
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(SusItems.SUSITE_INGOT.get()))
                .save(consumer, Suscraft.getID("susite_chestplate"));

        ShapedRecipeBuilder.shaped(SusArmorItems.SUSITE_LEGGINGS.get())
                .define('#', SusItems.SUSITE_INGOT.get())
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_item", has(SusItems.SUSITE_INGOT.get()))
                .save(consumer, Suscraft.getID("susite_leggings"));

        ShapedRecipeBuilder.shaped(SusArmorItems.SUSITE_BOOTS.get())
                .define('#', SusItems.SUSITE_INGOT.get())
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .unlockedBy("has_item", has(SusItems.SUSITE_INGOT.get()))
                .save(consumer, Suscraft.getID("susite_boots"));

    }

}
