package me.duncanruns.randoblock;

import net.fabricmc.api.ModInitializer;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Pair;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class RandoBlock implements ModInitializer {

    public static final String MOD_ID = "randoblock";
    public static final String MOD_NAME = "RandoBlock";

    private static final float COMMON_BLOCKS = 15f;
    private static final float RARE_BLOCK = 5f;
    private static final float LEGENDARY_BLOCK = 1f;

    private static final Pair<Float, BlockState>[] BLOCK_DISTRIBUTIONS = new Pair[]{
            new Pair<>(COMMON_BLOCKS, Blocks.COBBLESTONE.getDefaultState()),
            new Pair<>(COMMON_BLOCKS, Blocks.DIRT.getDefaultState()),
            new Pair<>(COMMON_BLOCKS, Blocks.GRAVEL.getDefaultState()),

            new Pair<>(RARE_BLOCK, Blocks.SLIME_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WATER.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LAVA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GRANITE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.POLISHED_GRANITE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DIORITE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.POLISHED_DIORITE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ANDESITE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.POLISHED_ANDESITE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.COARSE_DIRT.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PODZOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.COBBLESTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.OAK_PLANKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SPRUCE_PLANKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BIRCH_PLANKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.JUNGLE_PLANKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ACACIA_PLANKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DARK_OAK_PLANKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BEDROCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GOLD_ORE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.IRON_ORE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.COAL_ORE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.NETHER_GOLD_ORE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.OAK_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SPRUCE_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BIRCH_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.JUNGLE_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ACACIA_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DARK_OAK_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_SPRUCE_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_BIRCH_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_JUNGLE_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_ACACIA_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_DARK_OAK_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_OAK_LOG.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.OAK_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SPRUCE_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BIRCH_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.JUNGLE_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ACACIA_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DARK_OAK_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_OAK_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_SPRUCE_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_BIRCH_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_JUNGLE_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_ACACIA_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_DARK_OAK_WOOD.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SPONGE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WET_SPONGE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LAPIS_ORE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LAPIS_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SANDSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CHISELED_SANDSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CUT_SANDSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STICKY_PISTON.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PISTON.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WHITE_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ORANGE_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MAGENTA_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_BLUE_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.YELLOW_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIME_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PINK_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GRAY_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_GRAY_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CYAN_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PURPLE_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLUE_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BROWN_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GREEN_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.RED_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLACK_WOOL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GOLD_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.IRON_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BOOKSHELF.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MOSSY_COBBLESTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.OBSIDIAN.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DIAMOND_ORE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DIAMOND_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CRAFTING_TABLE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.REDSTONE_ORE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SNOW_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CLAY.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.JUKEBOX.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PUMPKIN.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.NETHERRACK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SOUL_SAND.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SOUL_SOIL.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BASALT.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.POLISHED_BASALT.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GLOWSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CARVED_PUMPKIN.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.JACK_O_LANTERN.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WHITE_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ORANGE_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MAGENTA_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_BLUE_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.YELLOW_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIME_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PINK_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GRAY_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_GRAY_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CYAN_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PURPLE_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLUE_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BROWN_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GREEN_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.RED_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLACK_STAINED_GLASS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MOSSY_STONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CRACKED_STONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CHISELED_STONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.INFESTED_STONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.INFESTED_MOSSY_STONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.INFESTED_CRACKED_STONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.INFESTED_CHISELED_STONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.RED_MUSHROOM_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MELON.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MYCELIUM.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.NETHER_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.END_STONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.REDSTONE_LAMP.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.EMERALD_ORE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.EMERALD_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.REDSTONE_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.NETHER_QUARTZ_ORE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.QUARTZ_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CHISELED_QUARTZ_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.QUARTZ_PILLAR.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WHITE_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ORANGE_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MAGENTA_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_BLUE_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.YELLOW_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIME_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PINK_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GRAY_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_GRAY_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CYAN_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PURPLE_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLUE_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BROWN_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GREEN_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.RED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLACK_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BARRIER.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PRISMARINE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PRISMARINE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DARK_PRISMARINE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SEA_LANTERN.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.HAY_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.COAL_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PACKED_ICE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.RED_SANDSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CHISELED_RED_SANDSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CUT_RED_SANDSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SMOOTH_STONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SMOOTH_SANDSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SMOOTH_QUARTZ.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SMOOTH_RED_SANDSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PURPUR_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PURPUR_PILLAR.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.END_STONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MAGMA_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.NETHER_WART_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.RED_NETHER_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BONE_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WHITE_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ORANGE_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MAGENTA_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_BLUE_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.YELLOW_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIME_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PINK_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GRAY_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_GRAY_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CYAN_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PURPLE_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLUE_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BROWN_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GREEN_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.RED_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLACK_GLAZED_TERRACOTTA.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WHITE_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ORANGE_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.MAGENTA_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_BLUE_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.YELLOW_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIME_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PINK_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GRAY_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.LIGHT_GRAY_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CYAN_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.PURPLE_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLUE_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BROWN_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GREEN_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.RED_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLACK_CONCRETE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DRIED_KELP_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DEAD_TUBE_CORAL_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DEAD_BRAIN_CORAL_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DEAD_BUBBLE_CORAL_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DEAD_FIRE_CORAL_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.DEAD_HORN_CORAL_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLUE_ICE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WARPED_STEM.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_WARPED_STEM.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WARPED_HYPHAE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_WARPED_HYPHAE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WARPED_NYLIUM.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WARPED_WART_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CRIMSON_STEM.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_CRIMSON_STEM.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CRIMSON_HYPHAE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.STRIPPED_CRIMSON_HYPHAE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CRIMSON_NYLIUM.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.SHROOMLIGHT.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CRIMSON_PLANKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.WARPED_PLANKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.TARGET.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.HONEYCOMB_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.NETHERITE_BLOCK.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.ANCIENT_DEBRIS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CRYING_OBSIDIAN.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.BLACKSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.POLISHED_BLACKSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.POLISHED_BLACKSTONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CHISELED_POLISHED_BLACKSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.GILDED_BLACKSTONE.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CHISELED_NETHER_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.CRACKED_NETHER_BRICKS.getDefaultState()),
            new Pair<>(RARE_BLOCK, Blocks.QUARTZ_BRICKS.getDefaultState()),

            new Pair<>(LEGENDARY_BLOCK, Blocks.TNT.getDefaultState()),
    };

    private static final float TOTAL_WEIGHT = Arrays.stream(BLOCK_DISTRIBUTIONS).map((p) -> p.getLeft()).reduce(0f, (a, b) -> a + b);

    private static final TreeMap<Float, BlockState> SAMPLER = getSampler();

    private static TreeMap<Float, BlockState> getSampler() {
        var sampler = new TreeMap<Float, BlockState>();
        var acc = 0f;

        for (var i = 0; i < BLOCK_DISTRIBUTIONS.length; i++) {
            var entry = BLOCK_DISTRIBUTIONS[i];
            sampler.put(acc, entry.getRight());
            acc += entry.getLeft();
        }

        return sampler;
    }

    private static final Random RANDOM = new Random();
    public static Logger LOGGER = LogManager.getLogger();

    public static BlockState randomBlock() {
        var sample = RANDOM.nextFloat(TOTAL_WEIGHT);
        return SAMPLER.floorEntry(sample).getValue();
    }

    @Override
    public void onInitialize() {
        log(Level.INFO, "Initializing");
    }

    public static void log(Level level, String message) {
        LOGGER.log(level, "[" + MOD_NAME + "] " + message);
    }

}