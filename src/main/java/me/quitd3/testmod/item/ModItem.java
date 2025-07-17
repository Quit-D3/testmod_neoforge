package me.quitd3.testmod.item;

import me.quitd3.testmod.Testmod;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItem{
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Testmod.MOD_ID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.registerItem(
            "bismuth",Item::new,new Item.Properties());
    public static final DeferredItem<Item> RAW_BISMUTH = ITEMS.registerItem(
            "raw_bismuth",Item::new,new Item.Properties());



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}