package ca.fxco.RailOptimization.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public interface PoweredRailBlockInvoker {

    boolean invokeFindPoweredRailSignal(Level level, BlockPos pos, BlockState state, boolean bl, int distance);
}
