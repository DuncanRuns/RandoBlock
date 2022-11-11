package me.duncanruns.randoblock.mixin;

import me.duncanruns.randoblock.RandoBlock;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.chunk.SurfaceChunkGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(SurfaceChunkGenerator.class)
public class SurfaceChunkGeneratorMixin {
    @Inject(method = "getBlockState", at = @At("HEAD"), cancellable = true)
    private void getBlockStateMixin(double density, int y, CallbackInfoReturnable<BlockState> info) {
        if (density > 0.0D)
            info.setReturnValue(RandoBlock.randomBlock());
    }
}
