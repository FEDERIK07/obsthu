
package net.mcreator.obsidian.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class TabObsidian extends ElementsWaterandLava.ModElement {
	public TabObsidian(ElementsWaterandLava instance) {
		super(instance, 43);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabobsidian") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(Blocks.OBSIDIAN, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
