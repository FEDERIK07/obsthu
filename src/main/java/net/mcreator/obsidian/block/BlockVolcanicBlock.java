
package net.mcreator.obsidian.block;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.event.ModelRegistryEvent;

import net.minecraft.item.ItemBlock;
import net.minecraft.item.Item;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.block.material.Material;
import net.minecraft.block.SoundType;
import net.minecraft.block.Block;

import net.mcreator.obsidian.creativetab.TabLava;
import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class BlockVolcanicBlock extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:volcanicblock")
	public static final Block block = null;
	public BlockVolcanicBlock(ElementsWaterandLava instance) {
		super(instance, 93);
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustom().setRegistryName("volcanicblock"));
		elements.items.add(() -> new ItemBlock(block).setRegistryName(block.getRegistryName()));
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void registerModels(ModelRegistryEvent event) {
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation("obsidian:volcanicblock", "inventory"));
	}
	public static class BlockCustom extends Block {
		public BlockCustom() {
			super(Material.ROCK);
			setUnlocalizedName("volcanicblock");
			setSoundType(SoundType.STONE);
			setHardness(3.15F);
			setResistance(30F);
			setLightLevel(0.03F);
			setLightOpacity(255);
			setCreativeTab(TabLava.tab);
		}
	}
}
