package net.mcreator.obsidian.procedure;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.command.ICommandSender;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureElectroOnPotionActiveTick extends ElementsWaterandLava.ModElement {
	public ProcedureElectroOnPotionActiveTick(ElementsWaterandLava instance) {
		super(instance, 107);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ElectroOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ElectroOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ElectroOnPotionActiveTick!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ElectroOnPotionActiveTick!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote && world.getMinecraftServer() != null) {
			world.getMinecraftServer().getCommandManager().executeCommand(new ICommandSender() {
				@Override
				public String getName() {
					return "";
				}

				@Override
				public boolean canUseCommand(int permission, String command) {
					return true;
				}

				@Override
				public World getEntityWorld() {
					return world;
				}

				@Override
				public MinecraftServer getServer() {
					return world.getMinecraftServer();
				}

				@Override
				public boolean sendCommandFeedback() {
					return false;
				}

				@Override
				public BlockPos getPosition() {
					return new BlockPos((int) x, (int) y, (int) z);
				}

				@Override
				public Vec3d getPositionVector() {
					return new Vec3d(x, y, z);
				}
			}, "weather thunder");
		}
		if ((Biome.REGISTRY.getNameForObject(world.getBiome(new BlockPos((int) x, (int) y, (int) z)))
				.equals(new ResourceLocation("obsidian:thunderzone")))) {
			for (int index0 = 0; index0 < (int) (100); index0++) {
				world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
			}
		}
	}
}
