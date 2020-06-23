package fr.obelouix;

import fr.obelouix.block.Blocks;
import fr.obelouix.item.Items;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Obecraft implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "obecraft";
    public static final String MOD_NAME = "Obecraft";

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
        //TODO: Initializer
        Blocks.registerBlocks();
        Blocks.registerBlockItems();
        Items.registerItems();
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}