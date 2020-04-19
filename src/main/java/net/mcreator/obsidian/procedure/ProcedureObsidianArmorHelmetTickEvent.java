package net.mcreator.obsidian.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureObsidianArmorHelmetTickEvent extends ElementsWaterandLava.ModElement {
	public ProcedureObsidianArmorHelmetTickEvent(ElementsWaterandLava instance) {
		super(instance, 55);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ObsidianArmorHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, (int) 60, (int) 1, (true), (false)));
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, (int) 60, (int) 1, (true), (false)));
	}
}
