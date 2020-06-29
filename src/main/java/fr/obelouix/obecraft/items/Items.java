package fr.obelouix.obecraft.items;

import fr.obelouix.obecraft.blocks.Blocks;
import fr.obelouix.obecraft.blocks.CustomSoulSandBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "obecraft");
    public static final DeferredRegister<Item> DEFAULT_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    //Register the tutorial dust with "tutorial_dust" as registry name and default properties
    public static final RegistryObject<Item> uranium = ITEMS.register("uranium", () -> new UraniumItem(new Item.Properties().group(ItemGroup.MATERIALS)));

    //Tools
    public static final  RegistryObject<Item> OBSIDIAN_PICKAGE = ITEMS.register("obsidian_pickaxe", () -> new ItemPickaxe(ToolTiers.OBSIDIAN,1.5F, -3.0F, (new Item.Properties())));

    //BlockItems
    public static final RegistryObject<BlockItem> URANIUM_ORE = ITEMS.register("uranium_ore", () -> new BlockItem(Blocks.URANIUM_ORE.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));

    //Vanilla override
   public static final RegistryObject<BlockItem> SOUL_SAND = DEFAULT_ITEMS.register("soul_sand", () -> new BlockItem(Blocks.SOUL_SAND.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));

}
