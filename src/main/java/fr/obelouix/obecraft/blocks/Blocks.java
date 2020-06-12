package fr.obelouix.obecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.OreBlock;
import net.minecraft.block.SoulSandBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.spongepowered.asm.mixin.Mixin;


public class Blocks {

    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, "obecraft");
    public static final DeferredRegister<Block> DEFAULT_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, "minecraft");

    //ores
    public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", ()-> new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5f, 3.0f)));

    //vanilla blocks
    public static final RegistryObject<Block> SOUL_SAND = DEFAULT_BLOCKS.register("soul_sand", ()-> new CustomSoulSandBlock(Block.Properties.create(Material.SAND).tickRandomly().hardnessAndResistance(0.5F).speedFactor(0.4F).sound(SoundType.SAND)));

}
