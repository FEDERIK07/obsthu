package net.mcreator.obsidian.procedure;

import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.Entity;

import net.mcreator.obsidian.potion.PotionElectrification;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureElectrificationEntityCollidesInTheBlock extends ElementsWaterandLava.ModElement {
	public ProcedureElectrificationEntityCollidesInTheBlock(ElementsWaterandLava instance) {
		super(instance, 108);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure ElectrificationEntityCollidesInTheBlock!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof EntityLivingBase)
			((EntityLivingBase) entity).addPotionEffect(new PotionEffect(PotionElectrification.potion, (int) 60, (int) 1, (false), (false)));
	}
}
