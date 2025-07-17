package me.quitd3.testmod.item;

import me.quitd3.testmod.Testmod;
import me.quitd3.testmod.block.ModBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Testmod.MOD_ID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEM_TAB = CREATIVE_MODE_TAB.register(
            "bismuth_item_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItem.BISMUTH.get()))
                    .title(Component.translatable("creativetab.testmod.bismuth_item"))
                    .displayItems((itemDisplayParameters,output) ->{
                        output.accept(ModItem.BISMUTH);
                        output.accept(ModItem.RAW_BISMUTH);

                    }).build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCK_TAB = CREATIVE_MODE_TAB.register(
            "bismuth_block_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlock.BISMUTH_BLOCK))
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(Testmod.MOD_ID,"bismuth_item_tab"))
                    .title(Component.translatable("creativetab.testmod.bismuth_block"))
                    .displayItems((itemDisplayParameters,output) ->{
                        output.accept(ModBlock.BISMUTH_BLOCK);
                        output.accept(ModBlock.BISMUTH_ORE);
                        output.accept(ModBlock.BISMUTH_DEEPSLATE_ORE);

                    }).build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
