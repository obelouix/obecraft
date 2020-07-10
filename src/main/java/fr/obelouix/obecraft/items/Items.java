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

import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class Items {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "obecraft");
    public static final DeferredRegister<Item> DEFAULT_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "minecraft");

    public static final RegistryObject<Item> URANIUM = ITEMS.register("uranium", () -> new UraniumItem(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> IRON_STICK = ITEMS.register("iron_stick", () -> new IronStickItem(new Item.Properties().group(ItemGroup.MATERIALS)));
    public static final RegistryObject<Item> OBSIDIAN_INGOT = ITEMS.register("obsidian_ingot", () -> new ObsidianIngotItem(new Item.Properties().group(ItemGroup.MATERIALS)));

    //Tools
    public static final  RegistryObject<Item> OBSIDIAN_PICKAGE = ITEMS.register("obsidian_pickaxe", () -> new ItemPickaxe(ToolTiers.OBSIDIAN,1.5F, -3.0F, (new Item.Properties())));

    //BlockItems
    public static final RegistryObject<BlockItem> URANIUM_ORE = ITEMS.register("uranium_ore", () -> new BlockItem(Blocks.URANIUM_ORE.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
    public static final RegistryObject<BlockItem> IRON_FURNACE = ITEMS.register("iron_furnace", () -> new BlockItem(Blocks.IRON_FURNACE.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));


    public  static Map lampBlockItems = new HashMap<String, RegistryObject<BlockItem>>();
    private char c;

    //lamps

    //public static final  RegistryObject<BlockItem> BLUE_LAMP_A = ITEMS.register("blue_lamp_a", () -> new BlockItem((Block) Blocks.lampBlocks.get("blue_lamp_a"), (new Item.Properties())));
   /* public static final RegistryObject<BlockItem> BLUE_LAMP_A = ITEMS.register("blue_lamp_a", () -> new BlockItem(Blocks.lampBlocks.get(""), (new Item.Properties())));
    public static final RegistryObject<BlockItem> BLUE_LAMP_B = ITEMS.register("blue_lamp_b", () -> new BlockItem(Blocks.BLUE_LAMP_B.get(), (new Item.Properties())));
    public static final RegistryObject<BlockItem> BLUE_LAMP_C = ITEMS.register("blue_lamp_c", () -> new BlockItem(Blocks.BLUE_LAMP_C.get(), (new Item.Properties())));
*/

    //Vanilla override
   public static final RegistryObject<BlockItem> SOUL_SAND = DEFAULT_ITEMS.register("soul_sand", () -> new BlockItem(Blocks.SOUL_SAND.get(), (new Item.Properties()).group(ItemGroup.BUILDING_BLOCKS)));

}
