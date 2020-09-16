package voronoiaoc.byg.common.world.feature.features.overworld.trees.skyris;

import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.IWorldGenerationBaseReader;
import voronoiaoc.byg.common.world.feature.config.BYGTreeFeatureConfig;
import voronoiaoc.byg.common.world.feature.features.overworld.trees.util.BYGAbstractTreeFeature;

import java.util.Random;
import java.util.Set;

public class SkyrisTree extends BYGAbstractTreeFeature<BYGTreeFeatureConfig> {
    //BYGBlockRenders used for the tree.
    //private static final BlockState LOG = BYGBlockList.SKYRIS_LOG.getDefaultState();
    //private static final BlockState LEAVES = BYGBlockList.SKYRIS_LEAVES.getDefaultState();
    //private static final BlockState LEAVES2 = BYGBlockList.SKYRIS_LEAVES_GREEN_APPLE.getDefaultState();
    private static final BlockState BEENEST = Blocks.BEE_NEST.getDefaultState();
    Random random = new Random();

    public SkyrisTree(Codec<BYGTreeFeatureConfig> configIn) {
        super(configIn);
        //setSapling((net.minecraftforge.common.IPlantable) BYGBlockList.SKYRIS_SAPLING);
    }


    public boolean place(Set<BlockPos> changedBlocks, ISeedReader worldIn, Random rand, BlockPos pos, MutableBoundingBox boundsIn, boolean isSapling, BYGTreeFeatureConfig config) {
        BlockState LOG = config.getTrunkProvider().getBlockState(rand, pos);
        BlockState LEAVES = config.getLeavesProvider().getBlockState(rand, pos);
        int randTreeHeight = rand.nextInt(2) + 6;
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY >= 1 && posY + randTreeHeight + 1 < 256) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), Blocks.GRASS_BLOCK)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {


                Direction direction = Direction.Plane.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;
                int topTrunkHeight2 = posY + randTreeHeight + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getXOffset();
                        posZ1 += direction.getZOffset();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);
                    BlockPos blockpos2 = new BlockPos(posX1, logplacer2, posZ1);

                    //Sets Logs
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos1, boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos1.south().east().up(randTreeHeight - 2), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north().down(), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.north(2), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east(2).south().up(randTreeHeight - 4), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east(3).south().up(randTreeHeight - 3), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.east(4).south().up(randTreeHeight - 2), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.south().up(randTreeHeight - 2), boundsIn);
                    placeTrunk(LOG, changedBlocks, worldIn, blockpos2.west(), boundsIn);

                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        int posX2 = posX1 + 1;
                        int posZ2 = posZ1 + 1;

//                        placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        //Top Leaves
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafWidth + 2, topTrunkHeight2 - 1, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafWidth - 2, topTrunkHeight2 - 1, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight2 - 1, posZ2 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight2 - 1, posZ2 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //Bottom Leaves
                        placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth - 2, topTrunkHeight + 1, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 + 1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 1, posZ1 + posZLeafWidthL0 - 1, boundsIn, changedBlocks);

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                            placeLeaves(LEAVES, worldIn, posX2 + posXLeafWidth + 4, topTrunkHeight2 - 1, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(LEAVES, worldIn, posX2 + posXLeafWidth - 1, topTrunkHeight2, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);

                            placeLeaves(LEAVES, worldIn, posX1 + posXLeafWidth - 1, topTrunkHeight + 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {
                            placeLeaves(LEAVES, worldIn, posX2 + posXLeafWidth + 3, topTrunkHeight2, posZ2 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //Top Leaves
                        placeLeaves(LEAVES, worldIn, posX2 + 4, topTrunkHeight2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 + 1, topTrunkHeight2, posZ2, boundsIn, changedBlocks);

                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight2, posZ2 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 3, topTrunkHeight2, posZ2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX2 - 1, topTrunkHeight2, posZ2 - 2, boundsIn, changedBlocks);

                        //Bottom Leaves
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight + 2, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 3, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 + 1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1 - 1, topTrunkHeight + 2, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(LEAVES, worldIn, posX1, topTrunkHeight + 2, posZ1 - 2, boundsIn, changedBlocks);
                    }
                }
            }

            return true;
            //}
        } else {
            return false;
        }
    }

    private boolean doesTreeFit(IWorldGenerationBaseReader reader, BlockPos blockPos, int height) {
        int x = blockPos.getX();
        int y = blockPos.getY();
        int z = blockPos.getZ();
        BlockPos.Mutable pos = new BlockPos.Mutable();

        for (int yOffset = 0; yOffset <= height + 1; ++yOffset) {
            //Distance/Density of trees. Positive Values ONLY
            int distance = 4;

            for (int xOffset = -distance; xOffset <= distance; ++xOffset) {
                for (int zOffset = -distance; zOffset <= distance; ++zOffset) {
                    if (!canLogPlaceHere(reader, pos.setPos(x + xOffset, y + yOffset, z + zOffset))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }


    private void leafs(ISeedReader reader, int x, int y, int z, MutableBoundingBox boundingBox, Set<BlockPos> blockPos) {
        BlockPos blockpos = new BlockPos(x, y, z);
        if (isAir(reader, blockpos)) {
            this.setFinalBlockState(blockPos, reader, blockpos, this.randomizer(), boundingBox);
        }

    }

    private BlockState randomizer() {
        return (random.nextInt(25) == 0) ? LEAVES2 : LEAVES;
    }
}