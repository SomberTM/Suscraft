package com.somber.suscraft.data;

import com.somber.suscraft.Suscraft;
import com.somber.suscraft.data.client.SusBlockStateProvider;
import com.somber.suscraft.data.client.SusItemModelProvider;
import com.somber.suscraft.data.recipes.SusArmorRecipesProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = Suscraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    private DataGenerators() {}

    @SubscribeEvent
    public  static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper helper = event.getExistingFileHelper();

        generator.addProvider(new SusBlockStateProvider(generator, helper));
        generator.addProvider(new SusItemModelProvider(generator, helper));

        SusBlockTagsProvider blockTagsProvider = new SusBlockTagsProvider(generator, helper);
        generator.addProvider(blockTagsProvider);
        generator.addProvider(new SusItemTagsProvider(generator, blockTagsProvider, helper));

        generator.addProvider(new SusLootTableProvider(generator));

        generator.addProvider(new SusRecipeProvider(generator));
        generator.addProvider(new SusArmorRecipesProvider(generator));

    }

}
