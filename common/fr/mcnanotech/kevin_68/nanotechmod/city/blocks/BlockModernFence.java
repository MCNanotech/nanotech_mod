/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityModernFence;

public class BlockModernFence extends BlockContainer
{
    public BlockModernFence()
    {
        super(Material.iron);
    }

    @Override
    public TileEntity createNewTileEntity(World world, int metadata)
    {
        return new TileEntityModernFence();
    }

    @SuppressWarnings("rawtypes")
    public void addCollisionBoxesToList(World world, int x, int y, int z, AxisAlignedBB axisAligned, List list, Entity entity)
    {
        boolean flag = this.canConnectFenceTo(world, x, y, z - 1, true);
        boolean flag1 = this.canConnectFenceTo(world, x, y, z + 1, true);
        boolean flag2 = this.canConnectFenceTo(world, x - 1, y, z, true);
        boolean flag3 = this.canConnectFenceTo(world, x + 1, y, z, true);
        boolean flag4 = this.canConnectFenceTo(world, x + 1, y, z + 1, false);
        boolean flag5 = this.canConnectFenceTo(world, x + 1, y, z - 1, false);
        boolean flag6 = this.canConnectFenceTo(world, x - 1, y, z + 1, false);
        boolean flag7 = this.canConnectFenceTo(world, x - 1, y, z - 1, false);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if(flag)
        {
            f2 = 0.0F;
        }

        if(flag1)
        {
            f3 = 1.0F;
        }

        if(flag2)
        {
            f = 0.0F;
        }

        if(flag3)
        {
            f1 = 1.0F;
        }

        if(flag4 && !(flag1 && flag3) && !flag1 && !flag3)
        {
            f3 = 1.0F;
            f1 = 1.0F;
        }

        if(flag5 && !(flag && flag3) && !flag && !flag3)
        {
            f1 = 1.0F;
            f2 = 0.0F;
        }

        if(flag6 && !(flag1 && flag2) && !flag1 && !flag2)
        {
            f = 0.0F;
            f3 = 1.0F;
        }

        if(flag7 && !(flag && flag2) && !flag && !flag2)
        {
            f2 = 0.0F;
            f = 0.0F;
        }
        this.setBlockBounds(f, 0.0F, f2, f1, 1.5F, f3);
        super.addCollisionBoxesToList(world, x, y, z, axisAligned, list, entity);
    }

    public void setBlockBoundsBasedOnState(IBlockAccess blocAccess, int x, int y, int z)
    {
        boolean flag = this.canConnectFenceTo(blocAccess, x, y, z - 1, true);
        boolean flag1 = this.canConnectFenceTo(blocAccess, x, y, z + 1, true);
        boolean flag2 = this.canConnectFenceTo(blocAccess, x - 1, y, z, true);
        boolean flag3 = this.canConnectFenceTo(blocAccess, x + 1, y, z, true);
        boolean flag4 = this.canConnectFenceTo(blocAccess, x + 1, y, z + 1, false);
        boolean flag5 = this.canConnectFenceTo(blocAccess, x + 1, y, z - 1, false);
        boolean flag6 = this.canConnectFenceTo(blocAccess, x - 1, y, z + 1, false);
        boolean flag7 = this.canConnectFenceTo(blocAccess, x - 1, y, z - 1, false);
        float f = 0.375F;
        float f1 = 0.625F;
        float f2 = 0.375F;
        float f3 = 0.625F;

        if(flag)
        {
            f2 = 0.0F;
        }

        if(flag1)
        {
            f3 = 1.0F;
        }

        if(flag2)
        {
            f = 0.0F;
        }

        if(flag3)
        {
            f1 = 1.0F;
        }

        if(flag4 && !(flag1 && flag3) && !flag1 && !flag3)
        {
            f3 = 1.0F;
            f1 = 1.0F;
        }

        if(flag5 && !(flag && flag3) && !flag && !flag3)
        {
            f1 = 1.0F;
            f2 = 0.0F;
        }

        if(flag6 && !(flag1 && flag2) && !flag1 && !flag2)
        {
            f = 0.0F;
            f3 = 1.0F;
        }

        if(flag7 && !(flag && flag2) && !flag && !flag2)
        {
            f2 = 0.0F;
            f = 0.0F;
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

    public boolean canConnectFenceTo(IBlockAccess blockAccess, int x, int y, int z, boolean b)
    {
        Block block = blockAccess.getBlock(x, y, z);

        if(block.equals(this) && b)
        {
            return block != this && block != Blocks.fence_gate ? (block.getMaterial().isOpaque() && block.renderAsNormalBlock() ? block.getMaterial() != Material.gourd : false) : true;
        }
        else if(block == this)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public void registerBlockIcons(IIconRegister iconregister)
    {
        this.blockIcon = iconregister.registerIcon("iron_block");
    }

}
