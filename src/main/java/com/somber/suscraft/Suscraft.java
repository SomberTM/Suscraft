package com.somber.suscraft;

import com.somber.suscraft.setup.Registration;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Suscraft.MOD_ID)
public class Suscraft
{

    public static final String MOD_ID = "suscraft";

    public static ResourceLocation getID(String path) { return new ResourceLocation(Suscraft.MOD_ID, path); }

    public Suscraft() {

        Registration.register();

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

}
