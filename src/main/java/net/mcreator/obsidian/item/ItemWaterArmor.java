
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

import net.mcreator.obsidian.procedure.ProcedureWaterArmorHelmetTickEvent;
import net.mcreator.obsidian.creativetab.TabWater;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ItemWaterArmor extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:waterarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("obsidian:waterarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("obsidian:waterarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("obsidian:waterarmorboots")
	public static final Item boots = null;
	public ItemWaterArmor(ElementsWaterandLava instance) {
		super(instance, 3);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("WATERARMOR", "obsidian:water", 26, new int[]{4, 6, 7, 4}, 10,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("block.water.ambient")), 1f);
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
					ProcedureWaterArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("waterarmorhelmet").setRegistryName("waterarmorhelmet").setCreativeTab(TabWater.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("waterarmorbody")
				.setRegistryName("waterarmorbody").setCreativeTab(TabWater.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("waterarmorlegs")
				.setRegistryName("waterarmorlegs").setCreativeTab(TabWater.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("waterarmorboots")
				.setRegistryName("waterarmorboots").setCreativeTab(TabWater.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("obsidian:waterarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("obsidian:waterarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("obsidian:waterarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("obsidian:waterarmorboots", "inventory"));
	}
}
