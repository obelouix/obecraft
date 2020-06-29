package fr.obelouix.obecraft.mixins;

import fr.obelouix.obecraft.Config;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraft.world.gen.NoiseChunkGenerator;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.Random;

@Mixin(NoiseChunkGenerator.class)
public abstract class BedrockWorldGen extends ChunkGenerator {


    public BedrockWorldGen(BiomeProvider p_i231888_1_, DimensionStructuresSettings p_i231888_2_) {
        super(p_i231888_1_, p_i231888_2_);
    }

    @Inject(method = "makeBedrock", at = @At("HEAD"), cancellable = true)
    private void makeBedrock(IChunk chunk, Random r, CallbackInfo callbackInfo)
    {
            BlockPos.Mutable mutable = new BlockPos.Mutable();
            int ChunkX = chunk.getPos().getXStart();
            int ChunkZ = chunk.getPos().getZStart();

            //GenerationSettings settings = ((NoiseChunkGenerator) (Object) this).getSettings();

            int minY =  0;//settings.getBedrockFloorHeight();
            int maxY =  256;//settings.getBedrockRoofHeight();

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
                    if(maxY > 0 && maxY < 126)
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