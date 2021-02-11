package fr.obelouix.registries;

import fr.obelouix.blocks.MiningTeleporterBlock;
import fr.obelouix.entity.tileentity.TileentityMiningTeleporter;
import fr.obelouix.obecraft.Obecraft;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityRegistry {

    public static TileEntityType<TileentityMiningTeleporter> MINING_TELEPORTER_TILEENTITY;
    private DeferredRegister<TileEntityType<?>> tileEntityDeferredRegister = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, "obecraft");

    public TileEntityRegistry(IEventBus eventBus){
        eventBus.register(this);
        MINING_TELEPORTER_TILEENTITY = TileEntityType.Builder.create(TileentityMiningTeleporter::new, new MiningTeleporterBlock()).build(null);
        MINING_TELEPORTER_TILEENTITY.setRegistryName(Obecraft.MODID,"mining_teleporter");
        eventBus.register(MINING_TELEPORTER_TILEENTITY);
    }

}
