package net.mcreator.obsidian.procedure;

import net.minecraft.world.World;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.BlockPos;
import net.minecraft.server.MinecraftServer;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.command.ICommandSender;

import net.mcreator.obsidian.ElementsWaterandLava;

@ElementsWaterandLava.ModElement.Tag
public class ProcedureElectrificationPotionExpires extends ElementsWaterandLava.ModElement {
	public ProcedureElectrificationPotionExpires(ElementsWaterandLava instance) {
		super(instance, 105);
	}

	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			System.err.println("Failed to load dependency x for procedure ElectrificationPotionExpires!");
			return;
		}
		if (dependencies.get("y") == null) {
			System.err.println("Failed to load dependency y for procedure ElectrificationPotionExpires!");
			return;
		}
		if (dependencies.get("z") == null) {
			System.err.println("Failed to load dependency z for procedure ElectrificationPotionExpires!");
			return;
		}
		if (dependencies.get("world") == null) {
			System.err.println("Failed to load dependency world for procedure ElectrificationPotionExpires!");
			return;
		}
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		world.addWeatherEffect(new EntityLightningBolt(world, (int) x, (int) y, (int) z, false));
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
			}, "weather clear");
		}
	}
}
