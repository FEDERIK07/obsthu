
package net.mcreator.obsidian.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.obsidian.creativetab.TabObsidian;
import net.mcreator.obsidian.ElementsWaterandLava;

import java.util.Set;
import java.util.HashMap;

@ElementsWaterandLava.ModElement.Tag
public class ItemObsidiansShovel extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:obsidiansshovel")
	public static final Item block = null;
	public ItemObsidiansShovel(ElementsWaterandLava instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("OBSIDIANSSHOVEL", 20, 6280, 24f, 16f, 140)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 20);
				return ret.keySet();
			}
		}.setUnlocalizedName("obsidiansshovel").setRegistryName("obsidiansshovel").setCreativeTab(TabObsidian.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("obsidian:obsidiansshovel", "inventory"));
	}
}
