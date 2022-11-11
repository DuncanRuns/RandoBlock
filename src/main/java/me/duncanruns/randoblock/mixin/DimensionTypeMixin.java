package me.duncanruns.randoblock.mixin;

import me.duncanruns.randoblock.NetherTypeHaverThing;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(DimensionType.class)
public class DimensionTypeMixin implements NetherTypeHaverThing {
    @Shadow
    @Final
    protected static DimensionType THE_NETHER;

    @Override
    public DimensionType getNetherDimensionType() {
        return THE_NETHER;
    }
}
