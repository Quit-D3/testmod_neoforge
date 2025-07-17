package me.quitd3.testmod.block;

import me.quitd3.testmod.Testmod;
import me.quitd3.testmod.item.ModItem;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Function;

public class ModBlock{
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Testmod.MOD_ID);

    public static final DeferredBlock<Block> BISMUTH_BLOCK = registerBlock(
            "bismuth_block", (properties) -> new Block(properties
                    .strength(1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.AMETHYST)));

    public static final DeferredBlock<Block> BISMUTH_ORE = registerBlock(
            "bismuth_ore", (properties) -> new DropExperienceBlock(UniformInt.of(2,4), properties
                    .strength(1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.STONE)));

    public static final DeferredBlock<Block> BISMUTH_DEEPSLATE_ORE = registerBlock(
            "bismuth_deepslate_ore", (properties) -> new DropExperienceBlock(UniformInt.of(3,6), properties
                    .strength(1f)
                    .requiresCorrectToolForDrops()
                    .sound(SoundType.DEEPSLATE)));

    private static <T extends Block>DeferredBlock<T>registerBlock(String name, Function<BlockBehaviour.Properties,T> function){
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>void registerBlockItem(String name, DeferredBlock<T> block){ModItem.ITEMS.registerItem(
                name, (properties -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix())));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}