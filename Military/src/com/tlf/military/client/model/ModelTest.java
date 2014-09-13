package com.tlf.military.client.model;

import com.tlf.military.entity.bases.vehicle.EntityVehicleBase;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelTest extends ModelBase
{
	public ModelRenderer body;
	
	public ModelTest()
	{
		this.body = new ModelRenderer(this, 0, 0).setTextureSize(64, 64);
		this.body.addBox(-6.0F, -3.0F, -9.0F, 12, 6, 18, 0.0F);
	}
	
	/**
	 * Sets the models various rotation angles then renders the model.
	 */
	@Override
	public void render(Entity par1Entity, float par2, float par3, float par4, float par5, float par6, float par7)
	{
		if (par1Entity instanceof EntityVehicleBase) {
			EntityVehicleBase entityVB = (EntityVehicleBase)par1Entity;
			
			this.body.rotateAngleX = entityVB.getRoll();
			this.body.render(par7);
		}
	}
}