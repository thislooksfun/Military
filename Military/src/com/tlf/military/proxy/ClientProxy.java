package com.tlf.military.proxy;

import com.tlf.military.client.render.RenderTest;
import com.tlf.military.entity.bases.vehicle.EntityVehicleBase;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy
{
	@Override
	public void registerThings()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntityVehicleBase.class, new RenderTest());
	}
}
