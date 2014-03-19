package fr.mcnanotech.kevin_68.nanotechmod.ultimategravisuite.common;

import ic2.api.item.ElectricItem;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class USGCommonEventHandler
{
	@SubscribeEvent
	public void onTickPlayer(TickEvent.PlayerTickEvent event)
	{
			ItemStack chestPlate = event.player.getCurrentArmor(2);
			if(chestPlate != null && chestPlate.getItem() == UltimateGraviSuiteMod.ultimateGraviChestPlate)
			{
				if(event.phase == TickEvent.Phase.START && event.side == Side.SERVER)
				{
					if(UltimateGraviSuiteMod.keyboard.isFlyKeyDown(event.player))
					{
						System.out.println(event.player.getCommandSenderName() + " pressed fly key");
						UGSUtils.switchFly(event.player, chestPlate);
					}

					if(UltimateGraviSuiteMod.keyboard.isInvisibleKeyDown(event.player))
					{
						System.out.println(event.player.getCommandSenderName() + " pressed inv key");
						UGSUtils.switchVisibility(event.player, chestPlate);
					}
				}

				if(event.phase == TickEvent.Phase.END)
				{
					if(UGSUtils.isInvisibilityActive(event.player) && ElectricItem.manager.getCharge(chestPlate) > UltimateGraviSuiteMod.ultimateMinCharge)
					{
						event.player.setInvisible(true);
						if(!event.player.capabilities.isCreativeMode)
						{
							ElectricItem.manager.discharge(chestPlate, UltimateGraviSuiteMod.ultimateUseByTick, 4, true, false);
						}
					}
					else
					{
						if(event.player.isInvisible() && !event.player.isPotionActive(Potion.invisibility))
						{
							event.player.setInvisible(false);
						}
					}

					if(UGSUtils.isFlyActive(event.player) && ElectricItem.manager.getCharge(chestPlate) > UltimateGraviSuiteMod.ultimateMinCharge)
					{
						if(!event.player.capabilities.isCreativeMode)
						{
							event.player.capabilities.allowFlying = true;
							event.player.capabilities.isFlying = true;
						}
					}
					else if(!event.player.capabilities.isCreativeMode)
					{
						event.player.capabilities.allowFlying = false;
						event.player.capabilities.isFlying = false;
					}

					if(event.player.posY > 262.0D && !event.player.capabilities.isCreativeMode)
					{
						event.player.setPosition(event.player.posX, 262.0D, event.player.posZ);
					}
				}
			}
	}

	@SubscribeEvent
	public void onPlayerFall(LivingFallEvent event)
	{
		ItemStack armor = event.entityLiving.getEquipmentInSlot(1);
		if((armor != null) && (armor.getItem() == UltimateGraviSuiteMod.ultimateBoots))
		{
			int fallDamage = Math.max((int)event.distance - 10, 0);
			int energyCost = 10000 * fallDamage;
			if(energyCost <= ElectricItem.manager.getCharge(armor))
			{
				ElectricItem.manager.discharge(armor, energyCost, Integer.MAX_VALUE, true, false);
				event.setCanceled(true);
			}
		}
	}
}