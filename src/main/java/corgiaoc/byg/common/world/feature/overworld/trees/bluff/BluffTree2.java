package corgiaoc.byg.common.world.feature.overworld.trees.bluff;

import com.mojang.serialization.Codec;
import corgiaoc.byg.common.world.feature.config.BYGTreeConfig;
import corgiaoc.byg.common.world.feature.overworld.trees.util.BYGAbstractTreeFeature;
import net.minecraft.util.math.BlockBox;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.StructureWorldAccess;
import java.util.Random;
import java.util.Set;

public class BluffTree2 extends BYGAbstractTreeFeature<BYGTreeConfig> {

    public BluffTree2(Codec<BYGTreeConfig> configIn) {
        super(configIn);
    }


    public boolean generate(Set<BlockPos> changedBlocks, StructureWorldAccess worldIn, Random rand, BlockPos pos, BlockBox boundsIn, boolean isSapling, BYGTreeConfig config) {

        int randTreeHeight = rand.nextInt(config.getMaxPossibleHeight()) + config.getMinHeight();
        //Positions
        int posX = pos.getX();
        int posY = pos.getY();
        int posZ = pos.getZ();
        if (posY + randTreeHeight + 1 < worldIn.getHeight()) {

            if (!isDesiredGroundwDirtTag(worldIn, pos.down(), config)) {
                return false;
            } else if (!this.isAnotherTreeNearby(worldIn, pos, randTreeHeight, 0, isSapling)) {
                return false;
            } else if (!this.doesSaplingHaveSpaceToGrow(worldIn, pos, randTreeHeight, 5, 5, 5, isSapling)) {
                return false;
            } else {
                buildTrunkBase(changedBlocks, worldIn, config, rand, boundsIn, pos);

                //this.setGroundBlockAt(worldIn, blockpos, pos, Blocks.STONE.getDefaultState());
                Direction direction = Direction.Type.HORIZONTAL.random(rand);
                int randTreeHeight2 = randTreeHeight - rand.nextInt(1);
                int posY1 = 2 - rand.nextInt(1);
                int posX1 = posX;
                int posZ1 = posZ;
                int topTrunkHeight = posY + randTreeHeight - 1;


                for (int buildTrunk = 0; buildTrunk < randTreeHeight; ++buildTrunk) {
                    if (buildTrunk >= randTreeHeight2 && posY1 < 0) {
                        posX1 += direction.getOffsetX();
                        posZ1 += direction.getOffsetZ();
                        ++posY1;
                    }

                    int logplacer = posY + buildTrunk;
                    int logplacer2 = posY + randTreeHeight;
                    BlockPos blockpos1 = new BlockPos(posX1, logplacer, posZ1);

                    //Sets Logs
                    placeTrunk(config, rand, changedBlocks, worldIn, blockpos1, boundsIn);


                }


                int leavessquarespos = 2;
                for (int posXLeafWidth = -leavessquarespos; posXLeafWidth <= leavessquarespos; ++posXLeafWidth) {//has to do with leaves
                    for (int posZLeafWidthL0 = -leavessquarespos; posZLeafWidthL0 <= leavessquarespos; ++posZLeafWidthL0) {

                        //3x3
                        if (posXLeafWidth <= 1 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 2, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 4, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 6, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 8, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 10, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 12, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                            placeLeaves(config, rand, worldIn, posX1 + posXLeafWidth, topTrunkHeight - 14, posZ1 + posZLeafWidthL0, boundsIn, changedBlocks);
                        }

                        //2x3
                        if (posXLeafWidth <= 0 && posZLeafWidthL0 <= 1 && posZLeafWidthL0 >= -1 && posXLeafWidth >= -1) {

                        }

                        //Bottom Leaves
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight + 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight + 1, posZ1 + 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 1, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 1, posZ1 + 1, boundsIn, changedBlocks);
                        //---

                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 2, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 2, posZ1 + 2, boundsIn, changedBlocks);

                        //------
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 3, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 3, posZ1 + 1, boundsIn, changedBlocks);
                        //--

                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 4, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 4, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 4, posZ1 + 2, boundsIn, changedBlocks);

                        //--
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 5, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 5, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 5, posZ1 + 1, boundsIn, changedBlocks);
                        //---

                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 6, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 6, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 6, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 6, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 6, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 6, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 6, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 6, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 6, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 6, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 6, posZ1 + 2, boundsIn, changedBlocks);

                        //------
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 7, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 7, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 7, posZ1 + 1, boundsIn, changedBlocks);
                        //--

                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 8, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 8, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 8, posZ1 + 2, boundsIn, changedBlocks);

                        //--
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 9, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 9, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 9, posZ1 + 1, boundsIn, changedBlocks);
                        //---

                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 10, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 10, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 10, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 10, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 10, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 10, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 10, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 10, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 10, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 10, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 10, posZ1 + 2, boundsIn, changedBlocks);

                        //------
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 11, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 11, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 11, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 11, posZ1 + 1, boundsIn, changedBlocks);

                        //--

                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 12, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 12, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 12, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 12, posZ1 + 2, boundsIn, changedBlocks);

                        //--

                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 13, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 13, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 13, posZ1 - 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 13, posZ1 + 1, boundsIn, changedBlocks);
                        //---

                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 14, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 14, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 2, topTrunkHeight - 14, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 14, posZ1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 14, posZ1 + 1, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 2, topTrunkHeight - 14, posZ1 - 1, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 14, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 14, posZ1 - 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 14, posZ1 - 2, boundsIn, changedBlocks);

                        placeLeaves(config, rand, worldIn, posX1, topTrunkHeight - 14, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 + 1, topTrunkHeight - 14, posZ1 + 2, boundsIn, changedBlocks);
                        placeLeaves(config, rand, worldIn, posX1 - 1, topTrunkHeight - 14, posZ1 + 2, boundsIn, changedBlocks);

                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }
}