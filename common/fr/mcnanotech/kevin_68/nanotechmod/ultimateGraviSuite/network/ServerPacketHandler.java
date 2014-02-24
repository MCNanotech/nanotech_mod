/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.ultimateGraviSuite.network;

import ibxm.Player;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;

public class ServerPacketHandler implements IPacketHandler
{
	public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player player)
	{
		DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
		EntityPlayerMP playerMP = (EntityPlayerMP)player;

		try
		{
			String packetType = data.readUTF();
			int dataInt;

			if(packetType.equalsIgnoreCase("keyFLY"))
			{
				dataInt = data.readInt();
				ItemStack chestPlate = playerMP.inventory.armorInventory[2];

				if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate))
				{
					ServerPacketHelper.switchFlyModeServer(playerMP, chestPlate);
				}
			}

			if(packetType.equalsIgnoreCase("keyInv"))
			{
				dataInt = data.readInt();
				ItemStack boots = playerMP.inventory.armorInventory[0];
				ItemStack leggings = playerMP.inventory.armorInventory[1];
				ItemStack chestPlate = playerMP.inventory.armorInventory[2];
				ItemStack helmet = playerMP.inventory.armorInventory[3];

				if(chestPlate != null && chestPlate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate))
				{
					ServerPacketHelper.switchInvisibleModeServer(playerMP, chestPlate);
				}

				if(leggings != null && leggings.getItem().equals(UltimateGraviSuite.ultimateLeggings))
				{
					ServerPacketHelper.switchInvisibleModeServer(playerMP, leggings);
				}

				if(boots != null && boots.getItem().equals(UltimateGraviSuite.ultimateBoots))
				{
					ServerPacketHelper.switchInvisibleModeServer(playerMP, boots);
				}

				if(helmet != null && helmet.getItem().equals(UltimateGraviSuite.ultimateHelmet))
				{
					ServerPacketHelper.switchInvisibleModeServer(playerMP, helmet);
				}
			}

			if(packetType.equalsIgnoreCase("keyNight"))
			{
				dataInt = data.readInt();
				ItemStack chestplate = playerMP.inventory.armorInventory[3];

				if(chestplate != null && chestplate.getItem().equals(UltimateGraviSuite.ultimateHelmet))
				{
					ServerPacketHelper.switchNightVisionModeServer(playerMP, chestplate);
				}
			}

			ItemStack chestplate;

			if(packetType.equalsIgnoreCase("worldLoad"))
			{
				chestplate = playerMP.inventory.armorInventory[2];

				if(chestplate != null && chestplate.getItem().equals(UltimateGraviSuite.ultimateGraviChestPlate))
				{
					ServerPacketHelper.firstLoadServer(playerMP, chestplate);
				}
			}

			if(packetType.equalsIgnoreCase("keyState"))
			{
				dataInt = data.readInt();
				UltimateGraviSuite.keyboard.processKeyUpdate(playerMP, dataInt);
			}

			if(packetType.equalsIgnoreCase("keyModePressed"))
			{
				chestplate = playerMP.inventory.armorInventory[2];
			}
		}
		catch(IOException exception)
		{
			exception.printStackTrace();
		}
	}
}