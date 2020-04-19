
package net.mcreator.obsidian.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.obsidian.ElementsWaterandLava;

import java.util.Set;
import java.util.HashMap;

@ElementsWaterandLava.ModElement.Tag
public class ItemThundersHoe extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:thundershoe")
	public static final Item block = null;
	public ItemThundersHoe(ElementsWaterandLava instance) {
		super(instance, 114);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemHoe(EnumHelper.addToolMaterial("THUNDERSHOE", 14, 3811, 19f, 0f, 98)) {
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("hoe", 14);
				return ret.keySet();
			}
		}.setUnlocalizedName("thundershoe").setRegistryName("thundershoe").setCreativeTab(CreativeTabs.TOOLS));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("obsidian:thundershoe", "inventory"));
	}
}
