
package net.mcreator.obsidian.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.world.World;
import net.minecraft.world.IBlockAccess;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.NonNullList;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.EnumPushReaction;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.obsidian.procedure.ProcedureThunderBlockPlayerStartsToDestroy;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class BlockThunderBlock extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:thunderblock")
	public static final Block block = null;
	public BlockThunderBlock(ElementsWaterandLava instance) {
		super(instance, 125);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("thunderblock"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("obsidian:thunderblock", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("thunderblock");
			setSoundType(SoundType.GLASS);
			setHarvestLevel("pickaxe", 7);
			setHardness(200F);
			setResistance(200F);
			setLightLevel(1F);
			setLightOpacity(255);
			setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		}

		@Override
		public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
			return true;
		}

		@Override
		public EnumPushReaction getMobilityFlag(IBlockState state) {
			return EnumPushReaction.PUSH_ONLY;
		}

		@Override
		public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
			drops.add(new ItemStack(BlockThunderOre.block, (int) (1)));
		}

		@Override
		public void onBlockClicked(World world, BlockPos pos, EntityPlayer entity) {
			super.onBlockClicked(world, pos, entity);
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			{
				java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
				$_dependencies.put("entity", entity);
				ProcedureThunderBlockPlayerStartsToDestroy.executeProcedure($_dependencies);
			}
		}
	}
}
