package fr.obelouix.registries;

import fr.obelouix.dimension.MiningDimension;
import fr.obelouix.obecraft.Obecraft;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraftforge.common.world.ForgeWorldType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.BiFunction;
import java.util.function.Supplier;

public class DimensionRegistry {

    public static final DeferredRegister<ForgeWorldType> DIMENSIONS = DeferredRegister.create(ForgeRegistries.WORLD_TYPES, Obecraft.MODID);
    public static RegistryKey<World> MINING_DIMENSION = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(Obecraft.MODID, "mining_dimension"));

    public DimensionRegistry(IEventBus modEventBus){
        modEventBus.register(this);

        MINING_DIMENSION = RegistryKey.getOrCreateKey(Registry.WORLD_KEY, new ResourceLocation(Obecraft.MODID, "mining"));

    }

    private static RegistryObject<ForgeWorldType> register(final String name, final Supplier<ForgeWorldType> sup)
    {
        return DIMENSIONS.register(name, sup);
    }
}
