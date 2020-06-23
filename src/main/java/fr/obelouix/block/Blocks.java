package fr.obelouix.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.loader.util.sat4j.specs.IGroupSolver;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class Blocks {

    public static final Block URANIUM_ORE = new OreBlock(FabricBlockSettings.copyOf(net.minecraft.block.Blocks.DIAMOND_ORE).strength(3.5f, 3.5f));

    public static void registerBlocks()
    {
        Registry.register(Registry.BLOCK, new Identifier("obecraft","uranium_ore"), URANIUM_ORE);
    }

    public  static  void  registerBlockItems()
    {
        Registry.register(Registry.ITEM, new Identifier("obecraft", "uranium_ore"), new BlockItem(URANIUM_ORE, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS).rarity(Rarity.RARE)));
    }
}
