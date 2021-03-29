package com.somber.suscraft.setup;

import com.somber.suscraft.block.susitefurnace.SusiteFurnaceTileEntity;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SusTileEntityTypes {

    public static final RegistryObject<TileEntityType<SusiteFurnaceTileEntity>> SUSITE_FURNACE = register("susite_furnace", SusiteFurnaceTileEntity::new, SusBlocks.SUSITE_FURNACE);

    private static <T extends TileEntity> RegistryObject<TileEntityType<T>> register(String name, Supplier<T> factory, RegistryObject<? extends Block> block) {
        return Registration.TILE_ENTITIES.register(name, () -> TileEntityType.Builder.of(factory, block.get()).build(null));
    }

    static void register() {}

}
