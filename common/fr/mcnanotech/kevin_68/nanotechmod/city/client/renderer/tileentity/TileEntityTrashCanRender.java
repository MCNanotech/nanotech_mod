/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.city.client.renderer.tileentity;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import fr.mcnanotech.kevin_68.nanotechmod.city.client.model.blocks.ModelBlockTrashCan;
import fr.mcnanotech.kevin_68.nanotechmod.city.tileentity.TileEntityTrashCan;
import fr.minecraftforgefrance.ffmtlibs.client.renderer.TileEntityInventorySpecialRenderer;

public class TileEntityTrashCanRender extends TileEntityInventorySpecialRenderer
{
    private final ModelBlockTrashCan model = new ModelBlockTrashCan();
    private static final ResourceLocation texture = new ResourceLocation("nanotechmodcity", "textures/blocks/trashcan.png");

    @Override
    public void renderInventory(double x, double y, double z)
    {
        this.renderTileEntityTrashCanAt(null, x, y, z, 0);
    }

    @Override
    public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float tick)
    {
        this.renderTileEntityTrashCanAt((TileEntityTrashCan)tileentity, x, y, z, tick);
    }

    public void renderTileEntityTrashCanAt(TileEntityTrashCan tileentity, double x, double y, double z, float tick)
    {
        GL11.glPushMatrix();
        GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
        this.bindTexture(texture);
        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
        GL11.glScalef(0.8F, 0.8F, 0.8F);
        GL11.glTranslatef(0.0F, 0.38F, 0.0F);
        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
    }
}