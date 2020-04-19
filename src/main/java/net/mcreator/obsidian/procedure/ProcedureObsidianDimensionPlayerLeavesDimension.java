package net.mcreator.obsidian.procedure;

import net.minecraft.world.World;
import net.minecraft.entity.effect.EntityLightningBolt;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureObsidianDimensionPlayerLeavesDimension extends ElementsWaterandLava.ModElement {
	public ProcedureObsidianDimensionPlayerLeavesDimension(ElementsWaterandLava instance) {
		super(instance, 96);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ObsidianDimensionPlayerLeavesDimension!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ObsidianDimensionPlayerLeavesDimension!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ObsidianDimensionPlayerLeavesDimension!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ObsidianDimensionPlayerLeavesDimension!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		for (int index0 = 0; index0 < (int) (100); index0++) {
			if (!world.isRemote) {
				world.createExplosion(null, (int) x, (int) y, (int) z, (float) 4, true);
			}
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
		}
	}
}
