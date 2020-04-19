
package net.mcreator.obsidian.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.statemap.StateMapperBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.ItemMeshDefinition;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.Block;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class BlockLiquidobsidian extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:liquidobsidian")
	public static final Block block = null;
	@GameRegistry.ObjectHolder("obsidian:liquidobsidian")
	public static final Item item = null;
	private Fluid fluid;
	public BlockLiquidobsidian(ElementsWaterandLava instance) {
		super(instance, 41);
		fluid = new Fluid("liquidobsidian", new ResourceLocation("obsidian:blocks/obsidian"), new ResourceLocation("obsidian:blocks/12703632-pack_l"))
				.setLuminosity(0).setDensity(3000).setViscosity(3000).setGaseous(true);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockFluidClassic(fluid, Material.LAVA) {
		}.setUnlocalizedName("liquidobsidian").setRegistryName("liquidobsidian"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName("liquidobsidian"));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels(ModelRegistryEvent event) {
		ModelBakery.registerItemVariants(item);
		ModelLoader.setCustomMeshDefinition(item, new ItemMeshDefinition() {
			@Override
			public ModelResourceLocation getModelLocation(ItemStack stack) {
				return new ModelResourceLocation("obsidian:liquidobsidian", "liquidobsidian");
			}
		});
		ModelLoader.setCustomStateMapper(block, new StateMapperBase() {
			@Override
			protected ModelResourceLocation getModelResourceLocation(IBlockState state) {
				return new ModelResourceLocation("obsidian:liquidobsidian", "liquidobsidian");
			}
		});
	}
}
