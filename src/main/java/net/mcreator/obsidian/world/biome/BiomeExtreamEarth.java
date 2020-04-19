
package net.mcreator.obsidian.world.biome;

import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary;

import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.entity.monster.EntityWitherSkeleton;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityEvoker;
import net.minecraft.entity.monster.EntityBlaze;

import net.mcreator.obsidian.block.BlockVolcanicBlock;
import net.mcreator.obsidian.ElementsWaterandLava;

import java.util.Random;

@ElementsWaterandLava.ModElement.Tag
public class BiomeExtreamEarth extends ElementsWaterandLava.ModElement {
	@GameRegistry.ObjectHolder("obsidian:extreamearth")
	public static final BiomeGenCustom biome = null;
	public BiomeExtreamEarth(ElementsWaterandLava instance) {
		super(instance, 94);
	}

	@Override
	public void initElements() {
		elements.biomes.add(() -> new BiomeGenCustom());
	}

	@Override
	public void init(FMLInitializationEvent event) {
		BiomeDictionary.addTypes(biome, BiomeDictionary.Type.MOUNTAIN);
		BiomeManager.addSpawnBiome(biome);
		BiomeManager.addBiome(BiomeManager.BiomeType.DESERT, new BiomeManager.BiomeEntry(biome, 70));
	}
	static class BiomeGenCustom extends Biome {
		public BiomeGenCustom() {
			super(new Biome.BiomeProperties("Extream Earth").setRainfall(0F).setBaseHeight(0.8F).setWaterColor(-39424).setHeightVariation(0.4F)
					.setTemperature(2F));
			setRegistryName("extreamearth");
			topBlock = BlockVolcanicBlock.block.getDefaultState();
			fillerBlock = Blocks.LAVA.getDefaultState();
			decorator.generateFalls = false;
			decorator.treesPerChunk = 0;
			decorator.flowersPerChunk = 0;
			decorator.grassPerChunk = 0;
			decorator.deadBushPerChunk = 0;
			decorator.mushroomsPerChunk = 0;
			decorator.bigMushroomsPerChunk = 0;
			decorator.reedsPerChunk = 0;
			decorator.cactiPerChunk = 0;
			decorator.sandPatchesPerChunk = 0;
			decorator.gravelPatchesPerChunk = 0;
			this.spawnableMonsterList.clear();
			this.spawnableCreatureList.clear();
			this.spawnableWaterCreatureList.clear();
			this.spawnableCaveCreatureList.clear();
			this.spawnableCreatureList.add(new SpawnListEntry(EntityBlaze.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityEvoker.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityMagmaCube.class, 40, 1, 5));
			this.spawnableCreatureList.add(new SpawnListEntry(EntityWitherSkeleton.class, 40, 1, 5));
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getGrassColorAtPos(BlockPos pos) {
			return -6711040;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getFoliageColorAtPos(BlockPos pos) {
			return -6711040;
		}

		@SideOnly(Side.CLIENT)
		@Override
		public int getSkyColorByTemp(float currentTemperature) {
			return -13210;
		}

		@Override
		public WorldGenAbstractTree getRandomTreeFeature(Random rand) {
			return super.getRandomTreeFeature(rand);
		}
	}
}
