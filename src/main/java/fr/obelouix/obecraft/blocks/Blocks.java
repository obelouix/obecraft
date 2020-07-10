package fr.obelouix.obecraft.blocks;

import fr.obelouix.obecraft.config.ServerConfig;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.inventory.CraftResultInventory;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.registry.DefaultedRegistry;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;

import java.util.*;
import java.util.function.ToIntFunction;


public class Blocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS , "obecraft");
    public static final DeferredRegister<Block> DEFAULT_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "minecraft");
    public static final DeferredRegister<Block> REMOVED_BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "");

    //ores
    public static final RegistryObject<Block> URANIUM_ORE = BLOCKS.register("uranium_ore", ()-> new OreBlock(Block.Properties.create(Material.ROCK).hardnessAndResistance(3.5f, 3.0f)));

    public static final RegistryObject<Block> IRON_FURNACE = BLOCKS.register("iron_furnace", ()-> new IronFurnaceBlock(AbstractBlock.Properties.create(Material.IRON)));

    //lamps
    public  static Map lampBlocks = new HashMap<String, RegistryObject<Block>>();

    //public static  final  RegistryObject<Block> BLUE_LAMP_A = BLOCKS.register("blue_lamp_a", ()-> new AlphabetLampBlock(AbstractBlock.Properties.create(Material.REDSTONE_LIGHT, MaterialColor.BLUE).func_235838_a_(lampLight())));
    //public static  final  RegistryObject<Block> BLUE_LAMP_B = BLOCKS.register("blue_lamp_b", ()-> new AlphabetLampBlock(AbstractBlock.Properties.create(Material.REDSTONE_LIGHT, MaterialColor.BLUE).func_235838_a_(lampLight())));
    //public static  final  RegistryObject<Block> BLUE_LAMP_C = BLOCKS.register("blue_lamp_c", ()-> new AlphabetLampBlock(AbstractBlock.Properties.create(Material.REDSTONE_LIGHT, MaterialColor.BLUE).func_235838_a_(lampLight())));

    //vanilla blocks
    public static final RegistryObject<Block> SOUL_SAND = DEFAULT_BLOCKS.register("soul_sand", ()-> new CustomSoulSandBlock(Block.Properties.create(Material.SAND).tickRandomly().hardnessAndResistance(0.5F).speedFactor(0.4F).sound(SoundType.SAND)));

    public static void UnregisterBlocks()
    {
        for(String str : ServerConfig.removeBlocks)
        {

        }
    }


    private static ToIntFunction<BlockState> lampLight() {
        return (p_235421_1_) -> {
            return p_235421_1_.get(BlockStateProperties.LIT) ? 15 : 0;
        };
    }

}
