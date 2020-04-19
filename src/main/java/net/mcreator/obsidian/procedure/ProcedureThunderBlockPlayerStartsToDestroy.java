package net.mcreator.obsidian.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.obsidian.potion.PotionElectrification;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureThunderBlockPlayerStartsToDestroy extends ElementsWaterandLava.ModElement {
	public ProcedureThunderBlockPlayerStartsToDestroy(ElementsWaterandLava instance) {
		super(instance, 125);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ThunderBlockPlayerStartsToDestroy!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionElectrification.potion, (int) 5, (int) 10));
	}
}
