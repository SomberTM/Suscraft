package com.somber.suscraft.data;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import com.somber.suscraft.setup.Registration;
import com.somber.suscraft.setup.SusBlocks;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class SusLootTableProvider extends LootTableProvider {

    public SusLootTableProvider(DataGenerator generator) { super(generator); }

    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
                Pair.of(SusBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((rloc, lootTable) -> {
            LootTableManager.validate(validationtracker, rloc, lootTable);
        });
    }

    public static class SusBlockLootTables extends BlockLootTables {

        @Override
        protected void addTables() {
            dropSelf(SusBlocks.SUSITE_ORE.get());
            dropSelf(SusBlocks.SUSITE_BLOCK.get());
            dropSelf(SusBlocks.SUSITE_FURNACE.get());
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries()
                    .stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }

    }

}
