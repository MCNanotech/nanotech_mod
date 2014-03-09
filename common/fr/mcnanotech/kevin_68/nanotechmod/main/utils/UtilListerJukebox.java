/**
 * This work is made available under the terms of the Creative Commons Attribution License:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.en
 * 
 * Cette œuvre est mise à disposition selon les termes de la Licence Creative Commons Attribution:
 * http://creativecommons.org/licenses/by-nc-sa/4.0/deed.fr
 */
package fr.mcnanotech.kevin_68.nanotechmod.main.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.ModContainer;
import fr.mcnanotech.kevin_68.nanotechmod.main.core.NanotechMod;

public class UtilListerJukebox
{
	private static final File mcDir = Minecraft.getMinecraft().mcDataDir;
	private static final File mainDir = new File(new File(mcDir, "nanotechmod"), "jukebox");
	private static final File txtDir = new File(mainDir, "sounds_" + Minecraft.getMinecraft().getSession().getUsername() + ".txt");
	private static final File categDir = new File(mainDir, "category.txt");

	public static void debug()
	{
		NanotechMod.nanoLogger.info("~~~~~~~~~~~Starting Lister JukeBox debug~~~~~~~~~~~");
		NanotechMod.nanoLogger.info(mcDir);
		NanotechMod.nanoLogger.info(mainDir);
		NanotechMod.nanoLogger.info(txtDir);
		NanotechMod.nanoLogger.info(categDir);
		NanotechMod.nanoLogger.info("~~~~~~~~~~~Ending Lister JukeBox debug~~~~~~~~~~~");
	}

	public static void init()
	{
		if(!mainDir.exists())
		{
			mainDir.mkdirs();
			NanotechMod.nanoLogger.info("Folders created");
		}

		if(!txtDir.exists())
		{
			try
			{
				txtDir.createNewFile();
				NanotechMod.nanoLogger.info("File created");
				try
				{
					FileWriter writer = new FileWriter(txtDir);
					try
					{
						writer.write("#This file contain all the sounds of " + Minecraft.getMinecraft().getSession().getUsername() + "\n");
						writer.write("#musiquename~category~color\n");
						NanotechMod.nanoLogger.info("Informations added");
					}
					catch(IOException e)
					{
						e.printStackTrace();
						NanotechMod.nanoLogger.error("Failed to write informations");
					}
					finally
					{
						writer.close();
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
					NanotechMod.nanoLogger.error("Error on FileWriter");
				}
			}
			catch(IOException e)
			{
				NanotechMod.nanoLogger.error("Failed to create file");
				e.printStackTrace();
			}
		}

		if(!categDir.exists())
		{
			try
			{
				categDir.createNewFile();
				NanotechMod.nanoLogger.info("File created");
				try
				{
					FileWriter writer = new FileWriter(categDir);
					try
					{
						writer.write("#This file contain all category\n");
						writer.write("#category~color~owner\n");
						NanotechMod.nanoLogger.info("Informations added");
					}
					catch(IOException e)
					{
						e.printStackTrace();
						NanotechMod.nanoLogger.error("Failed to write informations");
					}
					finally
					{
						writer.close();
					}
				}
				catch(IOException e)
				{
					e.printStackTrace();
					NanotechMod.nanoLogger.error("Error on FileWriter");
				}
			}
			catch(IOException e)
			{
				NanotechMod.nanoLogger.error("Failed to create file");
				e.printStackTrace();
			}
		}
	}

	public static File getMainDir()
	{
		return mainDir;
	}

	public static void write(String name)
	{
		write(name, "default");
	}

	public static void write(String name, String category)
	{
		write(name, category, 16777215);
	}

	public static void write(String name, String category, int color)
	{
		String categ = category.length() > 1 ? category : "default";

		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter(txtDir, true));
			writer.write(name + "~" + categ + "~" + color + "\n");
			writer.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	public static ArrayList<String> getModidList()
	{
		ArrayList<String> arrList = new ArrayList();
		List<ModContainer> modList = Loader.instance().getModList();
	
		arrList.add(0,"minecraft");
		
		for(int i = 1; i < modList.size() - 1; i++)
		{
			arrList.add(i, modList.get(i).getModId());
		}

		return arrList;
	}

	public static String getModid(int i)
	{
		return getModidList().get(i);
	}

	private static ArrayList<String> getCategory()
	{
		ArrayList<String> arrList = new ArrayList();
		arrList.add(0,  "default~16777215~kevin_68");
		try
		{
			BufferedReader reader = new BufferedReader(new FileReader(categDir));
			String line;
			while((line = reader.readLine()) != null)
			{
				if(!line.contains("#"))
				{
					arrList.add(arrList.size(), line);
				}
			}
			arrList.add(arrList.size(), reader.readLine());
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return arrList;
	}
	
	public static ArrayList<String> getCategoryName()
	{
		ArrayList<String> arrList = new ArrayList();
		ArrayList<String> arrListC = getCategory();
		for(int i = 0; i != arrListC.size() - 1; i++)
		{
			String[] str = arrListC.get(i).split("~");
			arrList.add(i, str[0]);
		}
		return arrList;
	}
	
	public static ArrayList<Integer> getCategoryColor()
	{
		ArrayList<Integer> arrList = new ArrayList();
		ArrayList<String> arrListC = getCategory();
		for(int i = 0; i != arrListC.size() - 1; i++)
		{
			String[] str = arrListC.get(i).split("~");
			arrList.add(i, Integer.valueOf(str[1]));
		}
		return arrList;
	}
	
	public static ArrayList<String> getCategoryOwner()
	{
		ArrayList<String> arrList = new ArrayList();
		ArrayList<String> arrListC = getCategory();
		for(int i = 0; i != arrListC.size() - 1; i++)
		{
			String[] str = arrListC.get(i).split("~");
			arrList.add(i, str[2]);
		}
		return arrList;
	}
	
	public static boolean categoryExist(String name)
	{
		return getCategoryName().contains(name);
	}
}