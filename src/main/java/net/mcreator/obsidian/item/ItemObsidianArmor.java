
package net.mcreator.obsidian.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;

import net.mcreator.obsidian.procedure.ProcedureObsidianArmorHelmetTickEvent;
import net.mcreator.obsidian.creativetab.TabObsidian;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ItemObsidianArmor extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:obsidianarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("obsidian:obsidianarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("obsidian:obsidianarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("obsidian:obsidianarmorboots")
	public static final Item boots = null;
	public ItemObsidianArmor(ElementsWaterandLava instance) {
		super(instance, 55);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("OBSIDIANARMOR", "obsidian:bsidian_", 1024, new int[]{1024, 1024, 1024, 1024},
				100, (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("")), 5f);
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.HEAD) {
			@Override
			public void onArmorTick(World world, EntityPlayer entity, ItemStack itemstack) {
				super.onArmorTick(world, entity, itemstack);
				int x = (int) entity.posX;
				int y = (int) entity.posY;
				int z = (int) entity.posZ;
				{
					java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
					$_dependencies.put("entity", entity);
					ProcedureObsidianArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("obsidianarmorhelmet").setRegistryName("obsidianarmorhelmet").setCreativeTab(TabObsidian.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("obsidianarmorbody")
				.setRegistryName("obsidianarmorbody").setCreativeTab(TabObsidian.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("obsidianarmorlegs")
				.setRegistryName("obsidianarmorlegs").setCreativeTab(TabObsidian.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("obsidianarmorboots")
				.setRegistryName("obsidianarmorboots").setCreativeTab(TabObsidian.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("obsidian:obsidianarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("obsidian:obsidianarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("obsidian:obsidianarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("obsidian:obsidianarmorboots", "inventory"));
	}
}
