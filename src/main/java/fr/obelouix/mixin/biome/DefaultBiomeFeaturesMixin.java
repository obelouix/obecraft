package fr.obelouix.mixin.biome;

import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Features;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {

    @Overwrite
    public static void withLavaAndWaterLakes(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_WATER);
        builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);
    }

    @Overwrite
    public static void withLavaLakes(BiomeGenerationSettings.Builder builder) {
        builder.withFeature(GenerationStage.Decoration.LAKES, Features.LAKE_LAVA);
    }


}
