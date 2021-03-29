package com.somber.suscraft.data;

import com.somber.suscraft.Suscraft;
import com.somber.suscraft.setup.SusBlocks;
import com.somber.suscraft.setup.SusTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class SusBlockTagsProvider extends BlockTagsProvider {

    public SusBlockTagsProvider(DataGenerator generator, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, Suscraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.tag(SusTags.Blocks.ORES_SUSITE).add(SusBlocks.SUSITE_ORE.get());
        this.tag(Tags.Blocks.ORES).add(SusBlocks.SUSITE_ORE.get());

        this.tag(SusTags.Blocks.STORAGE_BLOCKS_SUSITE).add(SusBlocks.SUSITE_BLOCK.get());
        this.tag(Tags.Blocks.STORAGE_BLOCKS).add(SusBlocks.SUSITE_BLOCK.get());

        this.tag(SusTags.Blocks.TILE_ENTITY_SUSITE_FURNACE).add(SusBlocks.SUSITE_FURNACE.get());
    }

}
