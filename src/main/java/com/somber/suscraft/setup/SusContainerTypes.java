package com.somber.suscraft.setup;

import com.somber.suscraft.block.susitefurnace.SusiteFurnaceContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class SusContainerTypes {

    static void register() {}

    public static final RegistryObject<ContainerType<SusiteFurnaceContainer>> SUSITE_FURNACE_CONTAINER_TYPE = Registration.CONTAINERS
            .register("susite_furnace", () -> IForgeContainerType.create(SusiteFurnaceContainer::new));

}
