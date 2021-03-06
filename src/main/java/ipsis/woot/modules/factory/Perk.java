package ipsis.woot.modules.factory;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TranslationTextComponent;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;

public enum Perk implements IStringSerializable {
    EMPTY,
    EFFICIENCY_1,
    EFFICIENCY_2,
    EFFICIENCY_3,
    LOOTING_1,
    LOOTING_2,
    LOOTING_3,
    MASS_1,
    MASS_2,
    MASS_3,
    RATE_1,
    RATE_2,
    RATE_3,
    TIER_SHARD_1,
    TIER_SHARD_2,
    TIER_SHARD_3,
    XP_1,
    XP_2,
    XP_3,
    HEADLESS_1,
    HEADLESS_2,
    HEADLESS_3,
    SLAUGHTER_1,
    SLAUGHTER_2,
    SLAUGHTER_3,
    CRUSHER_1,
    CRUSHER_2,
    CRUSHER_3
    ;

    public static Perk[] VALUES = values();
    public String getName() { return name().toLowerCase(Locale.ROOT); }
    public String getString() { return getName(); }

    public static Perk getPerks(int index) {
        index = MathHelper.clamp(index, 0, VALUES.length);
        return VALUES[index];
    }

    public static final EnumSet<Perk> LEVEL_1_PERKS = EnumSet.of(EFFICIENCY_1, LOOTING_1, MASS_1, RATE_1, TIER_SHARD_1, XP_1, HEADLESS_1, SLAUGHTER_1, CRUSHER_1);
    public static final EnumSet<Perk> LEVEL_2_PERKS = EnumSet.of(EFFICIENCY_2, LOOTING_2, MASS_2, RATE_2, TIER_SHARD_2, XP_2, HEADLESS_2, SLAUGHTER_2, CRUSHER_2);
    public static final EnumSet<Perk> LEVEL_3_PERKS = EnumSet.of(EFFICIENCY_3, LOOTING_3, MASS_3, RATE_3, TIER_SHARD_3, XP_3, HEADLESS_3, SLAUGHTER_3, CRUSHER_3);

    public static final EnumSet<Perk> EFFICIENCY_PERKS = EnumSet.of(EFFICIENCY_1, EFFICIENCY_2, EFFICIENCY_3);
    public static final EnumSet<Perk> LOOTING_PERKS = EnumSet.of(LOOTING_1, LOOTING_2, LOOTING_3);
    public static final EnumSet<Perk> MASS_PERKS = EnumSet.of(MASS_1, MASS_2, MASS_3);
    public static final EnumSet<Perk> RATE_PERKS = EnumSet.of(RATE_1, RATE_2, RATE_3);
    public static final EnumSet<Perk> XP_PERKS = EnumSet.of(XP_1, XP_2, XP_3);
    public static final EnumSet<Perk> TIER_SHARD_PERKS = EnumSet.of(TIER_SHARD_1, TIER_SHARD_2, TIER_SHARD_3);
    public static final EnumSet<Perk> HEADLESS_PERKS = EnumSet.of(HEADLESS_1, HEADLESS_2, HEADLESS_3);
    public static final EnumSet<Perk> SLAUGHTER_PERKS = EnumSet.of(SLAUGHTER_1, SLAUGHTER_2, SLAUGHTER_3);
    public static final EnumSet<Perk> CRUSHER_PERKS = EnumSet.of(CRUSHER_1, CRUSHER_2, CRUSHER_3);

    public static Perk getPerks(PerkType type, int level) {
        // Hmmmm, not sure about this
        Perk upgrade = null;
        level = MathHelper.clamp(level, 1, 3) - 1;
        if (type == PerkType.EFFICIENCY) {
            upgrade = EFFICIENCY_PERKS.toArray(new Perk[0])[level];
        } else if (type == PerkType.LOOTING) {
            upgrade = LOOTING_PERKS.toArray(new Perk[0])[level];
        } else if (type == PerkType.MASS) {
            upgrade = MASS_PERKS.toArray(new Perk[0])[level];
        } else if (type == PerkType.RATE) {
            upgrade = RATE_PERKS.toArray(new Perk[0])[level];
        } else if (type == PerkType.XP) {
            upgrade = XP_PERKS.toArray(new Perk[0])[level];
        } else if (type == PerkType.TIER_SHARD) {
            upgrade = TIER_SHARD_PERKS.toArray(new Perk[0])[level];
        } else if (type == PerkType.HEADLESS) {
            upgrade = HEADLESS_PERKS.toArray(new Perk[0])[level];
        } else if (type == PerkType.SLAUGHTER) {
            upgrade = SLAUGHTER_PERKS.toArray(new Perk[0])[level];
        } else if (type == PerkType.CRUSHER) {
            upgrade = CRUSHER_PERKS.toArray(new Perk[0])[level];
        }
        return upgrade;
    }

    public static PerkType getType(Perk perk) {
        if (EFFICIENCY_PERKS.contains(perk))
            return PerkType.EFFICIENCY;
        if (LOOTING_PERKS.contains(perk))
            return PerkType.LOOTING;
        if (MASS_PERKS.contains(perk))
            return PerkType.MASS;
        if (RATE_PERKS.contains(perk))
            return PerkType.RATE;
        if (TIER_SHARD_PERKS.contains(perk))
            return PerkType.TIER_SHARD;
        if (HEADLESS_PERKS.contains(perk))
            return PerkType.HEADLESS;
        if (SLAUGHTER_PERKS.contains(perk))
            return PerkType.SLAUGHTER;
        if (CRUSHER_PERKS.contains(perk))
            return PerkType.CRUSHER;

        return PerkType.XP;
    }

    public static int getLevel(Perk perk) {
        if (LEVEL_1_PERKS.contains(perk))
            return 1;
        if (LEVEL_2_PERKS.contains(perk))
            return 2;

        return 3;
    }


    public TranslationTextComponent getTooltip() {
        if (EFFICIENCY_PERKS.contains(this))
            return new TranslationTextComponent( "info.woot.perk.efficiency");
        if (LOOTING_PERKS.contains(this))
            return new TranslationTextComponent("info.woot.perk.looting");
        if (MASS_PERKS.contains(this))
            return new TranslationTextComponent("info.woot.perk.mass");
        if (RATE_PERKS.contains(this))
            return new TranslationTextComponent("info.woot.perk.rate");
        if (TIER_SHARD_PERKS.contains(this))
            return new TranslationTextComponent("info.woot.perk.tier_shard");
        if (XP_PERKS.contains(this))
            return new TranslationTextComponent("info.woot.perk.xp");
        if (HEADLESS_PERKS.contains(this))
            return new TranslationTextComponent("info.woot.perk.headless");
        if (SLAUGHTER_PERKS.contains(this))
            return new TranslationTextComponent("info.woot.perk.slaughter");
        if (CRUSHER_PERKS.contains(this))
            return new TranslationTextComponent("info.woot.perk.crusher");

        return new TranslationTextComponent("");
    }

    public List<TranslationTextComponent> getTooltipForLevel() {
        List<TranslationTextComponent> tooltips = new ArrayList<>();
        if (EFFICIENCY_PERKS.contains(this) && getLevel(this) == 1)
            tooltips.add(new TranslationTextComponent("info.woot.perk.efficiency.0", FactoryConfiguration.EFFICIENCY_1.get()));
        else if (EFFICIENCY_PERKS.contains(this) && getLevel(this) == 2)
            tooltips.add(new TranslationTextComponent("info.woot.perk.efficiency.0", FactoryConfiguration.EFFICIENCY_2.get()));
        else if (EFFICIENCY_PERKS.contains(this) && getLevel(this) == 3)
            tooltips.add(new TranslationTextComponent("info.woot.perk.efficiency.0", FactoryConfiguration.EFFICIENCY_3.get()));
        else if (MASS_PERKS.contains(this) && getLevel(this) == 1)
            tooltips.add(new TranslationTextComponent("info.woot.perk.mass.0", FactoryConfiguration.MASS_COUNT_1.get()));
        else if (MASS_PERKS.contains(this) && getLevel(this) == 2)
            tooltips.add(new TranslationTextComponent("info.woot.perk.mass.0", FactoryConfiguration.MASS_COUNT_2.get()));
        else if (MASS_PERKS.contains(this) && getLevel(this) == 3)
            tooltips.add(new TranslationTextComponent("info.woot.perk.mass.0", FactoryConfiguration.MASS_COUNT_3.get()));
        else if (RATE_PERKS.contains(this) && getLevel(this) == 1)
            tooltips.add(new TranslationTextComponent("info.woot.perk.rate.0", FactoryConfiguration.RATE_1.get()));
        else if (RATE_PERKS.contains(this) && getLevel(this) == 2)
            tooltips.add(new TranslationTextComponent("info.woot.perk.rate.0", FactoryConfiguration.RATE_2.get()));
        else if (RATE_PERKS.contains(this) && getLevel(this) == 3)
            tooltips.add(new TranslationTextComponent("info.woot.perk.rate.0", FactoryConfiguration.RATE_3.get()));
        else if (TIER_SHARD_PERKS.contains(this) && getLevel(this) == 1)
            tooltips.add(new TranslationTextComponent("info.woot.perk.tier_shard.0", FactoryConfiguration.TIER_SHARD_1.get()));
        else if (TIER_SHARD_PERKS.contains(this) && getLevel(this) == 2)
            tooltips.add(new TranslationTextComponent("info.woot.perk.tier_shard.0", FactoryConfiguration.TIER_SHARD_2.get()));
        else if (TIER_SHARD_PERKS.contains(this) && getLevel(this) == 3)
            tooltips.add(new TranslationTextComponent("info.woot.perk.tier_shard.0", FactoryConfiguration.TIER_SHARD_3.get()));
        else if (XP_PERKS.contains(this) && getLevel(this) == 1)
            tooltips.add(new TranslationTextComponent("info.woot.perk.xp.0", FactoryConfiguration.XP_1.get()));
        else if (XP_PERKS.contains(this) && getLevel(this) == 2)
            tooltips.add(new TranslationTextComponent("info.woot.perk.xp.0", FactoryConfiguration.XP_2.get()));
        else if (XP_PERKS.contains(this) && getLevel(this) == 3)
            tooltips.add(new TranslationTextComponent("info.woot.perk.xp.0", FactoryConfiguration.XP_3.get()));
        else if (HEADLESS_PERKS.contains(this) && getLevel(this) == 1)
            tooltips.add(new TranslationTextComponent("info.woot.perk.headless.0", FactoryConfiguration.HEADLESS_1.get()));
        else if (HEADLESS_PERKS.contains(this) && getLevel(this) == 2)
            tooltips.add(new TranslationTextComponent("info.woot.perk.headless.0", FactoryConfiguration.HEADLESS_2.get()));
        else if (HEADLESS_PERKS.contains(this) && getLevel(this) == 3)
            tooltips.add(new TranslationTextComponent("info.woot.perk.headless.0", FactoryConfiguration.HEADLESS_3.get()));
        else if (SLAUGHTER_PERKS.contains(this) && getLevel(this) == 1)
            tooltips.add(new TranslationTextComponent("info.woot.perk.slaughter.0", FactoryConfiguration.SLAUGHTER_1.get()));
        else if (SLAUGHTER_PERKS.contains(this) && getLevel(this) == 2)
            tooltips.add(new TranslationTextComponent("info.woot.perk.slaughter.0", FactoryConfiguration.SLAUGHTER_2.get()));
        else if (SLAUGHTER_PERKS.contains(this) && getLevel(this) == 3)
            tooltips.add(new TranslationTextComponent("info.woot.perk.slaughter.0", FactoryConfiguration.SLAUGHTER_3.get()));
        else if (CRUSHER_PERKS.contains(this) && getLevel(this) == 1)
            tooltips.add(new TranslationTextComponent("info.woot.perk.crusher.0", FactoryConfiguration.CRUSHER_1.get()));
        else if (CRUSHER_PERKS.contains(this) && getLevel(this) == 2)
            tooltips.add(new TranslationTextComponent("info.woot.perk.crusher.0", FactoryConfiguration.CRUSHER_2.get()));
        else if (CRUSHER_PERKS.contains(this) && getLevel(this) == 3)
            tooltips.add(new TranslationTextComponent("info.woot.perk.crusher.0", FactoryConfiguration.CRUSHER_3.get()));

        return tooltips;
    }

}
