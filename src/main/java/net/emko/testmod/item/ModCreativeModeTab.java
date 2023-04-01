package net.emko.testmod.item;

import net.emko.testmod.TestMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TestMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTab {
    public static CreativeModeTab TAB1;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event){
        TAB1 = event.registerCreativeModeTab(new ResourceLocation(TestMod.MOD_ID, "test_tab1"),
                builder -> builder.icon(() -> new ItemStack(ModItems.ANGEL.get())).
                        title(Component.translatable("creativemodetab.test_tab1")));
    }
}
