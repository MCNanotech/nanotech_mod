package fr.mcnanotech.kevin_68.nanotech_mod.main.blocks;

import java.util.List;

import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFalling extends BlockSand
{
	public static String[] type = new String[]
	{"stone", "stonebrick", "crackedstonebrick", "mossystonebrick", "chiseledstonebrick", "cobblestone", "mossycobblestone"};
	private Icon[] iconbuffer;

	public BlockFalling(int id, Material material)
	{
		super(id, material);
	}

	public void registerIcons(IconRegister iconregister)
	{
		iconbuffer = new Icon[type.length];
		iconbuffer[0] = iconregister.registerIcon("stone");
		iconbuffer[1] = iconregister.registerIcon("stonebricksmooth");
		iconbuffer[2] = iconregister.registerIcon("stonebricksmooth_cracked");
		iconbuffer[3] = iconregister.registerIcon("stonebricksmooth_mossy");
		iconbuffer[4] = iconregister.registerIcon("stonebricksmooth_carved");
		iconbuffer[5] = iconregister.registerIcon("stonebrick");
		iconbuffer[6] = iconregister.registerIcon("stoneMoss");
	}

	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int damage)
	{
		if(damage < type.length)
		{
			return iconbuffer[damage];
		}
		else
		{
			return iconbuffer[0];
		}
	}

	public int damageDropped(int metadata)
	{
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int blockid, CreativeTabs creativeTabs, List list)
	{
		for(int metadatanumber = 0; metadatanumber < type.length; metadatanumber++)
		{
			list.add(new ItemStack(blockid, 1, metadatanumber));
		}
	}
}
