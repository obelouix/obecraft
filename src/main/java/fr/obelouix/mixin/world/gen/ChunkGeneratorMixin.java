package fr.obelouix.mixin.world.gen;

import com.google.common.collect.Lists;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSpreadSettings;
import org.apache.commons.math3.util.FastMath;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;
import java.util.Random;

@Mixin(ChunkGenerator.class)
public class ChunkGeneratorMixin {

    @Shadow
    private final List<ChunkPos> field_235951_f_ = Lists.newArrayList();
    @Shadow
    protected BiomeProvider biomeProvider;
    @Shadow
    protected BiomeProvider field_235949_c_;
    @Shadow
    private DimensionStructuresSettings settings;
    @Shadow
    private long field_235950_e_;

    /**
     * @author
     */
    @Overwrite
    private void func_235958_g_() {
        if (this.field_235951_f_.isEmpty()) {
            StructureSpreadSettings structurespreadsettings = this.settings.func_236199_b_();
            if (structurespreadsettings != null && structurespreadsettings.func_236663_c_() != 0) {
                List<Biome> list = Lists.newArrayList();

                for (Biome biome : this.biomeProvider.getBiomes()) {
                    if (biome.getGenerationSettings().hasStructure(Structure.STRONGHOLD)) {
                        list.add(biome);
                    }
                }

                int k1 = structurespreadsettings.func_236660_a_();
                int l1 = structurespreadsettings.func_236663_c_();
                int i = structurespreadsettings.func_236662_b_();
                Random random = new Random();
                random.setSeed(this.field_235950_e_);
                double d0 = random.nextDouble() * FastMath.PI * 2.0D;
                int j = 0;
                int k = 0;

                for (int l = 0; l < l1; ++l) {
                    double d1 = (double) (4 * k1 + k1 * k * 6) + (random.nextDouble() - 0.5D) * (double) k1 * 2.5D;
                    int i1 = (int) FastMath.round(FastMath.cos(d0) * d1);
                    int j1 = (int) FastMath.round(FastMath.sin(d0) * d1);
                    BlockPos blockpos = this.biomeProvider.findBiomePosition((i1 << 4) + 8, 0, (j1 << 4) + 8, 112, list::contains, random);
                    if (blockpos != null) {
                        i1 = blockpos.getX() >> 4;
                        j1 = blockpos.getZ() >> 4;
                    }

                    this.field_235951_f_.add(new ChunkPos(i1, j1));
                    d0 += (FastMath.PI * 2D) / (double) i;
                    ++j;
                    if (j == i) {
                        ++k;
                        j = 0;
                        i = i + 2 * i / (k + 1);
                        i = FastMath.min(i, l1 - l);
                        d0 += random.nextDouble() * FastMath.PI * 2.0D;
                    }
                }

            }
        }
    }
}
