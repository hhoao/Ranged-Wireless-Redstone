package com.dannyandson.rangedwirelessredstone.setup;

import com.dannyandson.rangedwirelessredstone.RangedWirelessRedstone;
import com.dannyandson.rangedwirelessredstone.blocks.recipes.RangedWirelessRedstoneRecipeProvider;
import com.dannyandson.rangedwirelessredstone.network.ModNetworkHandler;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = RangedWirelessRedstone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
    public static final ItemGroup ITEM_GROUP = new ItemGroup(RangedWirelessRedstone.MODID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.TRANSMITTER_BLOCK.get());
        }
    };
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        RangedWirelessRedstoneRecipeProvider myRecipeProvider =
            new RangedWirelessRedstoneRecipeProvider(event.getGenerator());
        event.getGenerator().addProvider(myRecipeProvider);
    }

    public static void init(final FMLCommonSetupEvent event) {
        // register everything
        if (ModList.get().isLoaded("tinyredstone"))
            TinyRedstoneRegistration.registerPanelCells();
        ModNetworkHandler.registerMessages();
    }
}
