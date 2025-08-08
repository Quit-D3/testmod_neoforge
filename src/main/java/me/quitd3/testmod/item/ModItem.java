package me.quitd3.testmod.item;

import me.quitd3.testmod.Testmod;
import me.quitd3.testmod.item.custom.ChiselItem;
import me.quitd3.testmod.item.custom.FuelItem;
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

    public static final DeferredItem<Item> CHISEL = ITEMS.registerItem(
            "chisel", ChiselItem::new,new Item.Properties()
                    .durability(32));

    public static final DeferredItem<Item> RADISH = ITEMS.registerItem(
            "radish", (properties -> new Item(properties.food(
                    ModFoodProperties.RADISH,
                    ModFoodProperties.RADISH_EFFECT))));
    public static final DeferredItem<Item> GOJI_BERRIES = ITEMS.registerItem(
            "goji_berries", Item::new, new Item.Properties()
                    .food(ModFoodProperties.GOJI_BERRIES));

//    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.registerItem(
//            "frostfire_ice",(properties) -> new FuelItem(properties, 800));
    public static final DeferredItem<Item> FROSTFIRE_ICE = ITEMS.registerItem(
            "frostfire_ice",Item::new);
    public static final DeferredItem<Item> STARLIGHT_ASHES =ITEMS.registerItem(
            "starlight_ashes",Item::new);

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}