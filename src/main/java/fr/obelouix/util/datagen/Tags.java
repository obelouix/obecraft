package fr.obelouix.util.datagen;


import net.minecraft.block.Blocks;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.data.ExistingFileHelper;

public  class Tags extends BlockTagsProvider
{
    public Tags(DataGenerator gen, ExistingFileHelper existingFileHelper)
    {
        super(gen, "obecraft", existingFileHelper);
    }

    @Override
    protected void registerTags()
    {
        getOrCreateBuilder(BlockTags.makeWrapperTag(new ResourceLocation("obecraft", "test").toString()))
                .addItemEntry(Blocks.DIAMOND_BLOCK)
                .addTag(BlockTags.STONE_BRICKS)
                .addTag(net.minecraftforge.common.Tags.Blocks.COBBLESTONE)
                .addOptional(new ResourceLocation("chisel", "marble/raw"))
                .addOptionalTag(new ResourceLocation("forge", "storage_blocks/ruby"));

        // Hopefully sorting issues
        getOrCreateBuilder(BlockTags.makeWrapperTag(new ResourceLocation("obecraft", "thing/one").toString()))
                .addItemEntry(Blocks.COBBLESTONE);
        getOrCreateBuilder(BlockTags.makeWrapperTag(new ResourceLocation("obecraft", "thing/two").toString()))
                .addItemEntry(Blocks.DIORITE);
        getOrCreateBuilder(BlockTags.makeWrapperTag(new ResourceLocation("obecraft", "thing/three").toString()))
                .addItemEntry(Blocks.ANDESITE);

        getOrCreateBuilder(BlockTags.makeWrapperTag(new ResourceLocation("obecraft", "things").toString()))
                .addItemEntry(Blocks.COBBLESTONE)
                .addItemEntry(Blocks.DIORITE)
                .addItemEntry(Blocks.ANDESITE);
    }
}
