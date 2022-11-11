package me.duncanruns.randoblock.mixin;

import me.duncanruns.randoblock.NetherTypeHaverThing;
import me.duncanruns.randoblock.RandoBlock;
import net.minecraft.block.BlockState;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.dimension.DimensionType;
import net.minecraft.world.gen.StructureAccessor;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SurfaceChunkGenerator.class)
public class SurfaceChunkGeneratorMixin {

    private WorldAccess world;

    @Inject(method = "getBlockState", at = @At("HEAD"), cancellable = true)
    private void getBlockStateMixin(double density, int y, CallbackInfoReturnable<BlockState> info) {
        if (density > 0.0D)
            info.setReturnValue(RandoBlock.randomBlock((world == null || world.getDimension() == null) ? ((NetherTypeHaverThing) (DimensionType.getOverworldDimensionType())).getNetherDimensionType() : world.getDimension()));
    }

    @Inject(method = "populateNoise", at = @At("HEAD"))
    private void populateNoiseMixin(WorldAccess world, StructureAccessor accessor, Chunk chunk, CallbackInfo ci) {
        this.world = world;
    }
}
