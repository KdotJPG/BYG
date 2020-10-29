package corgiaoc.byg.common.world.feature.overworld.trees.spruce.small;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.StructureWorldAccess;
import java.util.Random;
import java.util.Set;

public class SpruceTree2 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public SpruceTree2(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }

    protected boolean generate(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = config.getMinHeight() + rand.nextInt(config.getMaxPossibleHeight());
        BlockPos.Mutable mainmutable = new BlockPos.Mutable().set(pos);

        if (pos.getY() + randTreeHeight + 1 < worldIn.getHeight()) {
            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 7, 5, 5, isSapling)) {
                return false;
            } else {
                buildTrunkBase(changedBlocks, worldIn, config, rand, boundsIn, pos);

                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 0, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 1, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 2, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 3, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 4, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 11, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, 0), boundsIn);
                placeTrunk(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 13, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 6, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, 0), boundsIn);
                placeBranch(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 4, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 4, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 4, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 4, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 4, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 5, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 5, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 5, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 5, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 5, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 5, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 6, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 6, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 6, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 6, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 6, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 6, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 7, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 7, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 7, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 7, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 8, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 8, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 8, 3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 8, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 8, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-3, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 9, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 9, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, -3), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 9, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 9, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 9, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(3, 9, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 10, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, -2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 10, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 10, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 10, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 10, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 11, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 11, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 11, 2), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(2, 11, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-2, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 12, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(1, 12, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(-1, 13, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 13, -1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 13, 1), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 14, 0), boundsIn);
                placeLeaves(config, rand, changedBlocks, worldIn, mainmutable.set(pos).move(0, 15, 0), boundsIn);
            }
        }
        return true;
    }
}