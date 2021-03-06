/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.minecraftforgefrance.ffmtlibs.container.ContainerHelper;

public class ItemCrazyGlassesGun extends ItemBow
{
    public int timer = 0;

    public ItemCrazyGlassesGun()
    {
        super();
        this.maxStackSize = 1;
        this.setMaxDamage(300000);
    }

    @Override
    public ItemStack onEaten(ItemStack stack, World world, EntityPlayer player)
    {
        return stack;
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if(!world.isRemote)
        {
            if(!stack.hasTagCompound())
            {
                stack.setTagCompound(new NBTTagCompound());
            }

            if(!stack.getTagCompound().hasKey("IsPlayingSound"))
            {
                stack.getTagCompound().setBoolean("IsPlayingSound", false);
            }

            if(stack.getTagCompound().getByte("Charge") > 0)
            {
                if(!stack.getTagCompound().getBoolean("Reload"))
                {
                    this.shoot(stack, world, player);
                    if((stack.getTagCompound().getByte("Charge") - 1) == 0)
                    {
                        stack.getTagCompound().setBoolean("Reload", true);
                        stack.getTagCompound().setBoolean("IsPlayingSound", false);
                    }
                    if(!player.capabilities.isCreativeMode)
                    {
                        stack.getTagCompound().setByte("Charge", (byte)(stack.getTagCompound().getByte("Charge") - 1));
                    }

                }
            }
            else
            {
                stack.getTagCompound().setBoolean("Reload", true);
            }
        }
        return stack;
    }

    @Override
    public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isCurrentItem)
    {
        if(!world.isRemote)
        {
            if(entity instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer)entity;
                if(player.inventory.hasItemStack(new ItemStack(NanotechItem.itemBase, 1, 20)))
                {
                    if(!stack.hasTagCompound())
                    {
                        stack.setTagCompound(new NBTTagCompound());
                    }

                    if(stack.getTagCompound().hasKey("Reload"))
                    {
                        if(stack.getTagCompound().getBoolean("Reload"))
                        {
                            if(timer == 40)
                            {
                                stack.getTagCompound().setBoolean("Reload", false);
                                timer = 0;
                            }
                            else if(timer == 6 || timer == 16 || timer == 26 || timer == 36)
                            {
                                if(ContainerHelper.consumeItemWithMetadataInInventory((EntityPlayer)entity, NanotechItem.itemBase, 20))
                                {
                                    stack.getTagCompound().setByte("Charge", (byte)(stack.getTagCompound().getByte("Charge") + 1));
                                }
                                timer++;
                            }
                            else if(timer == 1)
                            {
                                if(!stack.getTagCompound().getBoolean("IsPlayingSound"))
                                {
                                    world.playSoundAtEntity(entity, "nanotechmod:crazyglassesgun.reload", 1.0F, 1.0F);
                                    stack.getTagCompound().setBoolean("IsPlayingSound", true);
                                }
                                timer++;
                            }
                            else
                            {
                                timer++;
                            }
                        }
                    }
                    else
                    {
                        stack.getTagCompound().setBoolean("Reload", true);
                    }
                }
            }
        }
    }

    public void shoot(ItemStack stack, World world, EntityPlayer player)
    {
        if(player.capabilities.isCreativeMode || player.inventory.hasItemStack(new ItemStack(NanotechItem.itemBase, 1, 20)))
        {
            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
            EntityItem glasses = new EntityItem(world);
            glasses.delayBeforeCanPickup = 5;
            glasses.setEntityItemStack(new ItemStack(NanotechItem.crazyGlasses, 1, 0));
            glasses.setLocationAndAngles(player.posX, player.posY + (double)player.getEyeHeight(), player.posZ, player.rotationYaw, player.rotationPitch);
            glasses.posX -= (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
            glasses.posY -= 0.10000000149011612D;
            glasses.posZ -= (double)(MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * 0.16F);
            glasses.setPosition(glasses.posX, glasses.posY, glasses.posZ);
            glasses.yOffset = 0.0F;
            glasses.motionX = (double)(-MathHelper.sin(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
            glasses.motionZ = (double)(MathHelper.cos(glasses.rotationYaw / 180.0F * (float)Math.PI) * MathHelper.cos(glasses.rotationPitch / 180.0F * (float)Math.PI));
            glasses.motionY = (double)(-MathHelper.sin(glasses.rotationPitch / 180.0F * (float)Math.PI));
            world.spawnEntityInWorld(glasses);

            if(!player.capabilities.isCreativeMode)
            {
                float f = 0.7F;
                double d0 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                double d1 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                double d2 = (double)(world.rand.nextFloat() * f) + (double)(1.0F - f) * 0.5D;
                EntityItem iron = new EntityItem(world, (double)player.posX + d0, (double)player.posY + d1, (double)player.posZ + d2, new ItemStack(Items.iron_ingot, 2, 0));
                iron.delayBeforeCanPickup = 10;
                world.spawnEntityInWorld(iron);
            }
        }
    }

    public int getItemEnchantability()
    {
        return 1;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iIconRegister)
    {
        // Empty no icon
    }
}