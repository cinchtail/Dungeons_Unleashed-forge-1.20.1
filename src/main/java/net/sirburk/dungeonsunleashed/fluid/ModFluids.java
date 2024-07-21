package net.sirburk.dungeonsunleashed.fluid;

import net.sirburk.dungeonsunleashed.block.ModBlocks;
import net.sirburk.dungeonsunleashed.item.ModItems;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sirburk.dungeonsunleashed.DungeonsUnleashed;

public class ModFluids {
    public static final DeferredRegister<Fluid> FLUIDS =
            DeferredRegister.create(ForgeRegistries.FLUIDS, DungeonsUnleashed.MODID);

    public static final RegistryObject<FlowingFluid> SOURCE_VOID_POOL = FLUIDS.register("void_pool_fluid",
            () -> new ForgeFlowingFluid.Source(ModFluids.VOID_POOL_FLUID_PROPERTIES));
    public static final RegistryObject<FlowingFluid> FLOWING_VOID_POOL = FLUIDS.register("flowing_void_pool_fluid",
            () -> new ForgeFlowingFluid.Flowing(ModFluids.VOID_POOL_FLUID_PROPERTIES));


    public static final ForgeFlowingFluid.Properties VOID_POOL_FLUID_PROPERTIES = new ForgeFlowingFluid.Properties(
            ModFluidTypes.VOID_POOL_FLUID_TYPE, SOURCE_VOID_POOL, FLOWING_VOID_POOL)
            .slopeFindDistance(2).levelDecreasePerBlock(1).block(ModBlocks.VOID_POOL)
            .bucket(ModItems.VOID_POOL_BUCKET);

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}
