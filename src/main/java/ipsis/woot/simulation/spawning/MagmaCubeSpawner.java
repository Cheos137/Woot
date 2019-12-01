package ipsis.woot.simulation.spawning;

import ipsis.woot.Woot;
import ipsis.woot.util.FakeMob;
import ipsis.woot.util.helper.FakeMobHelper;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Method;

public class MagmaCubeSpawner extends AbstractMobSpawner {

    @Override
    public void apply(LivingEntity livingEntity, FakeMob fakeMob, World world) {

        if (!(livingEntity instanceof MagmaCubeEntity))
            return;

        try {
            Method method = ObfuscationReflectionHelper.findMethod(
                    MagmaCubeEntity.class,
                    "setSlimeSize",
                    int.class,
                    boolean.class);
            if (FakeMobHelper.isSmallMagmaCube(fakeMob))
                method.invoke(livingEntity, 1, false);
            else
                method.invoke(livingEntity, 2, false);
        } catch (Throwable e) {
            Woot.LOGGER.error("Reflection MagmaCubeEntity.setSlimeSize failed");
        }
    }
}