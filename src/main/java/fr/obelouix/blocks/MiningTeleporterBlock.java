package fr.obelouix.blocks;

import fr.obelouix.dimension.MiningDimension;
import fr.obelouix.entity.tileentity.TileentityMiningTeleporter;
import fr.obelouix.obecraft.Obecraft;
import fr.obelouix.registries.DimensionRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Dimension;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class MiningTeleporterBlock extends Block implements ITileEntityProvider {

    public MiningTeleporterBlock() {
        super(Properties.create(Material.PORTAL));

    }
    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if (player instanceof ServerPlayerEntity) {
            transferPlayer((ServerPlayerEntity) player, pos);
        }
        return ActionResultType.SUCCESS;
    }

    public boolean transferPlayer(ServerPlayerEntity player, BlockPos pos) {
        if (player.getRidingEntity() != null || player.isBeingRidden()) {
            return false;
        }

        if (player.world.getDimensionKey().equals(DimensionRegistry.MINING_DIMENSION)) {
            ServerWorld teleportWorld = player.server.getWorld(player.world.getDimensionKey());
            if (teleportWorld == null) {
                return false;
            }
            player.changeDimension(teleportWorld, new MiningDimension(pos));
        } else if (player.world.getDimensionKey().equals(World.OVERWORLD.getRegistryName())) {
            ServerWorld teleportWorld = player.server.getWorld(DimensionRegistry.MINING_DIMENSION);
            if (teleportWorld == null) {
                return false;
            }
            player.changeDimension(teleportWorld, new MiningDimension(pos));
        } else {
            player.sendStatusMessage(new TranslationTextComponent("message.wrong_dimension"), true);
        }

        return true;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(IBlockReader world) {
        return new TileentityMiningTeleporter();
    }

}
