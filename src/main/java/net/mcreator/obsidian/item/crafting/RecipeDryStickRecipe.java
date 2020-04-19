
package net.mcreator.obsidian.item.crafting;

import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.obsidian.item.ItemDryStick;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class RecipeDryStickRecipe extends ElementsWaterandLava.ModElement {
	public RecipeDryStickRecipe(ElementsWaterandLava instance) {
		super(instance, 20);
	}

	@Override
	public void init(FMLInitializationEvent event) {
		GameRegistry.addSmelting(new ItemStack(Items.STICK, (int) (1)), new ItemStack(ItemDryStick.block, (int) (0)), 0F);
	}
}
