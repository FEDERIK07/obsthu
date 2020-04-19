
package net.mcreator.obsidian.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.obsidian.creativetab.TabObsidian;
import net.mcreator.obsidian.ElementsWaterandLava;

import java.util.Set;
import java.util.HashMap;

@ElementsWaterandLava.ModElement.Tag
public class ItemObsidiansPickaxe extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:obsidianspickaxe")
	public static final Item block = null;
	public ItemObsidiansPickaxe(ElementsWaterandLava instance) {
		super(instance, 61);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("OBSIDIANSPICKAXE", 20, 6280, 24f, 16f, 140)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 20);
				return ret.keySet();
			}
		}.setUnlocalizedName("obsidianspickaxe").setRegistryName("obsidianspickaxe").setCreativeTab(TabObsidian.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("obsidian:obsidianspickaxe", "inventory"));
	}
}
