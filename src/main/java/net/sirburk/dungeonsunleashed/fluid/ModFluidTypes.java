package net.sirburk.dungeonsunleashed.fluid;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sirburk.dungeonsunleashed.DungeonsUnleashed;

public class ModFluidTypes {
    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("dungeonsunleashed:block/void_pool_still");
    public static final ResourceLocation WATER_FLOWING_RL = new ResourceLocation("dungeonsunleashed:block/void_pool_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("dungeonsunleashed:block/void_pool_overlay");

    public static final DeferredRegister<FluidType> FLUID_TYPES =
            DeferredRegister.create(ForgeRegistries.Keys.FLUID_TYPES, DungeonsUnleashed.MODID);

    public static final RegistryObject<FluidType> VOID_POOL_FLUID_TYPE = registerFluidType("void_pool_fluid",
            new BaseFluidType(WATER_STILL_RL, WATER_FLOWING_RL, WATER_OVERLAY_RL,
                    FluidType.Properties.create().lightLevel(2).viscosity(5).density(15)));


    private static RegistryObject<FluidType> registerFluidType(String name, FluidType fluidType) {
        return FLUID_TYPES.register(name, () -> fluidType);
    }

    public static void register(IEventBus eventBus) {
        FLUID_TYPES.register(eventBus);
    }
}
