package fr.obelouix.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.source.BiomeSource;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.gen.chunk.ChunkGenerator;
import net.minecraft.world.gen.chunk.StructuresConfig;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;
import java.util.Random;

@Mixin(SurfaceChunkGenerator.class)
public abstract class FlatBedrock extends ChunkGenerator {
    public FlatBedrock(BiomeSource biomeSource, StructuresConfig structuresConfig) {
        super(biomeSource, structuresConfig);
    }

    @Inject(method = "buildBedrock", at = @At("HEAD"), cancellable = true)
    private void buildBedrock(Chunk chunk, Random rand, CallbackInfo info) {
            BlockPos.Mutable mutableBlockPos = new BlockPos.Mutable();
            int chunkXStart = chunk.getPos().getStartX();
            int chunkZStart = chunk.getPos().getStartZ();
            StructuresConfig genConfig = ((SurfaceChunkGenerator) (Object) this).getConfig();
            int minY = 0; // Overworld: 0. Nether: 0
            int maxY = 127; // Overworld: 0. Nether: 127
            Iterator var9 = BlockPos.iterate(chunkXStart, 0, chunkZStart, chunkXStart + 16, 0, chunkZStart + 16).iterator();
            while (true) {
                BlockPos blockPos;
                do {
                    if (!var9.hasNext()) {
                        info.cancel(); // Prevent vanilla code from running.
                        return;
                    }

                    blockPos = (BlockPos) var9.next();
                    if (maxY > 0) {
                        // CavesChunkGeneratorSettings overrides maxY to provide a bedrock roof.
                        // This code will only be run by worlds with a custom maxY.

                        mutableBlockPos.set(blockPos.getX(), maxY, blockPos.getZ());
                        chunk.setBlockState(mutableBlockPos, Blocks.BEDROCK.getDefaultState(), false);
                    }
                } while (minY >= 256);

                // Generate world floor.
                mutableBlockPos.set(blockPos.getX(), minY, blockPos.getZ());
                chunk.setBlockState(mutableBlockPos, Blocks.BEDROCK.getDefaultState(), false);
            }
    }

}
