package net.mcreator.obsidian.procedure;

import net.minecraft.world.World;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.obsidian.potion.PotionElectrification;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureElectrificationPotionStartedapplied extends ElementsWaterandLava.ModElement {
	public ProcedureElectrificationPotionStartedapplied(ElementsWaterandLava instance) {
		super(instance, 104);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ElectrificationPotionStartedapplied!");
			return;
		}
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ElectrificationPotionStartedapplied!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ElectrificationPotionStartedapplied!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ElectrificationPotionStartedapplied!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ElectrificationPotionStartedapplied!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionElectrification.potion, (int) 3600, (int) 1));
		world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
	}
}
