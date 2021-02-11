package fr.obelouix.entity.tileentity;

import fr.obelouix.registries.DimensionRegistry;
import fr.obelouix.registries.TileEntityRegistry;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class TileentityMiningTeleporter extends TileEntity {

    public TileentityMiningTeleporter() {
        super(TileEntityRegistry.MINING_TELEPORTER_TILEENTITY);
    }
}
