package fr.obelouix.obecraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoulSandBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.NBTTextComponent;
import net.minecraft.world.IBlockReader;

public class CustomSoulSandBlock extends SoulSandBlock {

    public CustomSoulSandBlock(Properties properties) {
        super(properties);
        setRegistryName("minecraft", "soul_sand");
        
    }

    @Override
    public boolean canEntitySpawn(BlockState state, IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
        return false;
    }

}
