package fr.obelouix.obecraft.TileEntity;

import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.tileentity.AbstractFurnaceTileEntity;
import net.minecraft.tileentity.FurnaceTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public abstract class IronFurnaceTileEntity extends AbstractFurnaceTileEntity {
    public IronFurnaceTileEntity(TileEntityType<FurnaceTileEntity> tileEntityTypeIn) {
        super(tileEntityTypeIn, IRecipeType.SMELTING);
    }
}
