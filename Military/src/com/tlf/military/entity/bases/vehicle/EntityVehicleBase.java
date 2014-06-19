package com.tlf.military.entity.bases.vehicle;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityVehicleBase extends EntityLivingBase
{
	//DataWatcher object ids
	public static final int ROLL = 10;
	
	public EntityVehicleBase(World par1World) {
		super(par1World);
	}
	
	@Override
	protected void entityInit()
	{
		super.entityInit();
		this.dataWatcher.addObject(ROLL, new Float(0.0F)); //Entity roll
	}
	
	@Override
	public void writeEntityToNBT(NBTTagCompound tag)
	{
		tag.setFloat("Roll", this.getRoll());
	}
	
	@Override
	public void readEntityFromNBT(NBTTagCompound tag)
	{
		this.setRoll(tag.getFloat("Roll"));
	}
	
	//Roll
	public void setRoll(float par1) {
		this.dataWatcher.updateObject(ROLL, MathHelper.clamp_float(par1, -90.0F, 90.0F));
	}
	public float getRoll() {
		return this.dataWatcher.getWatchableObjectFloat(ROLL);
	}
	
	//Unused, but required methods
	@Override
	public ItemStack getHeldItem() { return null;}
	@Override
	public ItemStack getEquipmentInSlot(int var1) { return null; }
	@Override
	public void setCurrentItemOrArmor(int var1, ItemStack var2) {}
	@Override
	public ItemStack[] getLastActiveItems() { return new ItemStack[0]; }
}