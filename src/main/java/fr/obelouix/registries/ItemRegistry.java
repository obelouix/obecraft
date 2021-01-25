package fr.obelouix.registries;

import com.progwml6.ironchest.IronChests;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemRegistry {
    public  final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "obecraft");
    //public RegistryObject<Items> test;
    public static RegistryObject<Item> BIRCH_WORKBENCH;
    public static RegistryObject<Item> SPRUCE_WORKBENCH;
    public RegistryObject<Item> cobbleChest;

    public ItemRegistry(IEventBus iEventBus){
        //test = ITEMS.register("test", ()-> new BlockItem(Blocks.SOUL_SAND.getBlock(),  (new Items.Properties()).group(ItemGroup.BUILDING_BLOCKS)));
        BIRCH_WORKBENCH = ITEMS.register("birch_workbench", ()-> new BlockItem(BlockRegistry.BIRCH_WORKBENCH.get(), (new Item.Properties().group(ItemGroup.DECORATIONS))));
        SPRUCE_WORKBENCH = ITEMS.register("spruce_workbench", ()-> new BlockItem(BlockRegistry.SPRUCE_WORKBENCH.get(), (new Item.Properties().group(ItemGroup.DECORATIONS))));
        if(ModList.get().isLoaded("ironchest")){
            cobbleChest = ITEMS.register("cobble_chest", ()-> new BlockItem(BlockRegistry.cobbleChest.get(), (new Item.Properties()).group(IronChests.IRONCHESTS_ITEM_GROUP)));
        }
        ITEMS.register(iEventBus);
    }
}
