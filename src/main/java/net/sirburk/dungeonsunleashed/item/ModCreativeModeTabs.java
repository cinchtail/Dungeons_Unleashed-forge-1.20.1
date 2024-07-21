package net.sirburk.dungeonsunleashed.item;

import net.sirburk.dungeonsunleashed.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.sirburk.dungeonsunleashed.DungeonsUnleashed;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            DungeonsUnleashed.MODID);

    public static final RegistryObject<CreativeModeTab> DUNGEONSUNLEASHED_TAB = CREATIVE_MODE_TABS.register("dungeonsunleashed_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.CUT_POLISHED_GRANITE.get()))
                    .title(Component.literal("Dungeons Unleashed Tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModBlocks.CUT_POLISHED_GRANITE.get());
                        output.accept(ModBlocks.GRANITE_BRICKS.get());
                        output.accept(ModBlocks.GRANITE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.GRANITE_BRICK_SLAB.get());
                        output.accept(ModBlocks.GRANITE_BRICK_WALL.get());
                        output.accept(ModBlocks.CRACKED_GRANITE_BRICKS.get());
                        output.accept(ModBlocks.SEAWEED_ENCRUSTED_CUT_POLISHED_GRANITE.get());
                        output.accept(ModItems.VOID_POOL_BUCKET.get());

                    }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
