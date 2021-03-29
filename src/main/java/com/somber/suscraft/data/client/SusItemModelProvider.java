package com.somber.suscraft.data.client;

import com.somber.suscraft.Suscraft;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class SusItemModelProvider extends ItemModelProvider {

    public SusItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Suscraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent("susite_ore", modLoc("block/susite_ore"));
        withExistingParent("susite_block", modLoc("block/susite_block"));
        withExistingParent("susite_furnace", modLoc("block/susite_furnace"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        buildItem("susite_ingot", itemGenerated);
    }

    private ItemModelBuilder buildItem(String name, ModelFile generated) {
        return getBuilder(name).parent(generated).texture("layer0", String.format("item/%s", name));
    }

}
