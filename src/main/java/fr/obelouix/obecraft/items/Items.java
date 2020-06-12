package fr.obelouix.obecraft.items;

import fr.obelouix.obecraft.blocks.CustomSoulSandBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class Items {

    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "obecraft");
    public static final DeferredRegister<Item> DEFAULT_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, "minecraft");

    //Register the tutorial dust with "tutorial_dust" as registry name and default properties
    public static final RegistryObject<Item> TUTORIAL_DUST = ITEMS.register("tutorial_dust", () -> new Item(new Item.Properties()));


    //Vanilla override
   // public static final RegistryObject<BlockItem> SOUL_SAND = DEFAULT_ITEMS.register("soul_sand", () -> new BlockItem(new CustomSoulSandBlock().getBlock(), new Item.Properties().group(ItemGroup.BUILDING_BLOCKS)));
   @SubscribeEvent
    public void OverrideBlocks(RegistryEvent.Register<Block> event)
    {
        Block SOUL_SAND = new CustomSoulSandBlock(Block.Properties.from(Blocks.SOUL_SAND)).setRegistryName("minecraft","soul_sand");
        event.getRegistry().register(SOUL_SAND);
        ForgeRegistries.ITEMS.register(new BlockItem(SOUL_SAND, new Item.Properties().group(ItemGroup.BUILDING_BLOCKS))
        {
          public String getCreatorModID(net.minecraft.item.ItemStack itemStack)
          {
                return "obecraft";
          }
        }.setRegistryName(SOUL_SAND.getRegistryName()));
    }
}
