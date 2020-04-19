
package net.mcreator.obsidian.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ItemThundersArmor extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:thundersarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("obsidian:thundersarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("obsidian:thundersarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("obsidian:thundersarmorboots")
	public static final Item boots = null;
	public ItemThundersArmor(ElementsWaterandLava instance) {
		super(instance, 120);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("THUNDERSARMOR", "obsidian:thunders", 105, new int[]{14, 42, 35, 14}, 63,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 0f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD).setUnlocalizedName("thundersarmorhelmet")
				.setRegistryName("thundersarmorhelmet").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("thundersarmorbody")
				.setRegistryName("thundersarmorbody").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("thundersarmorlegs")
				.setRegistryName("thundersarmorlegs").setCreativeTab(CreativeTabs.COMBAT));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("thundersarmorboots")
				.setRegistryName("thundersarmorboots").setCreativeTab(CreativeTabs.COMBAT));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("obsidian:thundersarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("obsidian:thundersarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("obsidian:thundersarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("obsidian:thundersarmorboots", "inventory"));
	}
}
