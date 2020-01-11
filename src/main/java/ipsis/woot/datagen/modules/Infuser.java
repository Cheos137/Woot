package ipsis.woot.datagen.modules;

import ipsis.woot.Woot;
import ipsis.woot.crafting.InfuserRecipe;
import ipsis.woot.fluilds.FluidSetup;
import ipsis.woot.modules.generic.GenericSetup;
import ipsis.woot.modules.infuser.InfuserSetup;
import ipsis.woot.modules.infuser.items.DyeCasingItem;
import ipsis.woot.modules.infuser.items.DyePlateItem;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.block.Blocks;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Consumer;

public class Infuser {

    /**
     * For easy updating of json recipe energy and fluid costs
     */
    private static final ResourceLocation PRISM_RL = new ResourceLocation(Woot.MODID,"infuser/prism");
    private static final int PRISM_ENERGY_COST = 1000;
    private static final int PRISM_FLUID_COST = 1000;

    private static final ResourceLocation ENCH_BOOK_1_RL = new ResourceLocation(Woot.MODID,"infuser/ench_book_1");
    private static final ResourceLocation ENCH_BOOK_2_RL = new ResourceLocation(Woot.MODID,"infuser/ench_book_2");
    private static final ResourceLocation ENCH_BOOK_3_RL = new ResourceLocation(Woot.MODID,"infuser/ench_book_3");
    private static final ResourceLocation ENCH_BOOK_4_RL = new ResourceLocation(Woot.MODID,"infuser/ench_book_4");
    private static final ResourceLocation ENCH_BOOK_5_RL = new ResourceLocation(Woot.MODID,"infuser/ench_book_5");

    private static final int ENCH_BOOK_1_ENERGY_COST = 1000;
    private static final int ENCH_BOOK_2_ENERGY_COST = 2000;
    private static final int ENCH_BOOK_3_ENERGY_COST = 4000;
    private static final int ENCH_BOOK_4_ENERGY_COST = 8000;
    private static final int ENCH_BOOK_5_ENERGY_COST = 16000;
    private static final int ENCH_BOOK_1_FLUID_COST = 1000;
    private static final int ENCH_BOOK_2_FLUID_COST = 2000;
    private static final int ENCH_BOOK_3_FLUID_COST = 3000;
    private static final int ENCH_BOOK_4_FLUID_COST = 4000;
    private static final int ENCH_BOOK_5_FLUID_COST = 5000;

    private static final ResourceLocation ENCH_PLATE_1_RL = new ResourceLocation(Woot.MODID,"infuser/ench_plate_1");
    private static final ResourceLocation ENCH_PLATE_2_RL = new ResourceLocation(Woot.MODID,"infuser/ench_plate_2");
    private static final ResourceLocation ENCH_PLATE_3_RL = new ResourceLocation(Woot.MODID,"infuser/ench_plate_3");

    private static final int ENCH_PLATE_1_ENERGY_COST = 10000;
    private static final int ENCH_PLATE_2_ENERGY_COST = 20000;
    private static final int ENCH_PLATE_3_ENERGY_COST = 30000;
    private static final int ENCH_PLATE_1_FLUID_COST = 1000;
    private static final int ENCH_PLATE_2_FLUID_COST = 2000;
    private static final int ENCH_PLATE_3_FLUID_COST = 3000;

    private static final int DYE_ENERGY_COST = 400;
    private static final int DYE_FLUID_COST = 72;

    public static void registerRecipes(Consumer<IFinishedRecipe> consumer) {

        ShapedRecipeBuilder.shapedRecipe(InfuserSetup.INFUSER_BLOCK.get())
                .patternLine("idi")
                .patternLine("gbg")
                .patternLine("ioi")
                .key('i', GenericSetup.SI_PLATE_ITEM.get())
                .key('d', Blocks.DROPPER)
                .key('o', Tags.Items.OBSIDIAN)
                .key('b', Items.BUCKET)
                .key('g', Tags.Items.GLASS)
                .setGroup(Woot.MODID)
                .addCriterion("cobblestone", InventoryChangeTrigger.Instance.forItems(Blocks.COBBLESTONE))
                .build(consumer);

        InfuserRecipe.infuserRecipe(PRISM_RL,
                Ingredient.fromTag(Tags.Items.GLASS),
                Ingredient.EMPTY, 0,
                new FluidStack(FluidSetup.PUREDYE_FLUID.get(),PRISM_FLUID_COST),
                GenericSetup.PRISM_ITEM.get(), PRISM_ENERGY_COST)
                .build(consumer, PRISM_RL);

        ItemStack book = new ItemStack(Items.ENCHANTED_BOOK);
        InfuserRecipe.infuserRecipe(ENCH_BOOK_1_RL,
                Ingredient.fromItems(Items.BOOK),
                Ingredient.fromItems(Items.LAPIS_LAZULI), 1,
                new FluidStack(FluidSetup.ENCHANT_FLUID.get(), ENCH_BOOK_1_FLUID_COST),
                book.getItem(),  1, ENCH_BOOK_1_ENERGY_COST)
                .build(consumer, ENCH_BOOK_1_RL);
        InfuserRecipe.infuserRecipe(ENCH_BOOK_2_RL,
                Ingredient.fromItems(Items.BOOK),
                Ingredient.fromItems(Items.LAPIS_LAZULI), 2,
                new FluidStack(FluidSetup.ENCHANT_FLUID.get(), ENCH_BOOK_2_FLUID_COST),
                book.getItem(), 2, ENCH_BOOK_2_ENERGY_COST)
                .build(consumer, ENCH_BOOK_2_RL);
        InfuserRecipe.infuserRecipe(ENCH_BOOK_3_RL,
                Ingredient.fromItems(Items.BOOK),
                Ingredient.fromItems(Items.LAPIS_LAZULI), 3,
                new FluidStack(FluidSetup.ENCHANT_FLUID.get(), ENCH_BOOK_3_FLUID_COST),
                book.getItem(), 3, ENCH_BOOK_3_ENERGY_COST)
                .build(consumer, ENCH_BOOK_3_RL);
        InfuserRecipe.infuserRecipe(ENCH_BOOK_4_RL,
                Ingredient.fromItems(Items.BOOK),
                Ingredient.fromItems(Items.LAPIS_LAZULI), 4,
                new FluidStack(FluidSetup.ENCHANT_FLUID.get(), ENCH_BOOK_4_FLUID_COST),
                book.getItem(), 4, ENCH_BOOK_4_ENERGY_COST)
                .build(consumer, ENCH_BOOK_4_RL);
        InfuserRecipe.infuserRecipe(ENCH_BOOK_5_RL,
                Ingredient.fromItems(Items.BOOK),
                Ingredient.fromItems(Items.LAPIS_LAZULI), 5,
                new FluidStack(FluidSetup.ENCHANT_FLUID.get(), ENCH_BOOK_5_FLUID_COST),
                book.getItem(), 5, ENCH_BOOK_5_ENERGY_COST)
                .build(consumer, ENCH_BOOK_5_RL);

        InfuserRecipe.infuserRecipe(ENCH_PLATE_1_RL,
                Ingredient.fromItems(GenericSetup.SI_PLATE_ITEM.get()),
                Ingredient.fromTag(Tags.Items.INGOTS_IRON), 1,
                new FluidStack(FluidSetup.ENCHANT_FLUID.get(), ENCH_PLATE_1_FLUID_COST),
                GenericSetup.ENCH_PLATE_1.get(), ENCH_PLATE_1_ENERGY_COST)
                .build(consumer, ENCH_PLATE_1_RL);
        InfuserRecipe.infuserRecipe(ENCH_PLATE_2_RL,
                Ingredient.fromItems(GenericSetup.SI_PLATE_ITEM.get()),
                Ingredient.fromTag(Tags.Items.INGOTS_GOLD), 1,
                new FluidStack(FluidSetup.ENCHANT_FLUID.get(), ENCH_PLATE_2_FLUID_COST),
                GenericSetup.ENCH_PLATE_2.get(), ENCH_PLATE_2_ENERGY_COST)
                .build(consumer, ENCH_PLATE_2_RL);
        InfuserRecipe.infuserRecipe(ENCH_PLATE_3_RL,
                Ingredient.fromItems(GenericSetup.SI_PLATE_ITEM.get()),
                Ingredient.fromTag(Tags.Items.GEMS_DIAMOND), 1,
                new FluidStack(FluidSetup.ENCHANT_FLUID.get(), ENCH_PLATE_3_FLUID_COST),
                GenericSetup.ENCH_PLATE_3.get(), ENCH_PLATE_3_ENERGY_COST)
                .build(consumer, ENCH_PLATE_3_RL);

        /**
         * Plates
         */
        class Plate {
            RegistryObject<DyeCasingItem> casing;
            RegistryObject<DyePlateItem> plate;
            String name;
            ResourceLocation rl;
            public Plate(RegistryObject<DyeCasingItem> casing, RegistryObject<DyePlateItem> plate, String name) {
                this.casing = casing;
                this.plate = plate;
                this.name = name;
                this.rl = new ResourceLocation(Woot.MODID, "infuser/" + name + "_plate");
            }
        }
        Plate[] plates = {
                new Plate(InfuserSetup.WHITE_DYE_CASING_ITEM, InfuserSetup.WHITE_DYE_PLATE_ITEM, "white"),
                new Plate(InfuserSetup.ORANGE_DYE_CASING_ITEM, InfuserSetup.ORANGE_DYE_PLATE_ITEM, "orange"),
                new Plate(InfuserSetup.MAGENTA_DYE_CASING_ITEM, InfuserSetup.MAGENTA_DYE_PLATE_ITEM, "magenta"),
                new Plate(InfuserSetup.LIGHT_BLUE_DYE_CASING_ITEM, InfuserSetup.LIGHT_BLUE_DYE_PLATE_ITEM, "light_blue"),
                new Plate(InfuserSetup.YELLOW_DYE_CASING_ITEM, InfuserSetup.YELLOW_DYE_PLATE_ITEM, "yellow"),
                new Plate(InfuserSetup.LIME_DYE_CASING_ITEM, InfuserSetup.LIME_DYE_PLATE_ITEM, "lime"),
                new Plate(InfuserSetup.PINK_DYE_CASING_ITEM, InfuserSetup.PINK_DYE_PLATE_ITEM, "pink"),
                new Plate(InfuserSetup.GRAY_DYE_CASING_ITEM, InfuserSetup.GRAY_DYE_PLATE_ITEM, "gray"),
                new Plate(InfuserSetup.LIGHT_GRAY_DYE_CASING_ITEM, InfuserSetup.LIGHT_GRAY_DYE_PLATE_ITEM, "light_gray"),
                new Plate(InfuserSetup.CYAN_DYE_CASING_ITEM, InfuserSetup.CYAN_DYE_PLATE_ITEM, "cyan"),
                new Plate(InfuserSetup.PURPLE_DYE_CASING_ITEM, InfuserSetup.PURPLE_DYE_PLATE_ITEM, "purple"),
                new Plate(InfuserSetup.BLUE_DYE_CASING_ITEM, InfuserSetup.BLUE_DYE_PLATE_ITEM, "blue"),
                new Plate(InfuserSetup.BROWN_DYE_CASING_ITEM, InfuserSetup.BROWN_DYE_PLATE_ITEM, "brown"),
                new Plate(InfuserSetup.GREEN_DYE_CASING_ITEM, InfuserSetup.GREEN_DYE_PLATE_ITEM, "green"),
                new Plate(InfuserSetup.RED_DYE_CASING_ITEM, InfuserSetup.RED_DYE_PLATE_ITEM, "red"),
                new Plate(InfuserSetup.BLACK_DYE_CASING_ITEM, InfuserSetup.BLACK_DYE_PLATE_ITEM, "black")
        };

        for (Plate p : plates) {
            Woot.LOGGER.info("Generating Infuser recipe for {} plate", p.name);
            InfuserRecipe.infuserRecipe(p.rl,
                    Ingredient.fromItems(p.casing.get()),
                    Ingredient.EMPTY, 0,
                    new FluidStack(FluidSetup.PUREDYE_FLUID.get(), DYE_FLUID_COST),
                    p.plate.get(), DYE_ENERGY_COST)
                    .build(consumer, p.rl);
        }
    }
}