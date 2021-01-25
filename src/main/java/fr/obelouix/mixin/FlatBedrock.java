package fr.obelouix.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.NoiseSettings;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyConstant;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;

@Mixin(NoiseChunkGenerator.class)
public abstract class FlatBedrock {

    @Shadow @Final protected Supplier<DimensionSettings> field_236080_h_;

    @Inject(method = "makeBedrock", at=@At("HEAD"),cancellable = true)
    private void makeBedrock(IChunk chunk, Random r, CallbackInfo callbackInfo){
        BlockPos.Mutable mutable = new BlockPos.Mutable();
        int ChunkX = chunk.getPos().getXStart();
        int ChunkZ = chunk.getPos().getZStart();
        DimensionSettings dimensionSettings = this.field_236080_h_.get();
        //GenerationSettings settings = ((NoiseChunkGenerator) (Object) this).getSettings();
        int minY =  dimensionSettings.func_236118_f_();
        int maxY =  dimensionSettings.func_236117_e_();
        Iterator it = BlockPos.getAllInBoxMutable(ChunkX, 0 , ChunkZ, ChunkX + 16, 0, ChunkZ + 16).iterator();
        while(true)
        {
            BlockPos blockPos;
            do{
                if(!it.hasNext())
                {
                    callbackInfo.cancel();
                    return;
                }
                blockPos = (BlockPos)it.next();
                if(maxY == 255)
                {
                    mutable.setPos(blockPos.getX(), maxY, blockPos.getZ());
                    chunk.setBlockState(mutable, Blocks.BEDROCK.getDefaultState(), false);
                }
                if(maxY == 127)
                {
                    mutable.setPos(blockPos.getX(), maxY, blockPos.getZ());
                    chunk.setBlockState(mutable,Blocks.SOUL_SAND.getDefaultState(), false);
                }
            } while (maxY >= 255);
            {
                mutable.setPos(blockPos.getX(), minY, blockPos.getZ());
                chunk.setBlockState(mutable, Blocks.BEDROCK.getDefaultState(), false);
            }
        }
    }
}
