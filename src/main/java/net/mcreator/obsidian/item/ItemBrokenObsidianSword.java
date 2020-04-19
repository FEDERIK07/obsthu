
package net.mcreator.obsidian.item;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;

import net.mcreator.obsidian.creativetab.TabObsidian;
import net.mcreator.obsidian.ElementsWaterandLava;

import java.util.List;

import com.google.common.collect.Multimap;

@ElementsWaterandLava.ModElement.Tag
public class ItemBrokenObsidianSword extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:brokenobsidiansword")
	public static final Item block = null;
	public ItemBrokenObsidianSword(ElementsWaterandLava instance) {
		super(instance, 47);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new ItemCustom());
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(block, 0, new ModelResourceLocation("obsidian:brokenobsidiansword", "inventory"));
	}
	public static class ItemCustom extends Item {
		public ItemCustom() {
			setMaxDamage(18000);
			maxStackSize = 8;
			setUnlocalizedName("brokenobsidiansword");
			setRegistryName("brokenobsidiansword");
			setCreativeTab(TabObsidian.tab);
		}

		@Override
		public int getItemEnchantability() {
			return 2000;
		}

		@Override
		public int getMaxItemUseDuration(ItemStack itemstack) {
			return 20000;
		}

		@Override
		public float getDestroySpeed(ItemStack par1ItemStack, IBlockState par2Block) {
			return 1F;
		}

		@Override
		public Multimap<String, AttributeModifier> getItemAttributeModifiers(EntityEquipmentSlot slot) {
			Multimap<String, AttributeModifier> multimap = super.getItemAttributeModifiers(slot);
			if (slot == EntityEquipmentSlot.MAINHAND) {
				multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(),
						new AttributeModifier(ATTACK_DAMAGE_MODIFIER, "Item modifier", (double) 16, 0));
				multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(ATTACK_SPEED_MODIFIER, "Item modifier", -2.4, 0));
			}
			return multimap;
		}

		@Override
		@SideOnly(Side.CLIENT)
		public boolean hasEffect(ItemStack itemstack) {
			return true;
		}

		@Override
		public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
			return true;
		}

		@Override
		public void addInformation(ItemStack itemstack, World world, List<String> list, ITooltipFlag flag) {
			super.addInformation(itemstack, world, list, flag);
			list.add("It is a broken sword");
			list.add("the end is very sharp");
		}
	}
}
