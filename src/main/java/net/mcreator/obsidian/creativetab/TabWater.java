
package net.mcreator.obsidian.creativetab;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;
import net.minecraft.creativetab.CreativeTabs;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class TabWater extends ElementsWaterandLava.ModElement {
	public TabWater(ElementsWaterandLava instance) {
		super(instance, 9);
	}

	@Override
	public void initElements() {
		tab = new CreativeTabs("tabwater") {
			@SideOnly(Side.CLIENT)
			@Override
			public ItemStack getTabIconItem() {
				return new ItemStack(Items.WATER_BUCKET, (int) (1));
			}

			@SideOnly(Side.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundImageName("item_search.png");
	}
	public static CreativeTabs tab;
}
