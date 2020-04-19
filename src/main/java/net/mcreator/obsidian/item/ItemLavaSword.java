
package net.mcreator.obsidian.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemSword;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.obsidian.creativetab.TabLava;
import net.mcreator.obsidian.ElementsWaterandLava;

import java.util.Set;
import java.util.HashMap;

import com.google.common.collect.Multimap;

@ElementsWaterandLava.ModElement.Tag
public class ItemLavaSword extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:lavasword")
	public static final Item block = null;
	public ItemLavaSword(ElementsWaterandLava instance) {
		super(instance, 39);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemSword(EnumHelper.addToolMaterial("LAVASWORD", 5, 500, 7f, 1f, 6)) {
			@Override
			public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot) {
				Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
				if (slot == EntityEquipmentSlot.MAINHAND) {
					multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
							new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Weapon modifier", (double) this.getAttackDamage(), 0));
					multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(),
							new AttributeModifier(ATTACK_SPEED_MODIFIER, "Weapon modifier", -2, 0));
				}
				return multimap;
			}

			public Set<String> getToolClasses(ItemStack stack) {
				HashMap<String, Integer> ret = new HashMap<String, Integer>();
				ret.put("sword", 5);
				return ret.keySet();
			}
		}.setUnlocalizedName("lavasword").setRegistryName("lavasword").setCreativeTab(TabLava.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("obsidian:lavasword", "inventory"));
	}
}
