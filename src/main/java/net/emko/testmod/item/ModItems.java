package net.emko.testmod.item;

import net.emko.testmod.TestMod;

import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, TestMod.MOD_ID);

    public static final RegistryObject<Item> ANGEL = ITEMS.register("angel_chantov",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COOKED_ANGEL = ITEMS.register("cooked_angel_chantov",
            () -> new Item(new Item.Properties().food(FoodValues.COOKED_ANGEL)));




    public static final RegistryObject<Item> ANGEL_SWORD = ITEMS.register("chantoviq",
            () -> new SwordItem(ModItemTier.ANGEL_CHANTOV, 3, -2.4F, new Item.Properties()));



    public static class FoodValues {
        public static final FoodProperties COOKED_ANGEL = new FoodProperties.Builder().nutrition(6).saturationMod(1.5F).meat().fast()
                .effect( ()-> new MobEffectInstance(MobEffects.ABSORPTION, 600, 4), 1).build();
    }

    public enum ModItemTier implements Tier {
        ANGEL_CHANTOV(3, 3427, 10.0F, 9.0F, 5, () -> {
            return Ingredient.of(ModItems.ANGEL.get());
        }),
        EXAMPLE(1, 1, 1.0F, 1.0F, 1, () -> {
            return Ingredient.of(Items.STICK);
        });

        private final int level;
        private final int uses;
        private final float speed;
        private final float damage;
        private final int enchantmentValue;
        private final LazyLoadedValue<Ingredient> repairIngredient;

        ModItemTier(int level, int durability, float miningSpeed, float damage, int enchantability, Supplier<Ingredient> repairIngredient) {
            this.level = level;
            this.uses = durability;
            this.speed = miningSpeed;
            this.damage = damage;
            this.enchantmentValue = enchantability;
            this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
        }

        public int getUses() {
            return this.uses;
        }

        public float getSpeed() {
            return this.speed;
        }

        public float getAttackDamageBonus() {
            return this.damage;
        }

        public int getLevel() {
            return this.level;
        }

        public int getEnchantmentValue() {
            return this.enchantmentValue;
        }

        public Ingredient getRepairIngredient() {
            return this.repairIngredient.get();
        }
    }

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
