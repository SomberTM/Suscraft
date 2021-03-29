package com.somber.suscraft.setup;

import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.common.world.BiomeGenerationSettingsBuilder;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;

public class SusFeatures {

    static void register(IEventBus eventBus) {
        eventBus.addListener(EventPriority.HIGH, SusFeatures::initializeOres);
    }

    public static void initializeOres(final BiomeLoadingEvent event) {
        BiomeGenerationSettingsBuilder builder = event.getGeneration();

        OreFeatureConfig oreConfig = new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, SusBlocks.SUSITE_ORE.get().defaultBlockState(), 6);
        TopSolidRangeConfig topSolidConfig = new TopSolidRangeConfig(40, 0, 60);
        builder.addFeature(
                GenerationStage.Decoration.UNDERGROUND_ORES,
                Feature.ORE.configured(oreConfig).decorated(Placement.RANGE.configured(topSolidConfig)).squared().count(10)
        );

    }

}
