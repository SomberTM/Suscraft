package com.somber.suscraft.data;

import com.somber.suscraft.Suscraft;
import com.somber.suscraft.setup.SusArmorItems;
import com.somber.suscraft.setup.SusItems;
import com.somber.suscraft.setup.SusTags;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nullable;

public class SusItemTagsProvider extends ItemTagsProvider {

    public SusItemTagsProvider(DataGenerator generator, BlockTagsProvider provider, @Nullable ExistingFileHelper existingFileHelper) {
        super(generator, provider, Suscraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        // Copy block tag to "block" item tag
        this.copy(SusTags.Blocks.ORES_SUSITE, SusTags.Items.ORES_SUSITE);
        this.copy(SusTags.Blocks.STORAGE_BLOCKS_SUSITE, SusTags.Items.STORAGE_BLOCKS_SUSITE);
        this.copy(SusTags.Blocks.TILE_ENTITY_SUSITE_FURNACE, SusTags.Items.TILE_ENTITY_SUSITE_FURNACE);

        this.tag(SusTags.Items.INGOTS_SUSITE).add(SusItems.SUSITE_INGOT.get());
        // Add to common forge tag
        this.tag(Tags.Items.INGOTS).add(SusItems.SUSITE_INGOT.get());

        this.tag(SusTags.Items.ARMOR_SUSITE_HELMET).add(SusArmorItems.SUSITE_HELMET.get());
        this.tag(SusTags.Items.ARMOR_SUSITE_CHESTPLATE).add(SusArmorItems.SUSITE_CHESTPLATE.get());
        this.tag(SusTags.Items.ARMOR_SUSITE_LEGGINGS).add(SusArmorItems.SUSITE_LEGGINGS.get());
        this.tag(SusTags.Items.ARMOR_SUSITE_BOOTS).add(SusArmorItems.SUSITE_BOOTS.get());
    }

}
