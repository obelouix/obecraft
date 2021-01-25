package fr.obelouix.blocks;

import com.progwml6.ironchest.common.block.GenericIronChestBlock;
import com.progwml6.ironchest.common.block.IronChestsTypes;
import com.progwml6.ironchest.common.block.tileentity.DiamondChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.GenericIronChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import fr.obelouix.entity.tile.CobbleChestTileEntity;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.world.IBlockReader;

import java.util.function.Supplier;

public class CobbleChestBlock extends GenericIronChestBlock {
    public CobbleChestBlock(IronChestsTypes typeIn, Supplier<TileEntityType<? extends GenericIronChestTileEntity>> tileEntityTypeSupplierIn, Properties properties) {
        super(IronChestsTypes.DIAMOND, IronChestsTileEntityTypes.DIAMOND_CHEST::get, properties);
    }

    public CobbleChestBlock(Properties properties) {
        super(IronChestsTypes.DIAMOND, IronChestsTileEntityTypes.DIAMOND_CHEST::get, properties);
    }

   /* public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return new CobbleChestTileEntity();
    }*/
}
