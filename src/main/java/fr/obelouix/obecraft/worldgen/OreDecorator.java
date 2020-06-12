package fr.obelouix.obecraft.worldgen;

import fr.obelouix.obecraft.blocks.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class OreDecorator {

    public static void Decorate() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(new OreFeatureConfig(
                    OreFeatureConfig.FillerBlockType.NATURAL_STONE, Blocks.URANIUM_ORE.get().getDefaultState(), 8))
                    .withPlacement(Placement.COUNT_RANGE.configure(new CountRangeConfig(4, 0, 0, 50))));
        }
    }

}
