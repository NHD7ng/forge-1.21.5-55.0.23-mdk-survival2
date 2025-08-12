package net.HuyDung.HDsurvival2.blocks;

import net.HuyDung.HDsurvival2.HDSurvivalMod2;
import net.HuyDung.HDsurvival2.items.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, HDSurvivalMod2.MOD_ID);

    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registryBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("alexandrite_block"))
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.AMETHYST)));

    public static final RegistryObject<Block> RAW_ALEXANDRITE_BLOCK = registryBlock("raw_alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("raw_alexandrite_block"))
                    .strength(4f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALEXANDRITE_ORE = registryBlock("alexandrite_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("alexandrite_ore"))
                    .strength(3f).requiresCorrectToolForDrops()));

    public static final RegistryObject<Block> ALEXANDRITE_DEEPSLATE_ORE = registryBlock("alexandrite_deepslate_ore",
            () -> new DropExperienceBlock(UniformInt.of(3,6), BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("alexandrite_deepslate_ore"))
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));

    public static final RegistryObject<Block> MAGIC_GEM_ORE = registryBlock("magic_gem_ore",
            () -> new DropExperienceBlock(UniformInt.of(2,5), BlockBehaviour.Properties.of()
                    .setId(BLOCKS.key("magic_gem_ore"))
                    .strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block ){
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()
                .setId(ModItems.ITEMS.key(name)) ));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
