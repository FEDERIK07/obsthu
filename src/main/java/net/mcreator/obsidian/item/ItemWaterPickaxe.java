
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

import net.mcreator.obsidian.creativetab.TabWater;
import net.mcreator.obsidian.ElementsWaterandLava;

import java.util.Set;
import java.util.HashMap;

@ElementsWaterandLava.ModElement.Tag
public class ItemWaterPickaxe extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:waterpickaxe")
	public static final Item block = null;
	public ItemWaterPickaxe(ElementsWaterandLava instance) {
		super(instance, 2);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemPickaxe(EnumHelper.addToolMaterial("WATERPICKAXE", 2, 150, 5f, 1f, 3)) {
			{
				this.attackSpeed = -2f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("pickaxe", 2);
				return ret.keySet();
			}
		}.setUnlocalizedName("waterpickaxe").setRegistryName("waterpickaxe").setCreativeTab(TabWater.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("obsidian:waterpickaxe", "inventory"));
	}
}
