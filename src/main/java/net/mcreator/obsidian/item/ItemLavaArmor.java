
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

import net.mcreator.obsidian.procedure.ProcedureLavaArmorHelmetTickEvent;
import net.mcreator.obsidian.creativetab.TabLava;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ItemLavaArmor extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:lavaarmorhelmet")
	public static final Item helmet = null;
	@GameRegistry.ObjectHolder("obsidian:lavaarmorbody")
	public static final Item body = null;
	@GameRegistry.ObjectHolder("obsidian:lavaarmorlegs")
	public static final Item legs = null;
	@GameRegistry.ObjectHolder("obsidian:lavaarmorboots")
	public static final Item boots = null;
	public ItemLavaArmor(ElementsWaterandLava instance) {
		super(instance, 8);
	}

	@Override
	public void initElements() {
		ItemArmor.ArmorMaterial enuma = EnumHelper.addArmorMaterial("LAVAARMOR", "obsidian:lava", 27, new int[]{4, 6, 7, 4}, 10,
				(net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("obsidian:lava")), 0f);
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
					ProcedureLavaArmorHelmetTickEvent.executeProcedure($_dependencies);
				}
			}
		}.setUnlocalizedName("lavaarmorhelmet").setRegistryName("lavaarmorhelmet").setCreativeTab(TabLava.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.CHEST).setUnlocalizedName("lavaarmorbody")
				.setRegistryName("lavaarmorbody").setCreativeTab(TabLava.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.LEGS).setUnlocalizedName("lavaarmorlegs")
				.setRegistryName("lavaarmorlegs").setCreativeTab(TabLava.tab));
		elements.items.add(() -> new ItemArmor(enuma, 0, EntityEquipmentSlot.FEET).setUnlocalizedName("lavaarmorboots")
				.setRegistryName("lavaarmorboots").setCreativeTab(TabLava.tab));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(helmet, 0, new ModelResourceLocation("obsidian:lavaarmorhelmet", "inventory"));
		ModelLoader.setCustomModelResourceLocation(body, 0, new ModelResourceLocation("obsidian:lavaarmorbody", "inventory"));
		ModelLoader.setCustomModelResourceLocation(legs, 0, new ModelResourceLocation("obsidian:lavaarmorlegs", "inventory"));
		ModelLoader.setCustomModelResourceLocation(boots, 0, new ModelResourceLocation("obsidian:lavaarmorboots", "inventory"));
	}
}
