package fr.obelouix.obecraft.util;

import fr.obelouix.obecraft.blocks.Blocks;
import net.minecraft.data.DataGenerator;

public class LootTables extends BaseLootTableProvider {

    public LootTables(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables() {
        lootTables.put(Blocks.URANIUM_ORE.get().getBlock(), createStandardTable("uranium_ore", Blocks.URANIUM_ORE.get().getBlock()));
    }
}
