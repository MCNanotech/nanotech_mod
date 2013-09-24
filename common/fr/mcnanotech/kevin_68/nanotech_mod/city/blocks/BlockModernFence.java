package fr.mcnanotech.kevin_68.nanotech_mod.city.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityLampLight;
import fr.mcnanotech.kevin_68.nanotech_mod.city.tileentity.TileEntityModernFence;

public class BlockModernFence extends BlockContainer
{

	public BlockModernFence(int id)
	{
		super(id, Material.iron);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world)
	{
		return new TileEntityModernFence();
	}
	
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAligned, List list, Entity entity)
    {
        boolean flag = this.canConnectFenceTo(world, x, y, z - 1);
        boolean flag1 = this.canConnectFenceTo(world, x, y, z + 1);
        boolean flag2 = this.canConnectFenceTo(world, x - 1, y, z);
        boolean flag3 = this.canConnectFenceTo(world, x + 1, y, z);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag || flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(world, x, y, z, axisAligned, list, entity);
        }

        f2 = 0.375F;
        f3 = 0.625F;

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        if (flag2 || flag3 || !flag && !flag1)
        {
            this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
            super.addCollisionBoxesToList(world, x, y, z, axisAligned, list, entity);
        }

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }
    
    public void setBlockBoundsBasedOnState(IBlockAccess blocAccess, int x, int y, int z)
    {
        boolean flag = this.canConnectFenceTo(blocAccess, x, y, z - 1);
        boolean flag1 = this.canConnectFenceTo(blocAccess, x, y, z + 1);
        boolean flag2 = this.canConnectFenceTo(blocAccess, x - 1, y, z);
        boolean flag3 = this.canConnectFenceTo(blocAccess, x + 1, y, z);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if (flag)
        {
            f2 = 0.0F;
        }

        if (flag1)
        {
            f3 = 1.0F;
        }

        if (flag2)
        {
            f = 0.0F;
        }

        if (flag3)
        {
            f1 = 1.0F;
        }

        this.setBlockBounds(f, 0.0F, f2, f1, 1.0F, f3);
    }
    
    public boolean isOpaqueCube()
    {
        return false;
    }

    public boolean renderAsNormalBlock()
    {
        return false;
    }

    public boolean getBlocksMovement(IBlockAccess blockAccess, int x, int y, int z)
    {
        return false;
    }
    
    public int getRenderType()
    {
        return -1;
    }
    
    public boolean canConnectFenceTo(IBlockAccess blockAccess, int x, int y, int z)
    {
        int l = blockAccess.getBlockId(x, y, z);

        if (l != this.blockID)
        {
            Block block = Block.blocksList[l];
            return block != null && block.blockMaterial.isOpaque() && block.renderAsNormalBlock() ? block.blockMaterial != Material.pumpkin : false;
        }
        else
        {
            return true;
        }
    }
    
    public void registerIcons(IconRegister iconregister)
    {
        this.blockIcon = iconregister.registerIcon("iron_block");
    }
    
    

}
