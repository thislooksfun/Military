package com.tlf.military.common;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;

import com.tlf.military.entity.EntityTest;
import com.tlf.military.entity.bases.vehicle.EntityVehicleBase;
import com.tlf.military.item.ItemTest;
import com.tlf.military.proxy.ServerProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(name = Military.NAME, modid = Military.MODID, version = Military.VERSION)
public class Military
{
	public static final String MODID = "military";
	public static final String NAME = "Military";
	public static final String VERSION = "0.0.1 pre-alpha";
	
	@Instance(Military.MODID)
	public static Military instance;
	
	@SidedProxy(clientSide = "com.tlf.military.proxy.ClientProxy", serverSide = "com.tlf.military.proxy.ServerProxy")
	public static ServerProxy proxy;
	
	public static Item itemTest;
	
	@EventHandler
	public void onPreInit(FMLPreInitializationEvent event)
	{
		itemTest = new ItemTest().setUnlocalizedName("itemTest").setCreativeTab(CreativeTabs.tabTransport);
		GameRegistry.registerItem(itemTest, "itemTest");
	}
	
	@EventHandler
	public void onInit(FMLInitializationEvent event)
	{
		proxy.registerThings();
		EntityRegistry.registerModEntity(EntityVehicleBase.class, "EntityVehicleBase", 0, instance, 80, 3, true);
		
		EntityList.addMapping(EntityTest.class, "Test", 0, 113213, 3523523);
	}
	
	@EventHandler
	public void onPostInit(FMLPostInitializationEvent event)
	{
		System.out.println(NAME + " " + VERSION + " loaded!");
	}
}