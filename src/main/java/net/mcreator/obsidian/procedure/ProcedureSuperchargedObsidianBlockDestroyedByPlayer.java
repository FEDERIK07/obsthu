package net.mcreator.obsidian.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureSuperchargedObsidianBlockDestroyedByPlayer extends ElementsWaterandLava.ModElement {
	public ProcedureSuperchargedObsidianBlockDestroyedByPlayer(ElementsWaterandLava instance) {
		super(instance, 95);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure SuperchargedObsidianBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure SuperchargedObsidianBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure SuperchargedObsidianBlockDestroyedByPlayer!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure SuperchargedObsidianBlockDestroyedByPlayer!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (100); index0++) {
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
		}
		world.setWorldTime((int) 5);
	}
}
