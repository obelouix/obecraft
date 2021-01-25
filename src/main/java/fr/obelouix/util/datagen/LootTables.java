package fr.obelouix.util.datagen;

import fr.obelouix.registries.BlockRegistry;
import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(BlockRegistry.BIRCH_WORKBENCH.get(), createStandardTable("uranium_ore",BlockRegistry.BIRCH_WORKBENCH.get()));
    }
}
