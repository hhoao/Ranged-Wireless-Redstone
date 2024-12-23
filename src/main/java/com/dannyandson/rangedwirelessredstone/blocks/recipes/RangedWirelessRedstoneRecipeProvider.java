package com.dannyandson.rangedwirelessredstone.blocks.recipes;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.TrueCondition;

import java.util.function.Consumer;

import static com.dannyandson.rangedwirelessredstone.setup.Registration.RECEIVER_BLOCK;
import static com.dannyandson.rangedwirelessredstone.setup.Registration.TRANSMITTER_BLOCK;

public class RangedWirelessRedstoneRecipeProvider extends RecipeProvider {
    public RangedWirelessRedstoneRecipeProvider(DataGenerator p_248933_) {
        super(p_248933_);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ConditionalRecipe.builder()
            .addCondition(TrueCondition.INSTANCE)
            .addRecipe(
                ShapedRecipeBuilder.shaped(
                        TRANSMITTER_BLOCK.get())
                    .pattern(" P ")
                    .pattern(" R ")
                    .pattern("SRS")
                    .define('P', Items.ENDER_PEARL)
                    .define('R', Items.REDSTONE)
                    .define('S', Items.SMOOTH_STONE_SLAB)
                    .unlockedBy("has_redstone", has(Items.REDSTONE))
                    ::save)
            .generateAdvancement()
            .build(consumer, TRANSMITTER_BLOCK.getId());

        ConditionalRecipe.builder()
            .addCondition(TrueCondition.INSTANCE)
            .addRecipe(
                ShapedRecipeBuilder.shaped(
                        RECEIVER_BLOCK.get())
                    .pattern("T T")
                    .pattern("R R")
                    .pattern("STS")
                    .define('S',  Items.SMOOTH_STONE_SLAB)
                    .define('T',  Items.REDSTONE_TORCH)
                    .define('R', Items.REDSTONE)
                    .unlockedBy("has_redstone", has(Items.REDSTONE))
                    ::save)
            .generateAdvancement()
            .build(consumer, RECEIVER_BLOCK.getId());
    }
}
