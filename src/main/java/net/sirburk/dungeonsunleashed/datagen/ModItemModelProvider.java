package net.sirburk.dungeonsunleashed.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.sirburk.dungeonsunleashed.DungeonsUnleashed;
import net.sirburk.dungeonsunleashed.item.ModItems;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, DungeonsUnleashed.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //simpleItem(ModItems.RUBY);


        withExistingParent("granite_brick_stairs", modLoc("block/granite_brick_stairs"));
        withExistingParent("granite_brick_slab", modLoc("block/granite_brick_slab"));
        withExistingParent("granite_brick_wall", modLoc("block/granite_brick_wall_inventory"));
        simpleItem(ModItems.VOID_POOL_BUCKET);

    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DungeonsUnleashed.MODID,"item/" + item.getId().getPath()));
    }
    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(DungeonsUnleashed.MODID, "item/" + item.getId().getPath()));
    }
}
