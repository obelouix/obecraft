package fr.obelouix.obecraft.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import fr.obelouix.obecraft.Obecraft;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.io.File;

import static fr.obelouix.obecraft.Obecraft.LOGGER;

public class ServerConfig {

    static Config config = new Config();

    public static boolean enableEconomy =  config.enableEconomy;
    public static String[] removeBlocks = config.removeBlocks;

    public static void init() throws IOException {

        Path path = new File("./config/obecraft-server.json").toPath();
        File f = new File(String.valueOf(path));

        if(!f.exists())
        {
            LOGGER.info("Creating obecraft-server.json");
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter fileWriter = new FileWriter(String.valueOf(path));
            gson.toJson(new Config(), fileWriter);
            fileWriter.close();
        }
    }
}

class Config {

    protected boolean enableEconomy = true;
    protected long moneyLimit = Long.MAX_VALUE;
    protected String[] removeBlocks = {"tnt", "",""};
    public Config()
    {

    }

}
