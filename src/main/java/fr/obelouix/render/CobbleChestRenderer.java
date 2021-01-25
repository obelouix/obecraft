package fr.obelouix.render;

import com.progwml6.ironchest.client.tileentity.IronChestItemStackRenderer;
import com.progwml6.ironchest.common.block.tileentity.IronChestTileEntity;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.concurrent.Callable;

public class CobbleChestRenderer {

    @OnlyIn(Dist.CLIENT)
    private static Callable<ItemStackTileEntityRenderer> cobbleChestRenderer() {
        return () -> new IronChestItemStackRenderer(IronChestTileEntity::new);
    }
}
