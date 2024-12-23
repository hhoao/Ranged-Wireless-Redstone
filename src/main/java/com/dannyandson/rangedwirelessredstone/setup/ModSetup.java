package com.dannyandson.rangedwirelessredstone.setup;

import com.dannyandson.rangedwirelessredstone.RangedWirelessRedstone;
import com.dannyandson.rangedwirelessredstone.blocks.recipes.RangedWirelessRedstoneRecipeProvider;
import com.dannyandson.rangedwirelessredstone.network.ModNetworkHandler;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = RangedWirelessRedstone.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModSetup {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        RangedWirelessRedstoneRecipeProvider myRecipeProvider =
            new RangedWirelessRedstoneRecipeProvider(event.getGenerator().getPackOutput());
        event.getGenerator().addProvider(true, myRecipeProvider);
    }

    public static void init(final FMLCommonSetupEvent event) {
        // register everything
        if (ModList.get().isLoaded("tinyredstone"))
            TinyRedstoneRegistration.registerPanelCells();
        ModNetworkHandler.registerMessages();
    }
}
