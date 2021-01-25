package fr.obelouix.registries;

import fr.obelouix.blocks.CobbleChestBlock;
import fr.obelouix.blocks.CustomCraftingTableBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ObjectHolder;

public class BlockRegistry {

    //public  RegistryObject<Block> test;
    public static RegistryObject<Block> BIRCH_WORKBENCH;
    public static RegistryObject<Block> SPRUCE_WORKBENCH;
    public static RegistryObject<Block> cobbleChest;
    private final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "obecraft");

    public BlockRegistry(IEventBus iEventBus) {
//        test = BLOCKS.register("test", ()-> new SoulSandBlock(AbstractBlock.Properties.create(Material.ANVIL)));
        BIRCH_WORKBENCH = BLOCKS.register("birch_workbench", () -> new CustomCraftingTableBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD)));
        SPRUCE_WORKBENCH = BLOCKS.register("spruce_workbench", () -> new CustomCraftingTableBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD)));
        if (ModList.get().isLoaded("ironchest")) {
            cobbleChest = BLOCKS.register("cobble_chest", () -> new CobbleChestBlock(AbstractBlock.Properties.create(Material.ROCK)));
        }
        BLOCKS.register(iEventBus);

    }

}
