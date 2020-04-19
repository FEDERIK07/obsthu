package net.mcreator.obsidian;

import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.client.model.obj.OBJLoader;

public class ClientProxyWaterandLava implements IProxyWaterandLava {
	@Override
	public void init(FMLInitializationEvent event) {
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		OBJLoader.INSTANCE.addDomain("obsidian");
	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
	}
}
