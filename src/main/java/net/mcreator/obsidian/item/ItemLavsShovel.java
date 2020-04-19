
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

import net.mcreator.obsidian.creativetab.TabLava;
import net.mcreator.obsidian.ElementsWaterandLava;

import java.util.Set;
import java.util.HashMap;

@ElementsWaterandLava.ModElement.Tag
public class ItemLavsShovel extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:lavsshovel")
	public static final Item block = null;
	public ItemLavsShovel(ElementsWaterandLava instance) {
		super(instance, 84);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSpade(EnumHelper.addToolMaterial("LAVSSHOVEL", 5, 902, 10f, 1f, 35)) {
			{
				this.attackSpeed = -3f;
			}
			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("spade", 5);
				return ret.keySet();
			}
		}.setUnlocalizedName("lavsshovel").setRegistryName("lavsshovel").setCreativeTab(TabLava.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("obsidian:lavsshovel", "inventory"));
	}
}
