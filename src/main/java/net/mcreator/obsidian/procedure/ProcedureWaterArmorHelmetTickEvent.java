package net.mcreator.obsidian.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureWaterArmorHelmetTickEvent extends ElementsWaterandLava.ModElement {
	public ProcedureWaterArmorHelmetTickEvent(ElementsWaterandLava instance) {
		super(instance, 11);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure WaterArmorHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, (int) 3, (int) 1, (false), (false)));
	}
}
