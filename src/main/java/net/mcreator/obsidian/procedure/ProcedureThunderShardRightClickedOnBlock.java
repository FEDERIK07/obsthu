package net.mcreator.obsidian.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.init.Blocks;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.properties.IProperty;

import net.mcreator.obsidian.block.BlockSuperchargedObsidian;
import net.mcreator.obsidian.ElementsWaterandLava;

import java.util.Map;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureThunderShardRightClickedOnBlock extends ElementsWaterandLava.ModElement {
	public ProcedureThunderShardRightClickedOnBlock(ElementsWaterandLava instance) {
		super(instance, 102);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ThunderShardRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ThunderShardRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ThunderShardRightClickedOnBlock!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ThunderShardRightClickedOnBlock!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (((world.getBlockState(new BlockPos((int) x, (int) y, (int) z))).getBlock() == Blocks.OBSIDIAN.getDefaultState().getBlock())) {
			world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
			{
				BlockPos _bp = new BlockPos((int) x, (int) y, (int) z);
				IBlockState _bs = BlockSuperchargedObsidian.block.getDefaultState();
				IBlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<IProperty<?>, Comparable<?>> entry : _bso.getProperties().entrySet()) {
					IProperty _property = entry.getKey();
					if (_bs.getPropertyKeys().contains(_property))
						_bs = _bs.withProperty(_property, (Comparable) entry.getValue());
				}
				world.setBlockState(_bp, _bs, 3);
			}
		}
	}
}
