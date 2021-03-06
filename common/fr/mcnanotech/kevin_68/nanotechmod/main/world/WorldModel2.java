/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import fr.mcnanotech.kevin_68.nanotechmod.main.blocks.NanotechBlock;

public class WorldModel2 extends WorldGenerator
{
    protected Block[] getValidSpawnBlocks()
    {
        return new Block[] {Blocks.stone, Blocks.dirt, NanotechBlock.nanoGrass, Blocks.snow};
    }

    public boolean LocationIsValidSpawn(World world, int x, int y, int z)
    {
        int distanceToAir = 0;
        Block check = world.getBlock(x, y, z);

        while(check != null)
        {
            distanceToAir++;
            check = world.getBlock(x, y + distanceToAir, z);
        }

        if(distanceToAir > 3)
        {
            return false;
        }
        y += distanceToAir - 1;

        Block block = world.getBlock(x, y, z);
        boolean isAirAbove = world.isAirBlock(x, y + 1, z);
        Block blockBelow = world.getBlock(x, y - 1, z);
        for(Block valideBlock : getValidSpawnBlocks())
        {
            if(!isAirAbove)
            {
                return false;
            }
            if(block == valideBlock)
            {
                return true;
            }
            else if(block == Blocks.snow && blockBelow == valideBlock)
            {
                return true;
            }
        }
        return false;
    }

    public WorldModel2()
    {}

    public boolean generate(World world, Random rand, int x, int y, int z)
    {
        // checz that each corner is one of the valid spawn blocks
        if(!LocationIsValidSpawn(world, x, y, z) || !LocationIsValidSpawn(world, x + 4, y, z) || !LocationIsValidSpawn(world, x + 4, y, z + 9) || !LocationIsValidSpawn(world, x, y, z + 9))
        {
            return false;
        }

        world.setBlockToAir(x + 0, y + 0, z + 0);
        world.setBlockToAir(x + 0, y + 0, z + 1);
        world.setBlockToAir(x + 0, y + 0, z + 2);
        world.setBlockToAir(x + 0, y + 0, z + 3);
        world.setBlock(x + 0, y + 0, z + 4, Blocks.cobblestone);
        world.setBlock(x + 0, y + 0, z + 5, Blocks.cobblestone);
        world.setBlock(x + 0, y + 0, z + 6, Blocks.cobblestone);
        world.setBlock(x + 0, y + 0, z + 7, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 0, z + 8);
        world.setBlockToAir(x + 0, y + 1, z + 0);
        world.setBlock(x + 0, y + 1, z + 1, Blocks.cobblestone);
        world.setBlock(x + 0, y + 1, z + 2, Blocks.cobblestone);
        world.setBlock(x + 0, y + 1, z + 3, Blocks.cobblestone);
        world.setBlock(x + 0, y + 1, z + 4, Blocks.cobblestone);
        world.setBlock(x + 0, y + 1, z + 5, Blocks.cobblestone);
        world.setBlock(x + 0, y + 1, z + 6, Blocks.cobblestone);
        world.setBlock(x + 0, y + 1, z + 7, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 1, z + 8);
        world.setBlockToAir(x + 0, y + 2, z + 0);
        world.setBlock(x + 0, y + 2, z + 1, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 2, z + 2);
        world.setBlock(x + 0, y + 2, z + 3, Blocks.cobblestone);
        world.setBlock(x + 0, y + 2, z + 4, Blocks.cobblestone);
        world.setBlock(x + 0, y + 2, z + 5, Blocks.cobblestone);
        world.setBlock(x + 0, y + 2, z + 6, Blocks.cobblestone);
        world.setBlock(x + 0, y + 2, z + 7, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 2, z + 8);
        world.setBlockToAir(x + 0, y + 3, z + 0);
        world.setBlock(x + 0, y + 3, z + 1, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 3, z + 2);
        world.setBlock(x + 0, y + 3, z + 3, Blocks.cobblestone);
        world.setBlock(x + 0, y + 3, z + 4, Blocks.cobblestone);
        world.setBlock(x + 0, y + 3, z + 5, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 3, z + 6);
        world.setBlock(x + 0, y + 3, z + 7, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 3, z + 8);
        world.setBlockToAir(x + 0, y + 4, z + 0);
        world.setBlock(x + 0, y + 4, z + 1, Blocks.cobblestone);
        world.setBlock(x + 0, y + 4, z + 2, Blocks.cobblestone);
        world.setBlock(x + 0, y + 4, z + 3, Blocks.cobblestone);
        world.setBlock(x + 0, y + 4, z + 4, Blocks.cobblestone);
        world.setBlock(x + 0, y + 4, z + 5, Blocks.cobblestone);
        world.setBlock(x + 0, y + 4, z + 6, Blocks.cobblestone);
        world.setBlock(x + 0, y + 4, z + 7, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 4, z + 8);
        world.setBlockToAir(x + 0, y + 5, z + 0);
        world.setBlock(x + 0, y + 5, z + 1, Blocks.cobblestone);
        world.setBlock(x + 0, y + 5, z + 2, Blocks.cobblestone);
        world.setBlock(x + 0, y + 5, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 5, z + 4);
        world.setBlockToAir(x + 0, y + 5, z + 5);
        world.setBlockToAir(x + 0, y + 5, z + 6);
        world.setBlockToAir(x + 0, y + 5, z + 7);
        world.setBlockToAir(x + 0, y + 5, z + 8);
        world.setBlockToAir(x + 0, y + 6, z + 0);
        world.setBlockToAir(x + 0, y + 6, z + 1);
        world.setBlockToAir(x + 0, y + 6, z + 2);
        world.setBlock(x + 0, y + 6, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 6, z + 4);
        world.setBlockToAir(x + 0, y + 6, z + 5);
        world.setBlockToAir(x + 0, y + 6, z + 6);
        world.setBlockToAir(x + 0, y + 6, z + 7);
        world.setBlockToAir(x + 0, y + 6, z + 8);
        world.setBlockToAir(x + 0, y + 7, z + 0);
        world.setBlockToAir(x + 0, y + 7, z + 1);
        world.setBlockToAir(x + 0, y + 7, z + 2);
        world.setBlock(x + 0, y + 7, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 7, z + 4);
        world.setBlockToAir(x + 0, y + 7, z + 5);
        world.setBlockToAir(x + 0, y + 7, z + 6);
        world.setBlockToAir(x + 0, y + 7, z + 7);
        world.setBlockToAir(x + 0, y + 7, z + 8);
        world.setBlockToAir(x + 0, y + 8, z + 0);
        world.setBlockToAir(x + 0, y + 8, z + 1);
        world.setBlock(x + 0, y + 8, z + 2, Blocks.cobblestone);
        world.setBlock(x + 0, y + 8, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 8, z + 4);
        world.setBlockToAir(x + 0, y + 8, z + 5);
        world.setBlockToAir(x + 0, y + 8, z + 6);
        world.setBlockToAir(x + 0, y + 8, z + 7);
        world.setBlockToAir(x + 0, y + 8, z + 8);
        world.setBlockToAir(x + 0, y + 9, z + 0);
        world.setBlockToAir(x + 0, y + 9, z + 1);
        world.setBlockToAir(x + 0, y + 9, z + 2);
        world.setBlock(x + 0, y + 9, z + 3, Blocks.cobblestone);
        world.setBlock(x + 0, y + 9, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 9, z + 5);
        world.setBlockToAir(x + 0, y + 9, z + 6);
        world.setBlockToAir(x + 0, y + 9, z + 7);
        world.setBlockToAir(x + 0, y + 9, z + 8);
        world.setBlockToAir(x + 0, y + 10, z + 0);
        world.setBlockToAir(x + 0, y + 10, z + 1);
        world.setBlockToAir(x + 0, y + 10, z + 2);
        world.setBlock(x + 0, y + 10, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 0, y + 10, z + 4);
        world.setBlockToAir(x + 0, y + 10, z + 5);
        world.setBlockToAir(x + 0, y + 10, z + 6);
        world.setBlockToAir(x + 0, y + 10, z + 7);
        world.setBlockToAir(x + 0, y + 10, z + 8);
        world.setBlockToAir(x + 0, y + 11, z + 0);
        world.setBlockToAir(x + 0, y + 11, z + 1);
        world.setBlockToAir(x + 0, y + 11, z + 2);
        world.setBlockToAir(x + 0, y + 11, z + 3);
        world.setBlockToAir(x + 0, y + 11, z + 4);
        world.setBlockToAir(x + 0, y + 11, z + 5);
        world.setBlockToAir(x + 0, y + 11, z + 6);
        world.setBlockToAir(x + 0, y + 11, z + 7);
        world.setBlockToAir(x + 0, y + 11, z + 8);
        world.setBlockToAir(x + 0, y + 12, z + 1);
        world.setBlockToAir(x + 0, y + 12, z + 2);
        world.setBlockToAir(x + 0, y + 12, z + 3);
        world.setBlockToAir(x + 0, y + 12, z + 4);
        world.setBlockToAir(x + 0, y + 12, z + 5);
        world.setBlockToAir(x + 0, y + 12, z + 6);
        world.setBlockToAir(x + 0, y + 12, z + 7);
        world.setBlockToAir(x + 0, y + 12, z + 8);
        world.setBlock(x + 1, y + 0, z + 0, Blocks.cobblestone);
        world.setBlock(x + 1, y + 0, z + 1, Blocks.cobblestone);
        world.setBlock(x + 1, y + 0, z + 2, Blocks.cobblestone);
        world.setBlock(x + 1, y + 0, z + 3, Blocks.cobblestone);
        world.setBlock(x + 1, y + 0, z + 4, Blocks.cobblestone);
        world.setBlock(x + 1, y + 0, z + 5, Blocks.cobblestone);
        world.setBlock(x + 1, y + 0, z + 6, Blocks.cobblestone);
        world.setBlock(x + 1, y + 0, z + 7, Blocks.cobblestone);
        world.setBlock(x + 1, y + 0, z + 8, Blocks.cobblestone);
        world.setBlock(x + 1, y + 1, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 1, z + 1);
        world.setBlockToAir(x + 1, y + 1, z + 2);
        world.setBlockToAir(x + 1, y + 1, z + 3);
        world.setBlockToAir(x + 1, y + 1, z + 4);
        world.setBlock(x + 1, y + 1, z + 5, Blocks.stone_stairs, 2, 3);
        world.setBlock(x + 1, y + 1, z + 6, Blocks.cobblestone);
        world.setBlock(x + 1, y + 1, z + 7, Blocks.cobblestone);
        world.setBlock(x + 1, y + 1, z + 8, Blocks.cobblestone);
        world.setBlock(x + 1, y + 2, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 2, z + 1);
        world.setBlockToAir(x + 1, y + 2, z + 2);
        world.setBlockToAir(x + 1, y + 2, z + 3);
        world.setBlockToAir(x + 1, y + 2, z + 4);
        world.setBlockToAir(x + 1, y + 2, z + 5);
        world.setBlockToAir(x + 1, y + 2, z + 6);
        world.setBlock(x + 1, y + 2, z + 7, Blocks.stone_stairs, 1, 3);
        world.setBlock(x + 1, y + 2, z + 8, Blocks.cobblestone);
        world.setBlock(x + 1, y + 3, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 3, z + 1);
        world.setBlockToAir(x + 1, y + 3, z + 2);
        world.setBlockToAir(x + 1, y + 3, z + 3);
        world.setBlockToAir(x + 1, y + 3, z + 4);
        world.setBlockToAir(x + 1, y + 3, z + 5);
        world.setBlockToAir(x + 1, y + 3, z + 6);
        world.setBlockToAir(x + 1, y + 3, z + 7);
        world.setBlockToAir(x + 1, y + 3, z + 8);
        world.setBlock(x + 1, y + 4, z + 0, Blocks.cobblestone);
        world.setBlock(x + 1, y + 4, z + 1, Blocks.cobblestone);
        world.setBlock(x + 1, y + 4, z + 2, Blocks.cobblestone);
        world.setBlock(x + 1, y + 4, z + 3, Blocks.cobblestone);
        world.setBlock(x + 1, y + 4, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 4, z + 5);
        world.setBlockToAir(x + 1, y + 4, z + 6);
        world.setBlockToAir(x + 1, y + 4, z + 7);
        world.setBlockToAir(x + 1, y + 4, z + 8);
        world.setBlockToAir(x + 1, y + 5, z + 0);
        world.setBlockToAir(x + 1, y + 5, z + 1);
        world.setBlockToAir(x + 1, y + 5, z + 2);
        world.setBlockToAir(x + 1, y + 5, z + 3);
        world.setBlock(x + 1, y + 5, z + 4, Blocks.cobblestone);
        world.setBlock(x + 1, y + 5, z + 5, Blocks.cobblestone);
        world.setBlock(x + 1, y + 5, z + 6, Blocks.cobblestone);
        world.setBlock(x + 1, y + 5, z + 7, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 5, z + 8);
        world.setBlockToAir(x + 1, y + 6, z + 0);
        world.setBlockToAir(x + 1, y + 6, z + 1);
        world.setBlockToAir(x + 1, y + 6, z + 2);
        world.setBlockToAir(x + 1, y + 6, z + 3);
        world.setBlock(x + 1, y + 6, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 6, z + 5);
        world.setBlockToAir(x + 1, y + 6, z + 6);
        world.setBlockToAir(x + 1, y + 6, z + 7);
        world.setBlockToAir(x + 1, y + 6, z + 8);
        world.setBlockToAir(x + 1, y + 7, z + 0);
        world.setBlockToAir(x + 1, y + 7, z + 1);
        world.setBlockToAir(x + 1, y + 7, z + 2);
        world.setBlockToAir(x + 1, y + 7, z + 3);
        world.setBlock(x + 1, y + 7, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 7, z + 5);
        world.setBlockToAir(x + 1, y + 7, z + 6);
        world.setBlockToAir(x + 1, y + 7, z + 7);
        world.setBlockToAir(x + 1, y + 7, z + 8);
        world.setBlockToAir(x + 1, y + 8, z + 0);
        world.setBlockToAir(x + 1, y + 8, z + 1);
        world.setBlockToAir(x + 1, y + 8, z + 2);
        world.setBlockToAir(x + 1, y + 8, z + 3);
        world.setBlock(x + 1, y + 8, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 8, z + 5);
        world.setBlockToAir(x + 1, y + 8, z + 6);
        world.setBlockToAir(x + 1, y + 8, z + 7);
        world.setBlockToAir(x + 1, y + 8, z + 8);
        world.setBlockToAir(x + 1, y + 9, z + 0);
        world.setBlock(x + 1, y + 9, z + 1, Blocks.cobblestone);
        world.setBlock(x + 1, y + 9, z + 2, Blocks.cobblestone);
        world.setBlock(x + 1, y + 9, z + 3, Blocks.cobblestone);
        world.setBlock(x + 1, y + 9, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 9, z + 5);
        world.setBlockToAir(x + 1, y + 9, z + 6);
        world.setBlockToAir(x + 1, y + 9, z + 7);
        world.setBlockToAir(x + 1, y + 9, z + 8);
        world.setBlockToAir(x + 1, y + 10, z + 0);
        world.setBlockToAir(x + 1, y + 10, z + 1);
        world.setBlockToAir(x + 1, y + 10, z + 2);
        world.setBlockToAir(x + 1, y + 10, z + 3);
        world.setBlock(x + 1, y + 10, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 1, y + 10, z + 5);
        world.setBlockToAir(x + 1, y + 10, z + 6);
        world.setBlockToAir(x + 1, y + 10, z + 7);
        world.setBlockToAir(x + 1, y + 10, z + 8);
        world.setBlockToAir(x + 1, y + 11, z + 0);
        world.setBlockToAir(x + 1, y + 11, z + 1);
        world.setBlockToAir(x + 1, y + 11, z + 2);
        world.setBlockToAir(x + 1, y + 11, z + 3);
        world.setBlockToAir(x + 1, y + 11, z + 4);
        world.setBlockToAir(x + 1, y + 11, z + 5);
        world.setBlockToAir(x + 1, y + 11, z + 6);
        world.setBlockToAir(x + 1, y + 11, z + 7);
        world.setBlockToAir(x + 1, y + 11, z + 8);
        world.setBlockToAir(x + 1, y + 12, z + 0);
        world.setBlockToAir(x + 1, y + 12, z + 1);
        world.setBlockToAir(x + 1, y + 12, z + 2);
        world.setBlockToAir(x + 1, y + 12, z + 3);
        world.setBlockToAir(x + 1, y + 12, z + 4);
        world.setBlockToAir(x + 1, y + 12, z + 5);
        world.setBlockToAir(x + 1, y + 12, z + 6);
        world.setBlockToAir(x + 1, y + 12, z + 7);
        world.setBlockToAir(x + 1, y + 12, z + 8);
        world.setBlock(x + 2, y + 0, z + 0, Blocks.cobblestone);
        world.setBlock(x + 2, y + 0, z + 1, Blocks.cobblestone);
        world.setBlock(x + 2, y + 0, z + 2, Blocks.cobblestone);
        world.setBlock(x + 2, y + 0, z + 3, Blocks.cobblestone);
        world.setBlock(x + 2, y + 0, z + 4, Blocks.cobblestone);
        world.setBlock(x + 2, y + 0, z + 5, Blocks.cobblestone);
        world.setBlock(x + 2, y + 0, z + 6, Blocks.cobblestone);
        world.setBlock(x + 2, y + 0, z + 7, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 0, z + 8);
        world.setBlockToAir(x + 2, y + 1, z + 0);
        world.setBlockToAir(x + 2, y + 1, z + 1);
        world.setBlockToAir(x + 2, y + 1, z + 2);
        world.setBlockToAir(x + 2, y + 1, z + 3);
        world.setBlockToAir(x + 2, y + 1, z + 4);
        world.setBlockToAir(x + 2, y + 1, z + 5);
        world.setBlockToAir(x + 2, y + 1, z + 6);
        world.setBlockToAir(x + 2, y + 1, z + 7);
        world.setBlockToAir(x + 2, y + 1, z + 8);
        world.setBlockToAir(x + 2, y + 2, z + 0);
        world.setBlockToAir(x + 2, y + 2, z + 1);
        world.setBlockToAir(x + 2, y + 2, z + 2);
        world.setBlockToAir(x + 2, y + 2, z + 3);
        world.setBlockToAir(x + 2, y + 2, z + 4);
        world.setBlockToAir(x + 2, y + 2, z + 5);
        world.setBlockToAir(x + 2, y + 2, z + 6);
        world.setBlockToAir(x + 2, y + 2, z + 7);
        world.setBlockToAir(x + 2, y + 2, z + 8);
        world.setBlock(x + 2, y + 3, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 3, z + 1);
        world.setBlockToAir(x + 2, y + 3, z + 2);
        world.setBlockToAir(x + 2, y + 3, z + 3);
        world.setBlockToAir(x + 2, y + 3, z + 4);
        world.setBlockToAir(x + 2, y + 3, z + 5);
        world.setBlockToAir(x + 2, y + 3, z + 6);
        world.setBlockToAir(x + 2, y + 3, z + 7);
        world.setBlockToAir(x + 2, y + 3, z + 8);
        world.setBlock(x + 2, y + 4, z + 0, Blocks.cobblestone);
        world.setBlock(x + 2, y + 4, z + 1, Blocks.cobblestone);
        world.setBlock(x + 2, y + 4, z + 2, Blocks.cobblestone);
        world.setBlock(x + 2, y + 4, z + 3, Blocks.cobblestone);
        world.setBlock(x + 2, y + 4, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 4, z + 5);
        world.setBlockToAir(x + 2, y + 4, z + 6);
        world.setBlockToAir(x + 2, y + 4, z + 7);
        world.setBlockToAir(x + 2, y + 4, z + 8);
        world.setBlock(x + 2, y + 5, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 5, z + 1);
        world.setBlockToAir(x + 2, y + 5, z + 2);
        world.setBlockToAir(x + 2, y + 5, z + 3);
        world.setBlock(x + 2, y + 5, z + 4, Blocks.cobblestone);
        world.setBlock(x + 2, y + 5, z + 5, Blocks.cobblestone);
        world.setBlock(x + 2, y + 5, z + 6, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 5, z + 7);
        world.setBlockToAir(x + 2, y + 5, z + 8);
        world.setBlockToAir(x + 2, y + 6, z + 0);
        world.setBlockToAir(x + 2, y + 6, z + 1);
        world.setBlockToAir(x + 2, y + 6, z + 2);
        world.setBlockToAir(x + 2, y + 6, z + 3);
        world.setBlockToAir(x + 2, y + 6, z + 4);
        world.setBlockToAir(x + 2, y + 6, z + 5);
        world.setBlockToAir(x + 2, y + 6, z + 6);
        world.setBlockToAir(x + 2, y + 6, z + 7);
        world.setBlockToAir(x + 2, y + 6, z + 8);
        world.setBlockToAir(x + 2, y + 7, z + 0);
        world.setBlockToAir(x + 2, y + 7, z + 1);
        world.setBlockToAir(x + 2, y + 7, z + 2);
        world.setBlockToAir(x + 2, y + 7, z + 3);
        world.setBlockToAir(x + 2, y + 7, z + 4);
        world.setBlockToAir(x + 2, y + 7, z + 5);
        world.setBlockToAir(x + 2, y + 7, z + 6);
        world.setBlockToAir(x + 2, y + 7, z + 7);
        world.setBlockToAir(x + 2, y + 7, z + 8);
        world.setBlock(x + 2, y + 8, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 8, z + 1);
        world.setBlockToAir(x + 2, y + 8, z + 2);
        world.setBlockToAir(x + 2, y + 8, z + 3);
        world.setBlock(x + 2, y + 8, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 8, z + 5);
        world.setBlockToAir(x + 2, y + 8, z + 6);
        world.setBlockToAir(x + 2, y + 8, z + 7);
        world.setBlockToAir(x + 2, y + 8, z + 8);
        world.setBlock(x + 2, y + 9, z + 0, Blocks.cobblestone);
        world.setBlock(x + 2, y + 9, z + 1, Blocks.cobblestone);
        world.setBlock(x + 2, y + 9, z + 2, Blocks.cobblestone);
        world.setBlock(x + 2, y + 9, z + 3, Blocks.cobblestone);
        world.setBlock(x + 2, y + 9, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 9, z + 5);
        world.setBlockToAir(x + 2, y + 9, z + 6);
        world.setBlockToAir(x + 2, y + 9, z + 7);
        world.setBlockToAir(x + 2, y + 9, z + 8);
        world.setBlock(x + 2, y + 10, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 10, z + 1);
        world.setBlockToAir(x + 2, y + 10, z + 2);
        world.setBlockToAir(x + 2, y + 10, z + 3);
        world.setBlock(x + 2, y + 10, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 10, z + 5);
        world.setBlockToAir(x + 2, y + 10, z + 6);
        world.setBlockToAir(x + 2, y + 10, z + 7);
        world.setBlockToAir(x + 2, y + 10, z + 8);
        world.setBlock(x + 2, y + 11, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 11, z + 1);
        world.setBlockToAir(x + 2, y + 11, z + 2);
        world.setBlockToAir(x + 2, y + 11, z + 3);
        world.setBlock(x + 2, y + 11, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 2, y + 11, z + 5);
        world.setBlockToAir(x + 2, y + 11, z + 6);
        world.setBlockToAir(x + 2, y + 11, z + 7);
        world.setBlockToAir(x + 2, y + 11, z + 8);
        world.setBlockToAir(x + 2, y + 12, z + 0);
        world.setBlockToAir(x + 2, y + 12, z + 1);
        world.setBlockToAir(x + 2, y + 12, z + 2);
        world.setBlockToAir(x + 2, y + 12, z + 3);
        world.setBlockToAir(x + 2, y + 12, z + 4);
        world.setBlockToAir(x + 2, y + 12, z + 5);
        world.setBlockToAir(x + 2, y + 12, z + 6);
        world.setBlockToAir(x + 2, y + 12, z + 7);
        world.setBlockToAir(x + 2, y + 12, z + 8);
        world.setBlock(x + 3, y + 0, z + 0, Blocks.cobblestone);
        world.setBlock(x + 3, y + 0, z + 1, Blocks.cobblestone);
        world.setBlock(x + 3, y + 0, z + 2, Blocks.cobblestone);
        world.setBlock(x + 3, y + 0, z + 3, Blocks.cobblestone);
        world.setBlock(x + 3, y + 0, z + 4, Blocks.cobblestone);
        world.setBlock(x + 3, y + 0, z + 5, Blocks.cobblestone);
        world.setBlock(x + 3, y + 0, z + 6, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 0, z + 7);
        world.setBlockToAir(x + 3, y + 0, z + 8);
        world.setBlock(x + 3, y + 1, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 1, z + 1);
        world.setBlockToAir(x + 3, y + 1, z + 2);
        world.setBlockToAir(x + 3, y + 1, z + 4);
        world.setBlockToAir(x + 3, y + 1, z + 5);
        world.setBlockToAir(x + 3, y + 1, z + 6);
        world.setBlockToAir(x + 3, y + 1, z + 7);
        world.setBlockToAir(x + 3, y + 1, z + 8);
        world.setBlock(x + 3, y + 2, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 2, z + 1);
        world.setBlockToAir(x + 3, y + 2, z + 2);
        world.setBlockToAir(x + 3, y + 2, z + 4);
        world.setBlockToAir(x + 3, y + 2, z + 5);
        world.setBlockToAir(x + 3, y + 2, z + 6);
        world.setBlockToAir(x + 3, y + 2, z + 7);
        world.setBlockToAir(x + 3, y + 2, z + 8);
        world.setBlock(x + 3, y + 3, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 3, z + 1);
        world.setBlockToAir(x + 3, y + 3, z + 2);
        world.setBlockToAir(x + 3, y + 3, z + 4);
        world.setBlockToAir(x + 3, y + 3, z + 5);
        world.setBlockToAir(x + 3, y + 3, z + 6);
        world.setBlockToAir(x + 3, y + 3, z + 7);
        world.setBlockToAir(x + 3, y + 3, z + 8);
        world.setBlock(x + 3, y + 4, z + 0, Blocks.cobblestone);
        world.setBlock(x + 3, y + 4, z + 1, Blocks.cobblestone);
        world.setBlock(x + 3, y + 4, z + 2, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 4, z + 3);
        world.setBlock(x + 3, y + 4, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 4, z + 5);
        world.setBlockToAir(x + 3, y + 4, z + 6);
        world.setBlockToAir(x + 3, y + 4, z + 7);
        world.setBlockToAir(x + 3, y + 4, z + 8);
        world.setBlock(x + 3, y + 5, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 5, z + 1);
        world.setBlockToAir(x + 3, y + 5, z + 2);
        world.setBlockToAir(x + 3, y + 5, z + 3);
        world.setBlock(x + 3, y + 5, z + 4, Blocks.cobblestone);
        world.setBlock(x + 3, y + 5, z + 5, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 5, z + 6);
        world.setBlockToAir(x + 3, y + 5, z + 7);
        world.setBlockToAir(x + 3, y + 5, z + 8);
        world.setBlock(x + 3, y + 6, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 6, z + 1);
        world.setBlockToAir(x + 3, y + 6, z + 2);
        world.setBlockToAir(x + 3, y + 6, z + 3);
        world.setBlock(x + 3, y + 6, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 6, z + 5);
        world.setBlockToAir(x + 3, y + 6, z + 6);
        world.setBlockToAir(x + 3, y + 6, z + 7);
        world.setBlockToAir(x + 3, y + 6, z + 8);
        world.setBlock(x + 3, y + 7, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 7, z + 1);
        world.setBlockToAir(x + 3, y + 7, z + 2);
        world.setBlock(x + 3, y + 7, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 7, z + 5);
        world.setBlockToAir(x + 3, y + 7, z + 6);
        world.setBlockToAir(x + 3, y + 7, z + 7);
        world.setBlockToAir(x + 3, y + 7, z + 8);
        world.setBlock(x + 3, y + 8, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 8, z + 1);
        world.setBlockToAir(x + 3, y + 8, z + 2);
        world.setBlock(x + 3, y + 8, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 8, z + 5);
        world.setBlockToAir(x + 3, y + 8, z + 6);
        world.setBlockToAir(x + 3, y + 8, z + 7);
        world.setBlockToAir(x + 3, y + 8, z + 8);
        world.setBlock(x + 3, y + 9, z + 0, Blocks.cobblestone);
        world.setBlock(x + 3, y + 9, z + 1, Blocks.cobblestone);
        world.setBlock(x + 3, y + 9, z + 2, Blocks.cobblestone);
        world.setBlock(x + 3, y + 9, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 9, z + 5);
        world.setBlockToAir(x + 3, y + 9, z + 6);
        world.setBlockToAir(x + 3, y + 9, z + 7);
        world.setBlockToAir(x + 3, y + 9, z + 8);
        world.setBlock(x + 3, y + 10, z + 0, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 10, z + 1);
        world.setBlockToAir(x + 3, y + 10, z + 2);
        world.setBlockToAir(x + 3, y + 10, z + 3);
        world.setBlock(x + 3, y + 10, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 3, y + 10, z + 5);
        world.setBlockToAir(x + 3, y + 10, z + 6);
        world.setBlockToAir(x + 3, y + 10, z + 7);
        world.setBlockToAir(x + 3, y + 10, z + 8);
        world.setBlockToAir(x + 3, y + 11, z + 0);
        world.setBlockToAir(x + 3, y + 11, z + 1);
        world.setBlockToAir(x + 3, y + 11, z + 2);
        world.setBlockToAir(x + 3, y + 11, z + 3);
        world.setBlockToAir(x + 3, y + 11, z + 4);
        world.setBlockToAir(x + 3, y + 11, z + 5);
        world.setBlockToAir(x + 3, y + 11, z + 6);
        world.setBlockToAir(x + 3, y + 11, z + 7);
        world.setBlockToAir(x + 3, y + 11, z + 8);
        world.setBlockToAir(x + 3, y + 12, z + 0);
        world.setBlockToAir(x + 3, y + 12, z + 1);
        world.setBlockToAir(x + 3, y + 12, z + 2);
        world.setBlockToAir(x + 3, y + 12, z + 3);
        world.setBlockToAir(x + 3, y + 12, z + 4);
        world.setBlockToAir(x + 3, y + 12, z + 5);
        world.setBlockToAir(x + 3, y + 12, z + 6);
        world.setBlockToAir(x + 3, y + 12, z + 7);
        world.setBlockToAir(x + 3, y + 12, z + 8);
        world.setBlockToAir(x + 4, y + 0, z + 0);
        world.setBlockToAir(x + 4, y + 0, z + 1);
        world.setBlockToAir(x + 4, y + 0, z + 2);
        world.setBlockToAir(x + 4, y + 0, z + 3);
        world.setBlock(x + 4, y + 0, z + 4, Blocks.cobblestone);
        world.setBlock(x + 4, y + 0, z + 5, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 0, z + 6);
        world.setBlockToAir(x + 4, y + 0, z + 7);
        world.setBlockToAir(x + 4, y + 1, z + 0);
        world.setBlock(x + 4, y + 1, z + 1, Blocks.cobblestone);
        world.setBlock(x + 4, y + 1, z + 2, Blocks.cobblestone);
        world.setBlock(x + 4, y + 1, z + 3, Blocks.cobblestone);
        world.setBlock(x + 4, y + 1, z + 4, Blocks.cobblestone);
        world.setBlock(x + 4, y + 1, z + 5, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 1, z + 6);
        world.setBlockToAir(x + 4, y + 1, z + 7);
        world.setBlockToAir(x + 4, y + 1, z + 8);
        world.setBlockToAir(x + 4, y + 2, z + 0);
        world.setBlock(x + 4, y + 2, z + 1, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 2, z + 2);
        world.setBlock(x + 4, y + 2, z + 3, Blocks.cobblestone);
        world.setBlock(x + 4, y + 2, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 2, z + 5);
        world.setBlockToAir(x + 4, y + 2, z + 6);
        world.setBlockToAir(x + 4, y + 2, z + 7);
        world.setBlockToAir(x + 4, y + 2, z + 8);
        world.setBlockToAir(x + 4, y + 3, z + 0);
        world.setBlock(x + 4, y + 3, z + 1, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 3, z + 2);
        world.setBlock(x + 4, y + 3, z + 3, Blocks.cobblestone);
        world.setBlock(x + 4, y + 3, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 3, z + 5);
        world.setBlockToAir(x + 4, y + 3, z + 6);
        world.setBlockToAir(x + 4, y + 3, z + 7);
        world.setBlockToAir(x + 4, y + 3, z + 8);
        world.setBlock(x + 4, y + 4, z + 0, Blocks.cobblestone);
        world.setBlock(x + 4, y + 4, z + 1, Blocks.cobblestone);
        world.setBlock(x + 4, y + 4, z + 2, Blocks.cobblestone);
        world.setBlock(x + 4, y + 4, z + 3, Blocks.cobblestone);
        world.setBlock(x + 4, y + 4, z + 4, Blocks.cobblestone);
        world.setBlock(x + 4, y + 4, z + 5, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 4, z + 6);
        world.setBlockToAir(x + 4, y + 4, z + 7);
        world.setBlockToAir(x + 4, y + 4, z + 8);
        world.setBlockToAir(x + 4, y + 5, z + 0);
        world.setBlock(x + 4, y + 5, z + 1, Blocks.cobblestone);
        world.setBlock(x + 4, y + 5, z + 2, Blocks.cobblestone);
        world.setBlock(x + 4, y + 5, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 5, z + 4);
        world.setBlockToAir(x + 4, y + 5, z + 5);
        world.setBlockToAir(x + 4, y + 5, z + 6);
        world.setBlockToAir(x + 4, y + 5, z + 7);
        world.setBlockToAir(x + 4, y + 5, z + 8);
        world.setBlockToAir(x + 4, y + 6, z + 0);
        world.setBlock(x + 4, y + 6, z + 1, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 6, z + 2);
        world.setBlock(x + 4, y + 6, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 6, z + 4);
        world.setBlockToAir(x + 4, y + 6, z + 5);
        world.setBlockToAir(x + 4, y + 6, z + 6);
        world.setBlockToAir(x + 4, y + 6, z + 7);
        world.setBlockToAir(x + 4, y + 6, z + 8);
        world.setBlockToAir(x + 4, y + 7, z + 0);
        world.setBlock(x + 4, y + 7, z + 1, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 7, z + 2);
        world.setBlock(x + 4, y + 7, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 7, z + 4);
        world.setBlockToAir(x + 4, y + 7, z + 5);
        world.setBlockToAir(x + 4, y + 7, z + 6);
        world.setBlockToAir(x + 4, y + 7, z + 7);
        world.setBlockToAir(x + 4, y + 7, z + 8);
        world.setBlockToAir(x + 4, y + 8, z + 0);
        world.setBlock(x + 4, y + 8, z + 1, Blocks.cobblestone);
        world.setBlock(x + 4, y + 8, z + 2, Blocks.cobblestone);
        world.setBlock(x + 4, y + 8, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 8, z + 4);
        world.setBlockToAir(x + 4, y + 8, z + 5);
        world.setBlockToAir(x + 4, y + 8, z + 6);
        world.setBlockToAir(x + 4, y + 8, z + 7);
        world.setBlockToAir(x + 4, y + 8, z + 8);
        world.setBlock(x + 4, y + 9, z + 0, Blocks.cobblestone);
        world.setBlock(x + 4, y + 9, z + 1, Blocks.cobblestone);
        world.setBlock(x + 4, y + 9, z + 2, Blocks.cobblestone);
        world.setBlock(x + 4, y + 9, z + 3, Blocks.cobblestone);
        world.setBlock(x + 4, y + 9, z + 4, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 9, z + 5);
        world.setBlockToAir(x + 4, y + 9, z + 6);
        world.setBlockToAir(x + 4, y + 9, z + 7);
        world.setBlockToAir(x + 4, y + 9, z + 8);
        world.setBlockToAir(x + 4, y + 10, z + 0);
        world.setBlock(x + 4, y + 10, z + 1, Blocks.cobblestone);
        world.setBlock(x + 4, y + 10, z + 2, Blocks.cobblestone);
        world.setBlock(x + 4, y + 10, z + 3, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 10, z + 4);
        world.setBlockToAir(x + 4, y + 10, z + 5);
        world.setBlockToAir(x + 4, y + 10, z + 6);
        world.setBlockToAir(x + 4, y + 10, z + 7);
        world.setBlockToAir(x + 4, y + 10, z + 8);
        world.setBlockToAir(x + 4, y + 11, z + 0);
        world.setBlockToAir(x + 4, y + 11, z + 1);
        world.setBlock(x + 4, y + 11, z + 2, Blocks.cobblestone);
        world.setBlockToAir(x + 4, y + 11, z + 3);
        world.setBlockToAir(x + 4, y + 11, z + 4);
        world.setBlockToAir(x + 4, y + 11, z + 5);
        world.setBlockToAir(x + 4, y + 11, z + 6);
        world.setBlockToAir(x + 4, y + 11, z + 7);
        world.setBlockToAir(x + 4, y + 11, z + 8);
        world.setBlockToAir(x + 4, y + 12, z + 0);
        world.setBlockToAir(x + 4, y + 12, z + 1);
        world.setBlockToAir(x + 4, y + 12, z + 2);
        world.setBlockToAir(x + 4, y + 12, z + 3);
        world.setBlockToAir(x + 4, y + 12, z + 4);
        world.setBlockToAir(x + 4, y + 12, z + 5);
        world.setBlockToAir(x + 4, y + 12, z + 6);
        world.setBlockToAir(x + 4, y + 12, z + 7);
        world.setBlockToAir(x + 4, y + 12, z + 8);
        world.setBlock(x + 3, y + 1, z + 3, Blocks.ladder, 4, 3);
        world.setBlock(x + 3, y + 2, z + 3, Blocks.ladder, 4, 3);
        world.setBlock(x + 3, y + 3, z + 3, Blocks.ladder, 4, 3);
        world.setBlock(x + 3, y + 7, z + 3, Blocks.ladder, 4, 3);
        world.setBlock(x + 3, y + 8, z + 3, Blocks.ladder, 4, 3);
        world.setBlock(x + 3, y + 9, z + 3, Blocks.ladder, 4, 3);

        return true;
    }
}