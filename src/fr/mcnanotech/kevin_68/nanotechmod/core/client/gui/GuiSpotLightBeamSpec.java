package fr.mcnanotech.kevin_68.nanotechmod.core.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import fr.mcnanotech.kevin_68.nanotechmod.core.container.ContainerSpotLight;
import fr.mcnanotech.kevin_68.nanotechmod.core.network.PacketSender;
import fr.mcnanotech.kevin_68.nanotechmod.core.tileentity.TileEntitySpotLight;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiBooleanButton;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiContainerSliderBase;
import fr.minecraftforgefrance.ffmtlibs.client.gui.GuiSliderForContainer;

public class GuiSpotLightBeamSpec extends GuiContainerSliderBase
{
	protected static final ResourceLocation texture = new ResourceLocation("nanotechmod:textures/gui/spotlighttex.png");

	public InventoryPlayer invPlayer;
	public TileEntitySpotLight tileSpotLight;
	public World world;
	public GuiBooleanButton rotateButton, revRotaButton, secLaserButton;
	
	public GuiSpotLightBeamSpec(InventoryPlayer playerInventory, TileEntitySpotLight tileEntity, World wrld)
	{
		super(new ContainerSpotLight(tileEntity, playerInventory, wrld));
		invPlayer = playerInventory;
		tileSpotLight = tileEntity;
		world = wrld;
	}

	@Override
	public void initGui()
	{
		super.initGui();
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;

		this.buttonList.add(new GuiSliderForContainer(this, 0, x - 40, y - 15, 256, 20, "Angle 1 : " + tileSpotLight.get(8), (float)(tileSpotLight.get(8)) / 360.0F));
		this.buttonList.add(new GuiSliderForContainer(this, 1, x - 40, y + 7, 256, 20, "Angle 2 : " + tileSpotLight.get(9), (float)(tileSpotLight.get(9)) / 180.0F));
		this.buttonList.add(rotateButton = new GuiBooleanButton(2, x - 40, y + 29, 127, 20, "Auto Rotate On", "Auto Rotate Off", tileSpotLight.get(10) == 0 ? false : true));
		this.buttonList.add(revRotaButton = new GuiBooleanButton(3, x + 90, y + 29, 127, 20, "Reverse Rotation On", "Reverse Rotation Off", tileSpotLight.get(11) == 0 ? false : true));
		this.buttonList.add(new GuiSliderForContainer(this, 4, x - 40, y + 52, 256, 20, "Rotation Speed : " + tileSpotLight.get(12), (float)(tileSpotLight.get(12)) / 20.0F));
		this.buttonList.add(secLaserButton = new GuiBooleanButton(5, x - 40, y + 74, 256, 20, "Secondary laser On", "Secondary laser Off", tileSpotLight.get(13) == 0 ? false : true));
		this.buttonList.add(new GuiButton(6, x + 38, y + 117, 100, 20, "Back"));
	}

	@Override
	protected void actionPerformed(GuiButton guibutton)
	{
		switch(guibutton.id)
		{
		case 2:
		{
			rotateButton.toggle();
			PacketSender.sendSpotLightPacket(tileSpotLight, 10, rotateButton.getIsActive() ? 1 : 0);
			break;
		}
		case 3:
		{
			revRotaButton.toggle();
			PacketSender.sendSpotLightPacket(tileSpotLight, 11, revRotaButton.getIsActive() ? 1 : 0);
			break;
		}
		case 5:
		{
			secLaserButton.toggle();
			PacketSender.sendSpotLightPacket(tileSpotLight, 13, secLaserButton.getIsActive() ? 1 : 0);
			break;
		}
		case 6:
		{
			this.mc.displayGuiScreen(new GuiSpotLight(invPlayer, tileSpotLight, world));
			break;
		}
		}
	}

	@Override
	public void handlerSliderAction(int sliderId, float sliderValue)
	{
		switch(sliderId)
		{
		case 0:
		{
			PacketSender.sendSpotLightPacket(tileSpotLight, 8, (int)(sliderValue * 360));
			break;
		}
		case 1:
		{
			PacketSender.sendSpotLightPacket(tileSpotLight, 9, (int)(sliderValue * 180));
			break;
		}
		case 4:
		{
			PacketSender.sendSpotLightPacket(tileSpotLight, 12, (int)(sliderValue * 20));
			break;
		}
		}
	}

	@Override
	public String getSliderName(int sliderId, float sliderValue)
	{
		String name = "";
		switch(sliderId)
		{
		case 0:
		{
			name = "Angle 1 : " + (int)(sliderValue * 360);
			break;
		}
		case 1:
		{
			name = "Angle 2 : " + (int)(sliderValue * 180);
			break;
		}
		case 4:
		{
			name = "Rotation Speed : " + (int)(sliderValue * 20);
			break;
		}
		}
		return name;
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j)
	{
		GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
		int x = (width - xSize) / 2;
		int y = (height - ySize) / 2;
		this.mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
	}
}