package fr.obelouix.entity.tile;

import com.progwml6.ironchest.common.block.IronChestsTypes;
import com.progwml6.ironchest.common.block.tileentity.GenericIronChestTileEntity;
import com.progwml6.ironchest.common.block.tileentity.IronChestsTileEntityTypes;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntityType;

import java.util.function.Supplier;

import static fr.obelouix.registries.BlockRegistry.cobbleChest;

public class CobbleChestTileEntity extends GenericIronChestTileEntity {

    protected CobbleChestTileEntity(TileEntityType<?> typeIn, IronChestsTypes chestTypeIn, Supplier<Block> blockToUseIn) {
        super(typeIn, chestTypeIn, blockToUseIn);
    }
}
