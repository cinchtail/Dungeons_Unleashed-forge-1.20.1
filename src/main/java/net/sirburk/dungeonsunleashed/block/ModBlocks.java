package net.sirburk.dungeonsunleashed.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sirburk.dungeonsunleashed.DungeonsUnleashed;
import net.sirburk.dungeonsunleashed.fluid.ModFluids;
import net.sirburk.dungeonsunleashed.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, DungeonsUnleashed.MODID);
    public static final RegistryObject<Block> CUT_POLISHED_GRANITE = registerBlock("cut_polished_granite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_GRANITE)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GRANITE_BRICKS = registerBlock("granite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRANITE)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> CRACKED_GRANITE_BRICKS = registerBlock("cracked_granite_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.GRANITE)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> SEAWEED_ENCRUSTED_CUT_POLISHED_GRANITE = registerBlock("seaweed_encrusted_cut_polished_granite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.POLISHED_GRANITE)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> GRANITE_BRICK_STAIRS = registerBlock("granite_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.GRANITE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(ModBlocks.GRANITE_BRICKS.get())
                            .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> GRANITE_BRICK_SLAB = registerBlock("granite_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<Block> GRANITE_BRICK_WALL = registerBlock("granite_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.GRANITE)
                    .requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final RegistryObject<LiquidBlock> VOID_POOL = BLOCKS.register("void_pool",
            () -> new LiquidBlock(ModFluids.SOURCE_VOID_POOL, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK)
                    .replaceable().noCollission().strength(100.0F).pushReaction(PushReaction.DESTROY).noLootTable().liquid().sound(SoundType.EMPTY)));
















    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
