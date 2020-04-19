
package net.mcreator.obsidian.fuel;

import net.minecraft.item.ItemStack;
import net.minecraft.init.Items;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class FuelStick extends ElementsWaterandLava.ModElement {
	public FuelStick(ElementsWaterandLava instance) {
		super(instance, 24);
	}

	@Override
	public int addFuel(ItemStack fuel) {
		if (fuel.getItem() == new ItemStack(Items.STICK, (int) (1)).getItem())
			return 1600;
		return 0;
	}
}
