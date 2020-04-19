package net.mcreator.obsidian.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.init.MobEffects;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureLavaArmorHelmetTickEvent extends ElementsWaterandLava.ModElement {
	public ProcedureLavaArmorHelmetTickEvent(ElementsWaterandLava instance) {
		super(instance, 31);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure LavaArmorHelmetTickEvent!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, (int) 3, (int) 1, (false), (false)));
	}
}
