package fr.obelouix.util.datagen;

import fr.obelouix.obecraft.Obecraft;
import fr.obelouix.registries.BlockRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Items extends ItemModelProvider {

    public Items(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Obecraft.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        /*singleTexture(Registration.MAGICBLOCK_ITEM.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),
                "layer0", new ResourceLocation(Obecraft.MODID, "item/magicblock_item"));
        singleTexture(Registration.FIRSTITEM.get().getRegistryName().getPath(), new ResourceLocation("item/handheld"),
                "layer0", new ResourceLocation(Obecraft.MODID, "item/firstitem"));*/
        withExistingParent(BlockRegistry.BIRCH_WORKBENCH.get().getRegistryName().getPath(), new ResourceLocation(Obecraft.MODID, "block/birch_workbench"));
    }
}