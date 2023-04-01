package net.emko.testmod.item;

import net.emko.testmod.TestMod;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> ANGEL = ITEMS.register("angel_chantov",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COOKED_ANGEL = ITEMS.register("cooked_angel_chantov",
            () -> new Item(new Item.Properties().food(FoodValues.COOKED_ANGEL)));




    public static class FoodValues {
        public static final FoodProperties COOKED_ANGEL = new FoodProperties.Builder().nutrition(6).saturationMod(1.5F).meat().fast()
                .effect( ()-> new MobEffectInstance(MobEffects.ABSORPTION, 600, 4), 1).build();
    }



    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
