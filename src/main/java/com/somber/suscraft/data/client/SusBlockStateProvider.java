package com.somber.suscraft.data.client;

import com.somber.suscraft.Suscraft;
import com.somber.suscraft.setup.SusBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SusBlockStateProvider extends BlockStateProvider {

    public SusBlockStateProvider(DataGenerator generator, ExistingFileHelper helper) {
        super(generator, Suscraft.MOD_ID, helper);
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(SusBlocks.SUSITE_ORE.get());
        simpleBlock(SusBlocks.SUSITE_BLOCK.get());
        simpleBlock(SusBlocks.SUSITE_FURNACE.get());
    }
}
