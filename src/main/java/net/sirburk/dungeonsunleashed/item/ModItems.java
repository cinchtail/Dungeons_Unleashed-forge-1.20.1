package net.sirburk.dungeonsunleashed.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.sirburk.dungeonsunleashed.DungeonsUnleashed;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, DungeonsUnleashed.MODID);
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
