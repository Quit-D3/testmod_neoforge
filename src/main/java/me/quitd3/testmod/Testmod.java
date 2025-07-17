package me.quitd3.testmod;

import me.quitd3.testmod.block.ModBlock;
import me.quitd3.testmod.item.ModCreativeTab;
import me.quitd3.testmod.item.ModItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.slf4j.Logger;
import com.mojang.logging.LogUtils;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Testmod.MOD_ID)
public class Testmod {
    public static final String MOD_ID = "testmod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Testmod(IEventBus modEventBus, ModContainer modContainer){
        modEventBus.addListener(this::commonSetup);
        NeoForge.EVENT_BUS.register(this);
        Testmod.LOGGER.info("Testmod initialized");

        ModCreativeTab.register(modEventBus);
        ModItem.register(modEventBus);
        ModBlock.register(modEventBus);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItem.BISMUTH);
            event.accept(ModItem.RAW_BISMUTH);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlock.BISMUTH_BLOCK);
            event.accept(ModBlock.BISMUTH_ORE);
        }
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

}
