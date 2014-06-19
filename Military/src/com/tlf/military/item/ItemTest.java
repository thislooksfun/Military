package com.tlf.military.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.tlf.military.entity.EntityTest;

import cpw.mods.fml.common.FMLCommonHandler;

public class ItemTest extends Item
{
	@Override
	public IIcon getIconFromDamage(int par1)
    {
		//return this.itemIcon;
        return Items.blaze_rod.getIconFromDamage(par1);
    }
	
	@Override
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
		if (!par3World.isRemote)
		{
			EntityTest entityTest = new EntityTest(par3World);
			entityTest.setLocationAndAngles((double)par4 + 0.5D, (double)par5 + 1.0D, (double)par6 + 0.5D, 0.0F, 0.0F);
	        par3World.spawnEntityInWorld(entityTest);
	        System.out.println("Spawned entity on side " + FMLCommonHandler.instance().getEffectiveSide());
	        return true;
		}
		
		return false;
    }
}