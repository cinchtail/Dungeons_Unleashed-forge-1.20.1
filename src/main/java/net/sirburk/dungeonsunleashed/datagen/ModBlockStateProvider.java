package net.sirburk.dungeonsunleashed.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sirburk.dungeonsunleashed.DungeonsUnleashed;
import net.sirburk.dungeonsunleashed.block.ModBlocks;

import java.util.Objects;
import java.util.function.Supplier;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, DungeonsUnleashed.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.CUT_POLISHED_GRANITE);
        blockWithItem(ModBlocks.GRANITE_BRICKS);
        blockWithItem(ModBlocks.CRACKED_GRANITE_BRICKS);
        blockWithItem(ModBlocks.SEAWEED_ENCRUSTED_CUT_POLISHED_GRANITE);



        slabBlock((SlabBlock) ModBlocks.GRANITE_BRICK_SLAB.get(), blockLoc(ModBlocks.GRANITE_BRICKS),
        blockLoc(ModBlocks.GRANITE_BRICKS));
        //slabBlock((SlabBlock) AZALEA_SLAB.get(), blockLoc(AZALEA_PLANKS),
        //blockLoc(AZALEA_PLANKS));

        stairsBlock((StairBlock) ModBlocks.GRANITE_BRICK_STAIRS.get(), blockLoc(ModBlocks.GRANITE_BRICKS));
        //stairsBlock((StairBlock) CRACKED_STONE_BRICK_STAIRS.get(), blockTexture(Blocks.CRACKED_STONE_BRICKS));

        //vanillaWallBlock(SMOOTH_STONE_WALL, blockVanillaBlockLoc(Blocks.SMOOTH_STONE));
        modWallBlock(ModBlocks.GRANITE_BRICK_WALL, blockLoc(ModBlocks.GRANITE_BRICKS));

    }
    private void trapDoorBlockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("dungeonsunleashed:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath() + appendix));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    public void vanillaWallBlock(RegistryObject<Block> block, ResourceLocation texture) {
        super.wallBlock((WallBlock) block.get(), texture);
        models().wallInventory(getName(block) + "_inventory", texture);
    }
    public void modWallBlock(RegistryObject<Block> block, ResourceLocation texture) {
        super.wallBlock((WallBlock) block.get(), texture);
        models().wallInventory(getName(block) + "_inventory", texture);
    }
    public String getName(Supplier<? extends Block> block) {
        return block.get().builtInRegistryHolder().key().location().getPath();
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    public ResourceLocation blockVanillaBlockLoc(Block block) {
        return new ResourceLocation("block/" + block.asItem());
    }
    public ResourceLocation blockLoc(Supplier<? extends Block> block) {
        return new ResourceLocation(DungeonsUnleashed.MODID, "block/" + getName(block));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("dungeonsunleashed:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath()));
    }
}
