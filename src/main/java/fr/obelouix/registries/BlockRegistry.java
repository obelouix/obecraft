package fr.obelouix.registries;

import fr.obelouix.blocks.CobbleChestBlock;
import fr.obelouix.blocks.CustomCraftingTableBlock;
import fr.obelouix.blocks.MiningTeleporterBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockRegistry {

    //public  RegistryObject<Block> test;
    private final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, "obecraft");
    public static RegistryObject<Block> BIRCH_WORKBENCH;
    public static RegistryObject<Block> SPRUCE_WORKBENCH;
    public static RegistryObject<Block> cobbleChest;
    public static  RegistryObject<Block> MINING_TELEPORTER;


    public BlockRegistry(IEventBus iEventBus) {
//        test = BLOCKS.register("test", ()-> new SoulSandBlock(AbstractBlock.Properties.create(Material.ANVIL)));
        BIRCH_WORKBENCH = BLOCKS.register("birch_workbench", () -> new CustomCraftingTableBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD)));
        SPRUCE_WORKBENCH = BLOCKS.register("spruce_workbench", () -> new CustomCraftingTableBlock(AbstractBlock.Properties.create(Material.WOOD).hardnessAndResistance(2.5F).sound(SoundType.WOOD)));
        if (ModList.get().isLoaded("ironchest")) {
            cobbleChest = BLOCKS.register("cobble_chest", () -> new CobbleChestBlock(AbstractBlock.Properties.create(Material.ROCK)));
        }
        MINING_TELEPORTER = BLOCKS.register("mining_teleporter", MiningTeleporterBlock::new);
        BLOCKS.register(iEventBus);

    }

}
