
package net.mcreator.obsidian.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Blocks;

import net.mcreator.obsidian.item.ItemObsidianIngot;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class RecipeObsidianingotrecipe extends ElementsWaterandLava.ModElement {
	public RecipeObsidianingotrecipe(ElementsWaterandLava instance) {
		super(instance, 44);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Blocks.OBSIDIAN, (int) (1)), new ItemStack(ItemObsidianIngot.block, (int) (0)), 0F);
	}
}
