package toffy.rogue_end.blocks;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import com.sun.jna.platform.win32.WinDef;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.*;
import org.jetbrains.annotations.Nullable;
import toffy.rogue_end.init.ModBlocks;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class YellowLichenBlock extends Block {
    public static final MapCodec<VineBlock> CODEC = createCodec(VineBlock::new);
    public static final BooleanProperty NORTH;
    public static final BooleanProperty EAST;
    public static final BooleanProperty SOUTH;
    public static final BooleanProperty WEST;
    public static final Map<Direction, BooleanProperty> FACING_PROPERTIES;
    protected static final float field_31275 = 1.0F;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape NORTH_SHAPE;
    private final Map<BlockState, VoxelShape> shapesByState;

    public MapCodec<VineBlock> getCodec() {
        return CODEC;
    }
    public YellowLichenBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)((BlockState)this.stateManager.getDefaultState())).with(NORTH, false)).with(EAST, false)).with(SOUTH, false)).with(WEST, false));
        this.shapesByState = ImmutableMap.copyOf((Map)this.stateManager.getStates().stream().collect(Collectors.toMap(Function.identity(), YellowLichenBlock::getShapeForState)));
    }

    private static VoxelShape getShapeForState(BlockState state) {
        VoxelShape voxelShape = VoxelShapes.empty();

        if ((Boolean)state.get(NORTH)) {
            voxelShape = VoxelShapes.union(voxelShape, SOUTH_SHAPE);
        }

        if ((Boolean)state.get(SOUTH)) {
            voxelShape = VoxelShapes.union(voxelShape, NORTH_SHAPE);
        }

        if ((Boolean)state.get(EAST)) {
            voxelShape = VoxelShapes.union(voxelShape, WEST_SHAPE);
        }

        if ((Boolean)state.get(WEST)) {
            voxelShape = VoxelShapes.union(voxelShape, EAST_SHAPE);
        }

        return voxelShape.isEmpty() ? VoxelShapes.fullCube() : voxelShape;
    }

    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return (VoxelShape)this.shapesByState.get(state);
    }
    protected boolean isTransparent(BlockState state, BlockView world, BlockPos pos) {
        return true;
    }

    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return (this.hasAdjacentBlocks(this.getPlacementShape(state, world, pos)) ||
                world.getBlockState(pos.down()).isOf(ModBlocks.YELLOWROOT_LICHEN));
    }

    private boolean hasAdjacentBlocks(BlockState state) {
        return this.getAdjacentBlockCount(state) > 0;
    }

    private int getAdjacentBlockCount(BlockState state) {
        int i = 0;
        if (state.get(FACING_PROPERTIES.get(Direction.NORTH))) {
            i++;
        }

        if (state.get(FACING_PROPERTIES.get(Direction.EAST))) {
            i++;
        }

        if (state.get(FACING_PROPERTIES.get(Direction.SOUTH))) {
            i++;
        }

        if (state.get(FACING_PROPERTIES.get(Direction.WEST))) {
            i++;
        }
        return i;
    }

    private boolean shouldHaveSide(BlockView world, BlockPos pos, Direction side) {
        if (side == Direction.UP||side == Direction.DOWN) {
            return false;
        } else {
            BlockPos blockPos = pos.offset(side);
            if (shouldConnectTo(world, blockPos, side)) {
                return true;
            } else if (side.getAxis() == Direction.Axis.Y) {
                return false;
            } else {
                BooleanProperty booleanProperty = (BooleanProperty)FACING_PROPERTIES.get(side);
                BlockState blockState = world.getBlockState(pos.down());
                return blockState.isOf(this) && (Boolean)blockState.get(booleanProperty);
            }
        }
    }

    public static boolean shouldConnectTo(BlockView world, BlockPos pos, Direction direction) {
        return MultifaceGrowthBlock.canGrowOn(world, direction, pos, world.getBlockState(pos));
    }

    private BlockState getPlacementShape(BlockState state, BlockView world, BlockPos pos) {
        BlockPos blockPos = pos.down();

        BlockState blockState = null;
        Iterator var6 = Direction.Type.HORIZONTAL.iterator();

        while(true) {
            Direction direction;
            BooleanProperty booleanProperty;
            do {
                if (!var6.hasNext()) {
                    return state;
                }

                direction = (Direction)var6.next();
                booleanProperty = getFacingProperty(direction);
            } while(!(Boolean)state.get(booleanProperty));

            boolean bl = this.shouldHaveSide(world, pos, direction);
            if (!bl) {
                if (blockState == null) {
                    blockState = world.getBlockState(blockPos);
                }

                bl = blockState.isOf(this) && (Boolean)blockState.get(booleanProperty);
            }

            state = (BlockState)state.with(booleanProperty, bl);
        }
    }
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    protected BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (!canPlaceAt(state, world, pos)) {
            world.scheduleBlockTick(pos, this, 1);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (random.nextInt(4) == 0) {
            if (world.isAir(pos.up())) {
                int i;
                for(i = 1; world.getBlockState(pos.down(i)).isOf(this); ++i) {
                }
                if (i < 15) {
                    world.setBlockState(pos.up(), (BlockState)state);
                }
            }
        }
    }

    protected boolean canReplace(BlockState state, ItemPlacementContext context) {
        BlockState blockState = context.getWorld().getBlockState(context.getBlockPos());
        if (blockState.isOf(this)) {
            return this.getAdjacentBlockCount(blockState) < FACING_PROPERTIES.size();
        } else {
            return super.canReplace(state, context);
        }
    }

    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockState blockState = ctx.getWorld().getBlockState(ctx.getBlockPos());
        boolean bl = blockState.isOf(this);
        BlockState blockState2 = bl ? blockState : this.getDefaultState();
        Direction[] var5 = ctx.getPlacementDirections();
        int var6 = var5.length;

        for (Direction direction : var5) {
            if (direction != Direction.DOWN&&direction != Direction.UP) {
                BooleanProperty booleanProperty = getFacingProperty(direction);
                boolean bl2 = bl && (Boolean) blockState.get(booleanProperty);
                if (!bl2 && this.shouldHaveSide(ctx.getWorld(), ctx.getBlockPos(), direction)) {
                    return (BlockState) blockState2.with(booleanProperty, true);
                }
            }
        }

        return bl ? blockState2 : null;
    }

    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(new Property[]{ NORTH, EAST, SOUTH, WEST});
    }

    protected BlockState rotate(BlockState state, BlockRotation rotation) {
        return switch (rotation) {
            case CLOCKWISE_180 ->
                    (BlockState) ((BlockState) ((BlockState) ((BlockState) state.with(NORTH, (Boolean) state.get(SOUTH))).with(EAST, (Boolean) state.get(WEST))).with(SOUTH, (Boolean) state.get(NORTH))).with(WEST, (Boolean) state.get(EAST));
            case COUNTERCLOCKWISE_90 ->
                    (BlockState) ((BlockState) ((BlockState) ((BlockState) state.with(NORTH, (Boolean) state.get(EAST))).with(EAST, (Boolean) state.get(SOUTH))).with(SOUTH, (Boolean) state.get(WEST))).with(WEST, (Boolean) state.get(NORTH));
            case CLOCKWISE_90 ->
                    (BlockState) ((BlockState) ((BlockState) ((BlockState) state.with(NORTH, (Boolean) state.get(WEST))).with(EAST, (Boolean) state.get(NORTH))).with(SOUTH, (Boolean) state.get(EAST))).with(WEST, (Boolean) state.get(SOUTH));
            default -> state;
        };
    }

    protected BlockState mirror(BlockState state, BlockMirror mirror) {
        return switch (mirror) {
            case LEFT_RIGHT ->
                    (BlockState) ((BlockState) state.with(NORTH, (Boolean) state.get(SOUTH))).with(SOUTH, (Boolean) state.get(NORTH));
            case FRONT_BACK ->
                    (BlockState) ((BlockState) state.with(EAST, (Boolean) state.get(WEST))).with(WEST, (Boolean) state.get(EAST));
            default -> super.mirror(state, mirror);
        };
    }

    public static BooleanProperty getFacingProperty(Direction direction) {
        return (BooleanProperty)FACING_PROPERTIES.get(direction);
    }

    static {
        NORTH = ConnectingBlock.NORTH;
        EAST = ConnectingBlock.EAST;
        SOUTH = ConnectingBlock.SOUTH;
        WEST = ConnectingBlock.WEST;
        FACING_PROPERTIES = ConnectingBlock.FACING_PROPERTIES.entrySet().stream().filter((entry) -> {
            return (entry.getKey() != Direction.UP && entry.getKey() != Direction.DOWN);
        }).collect(Util.toMap());
        EAST_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 1.0, 16.0, 16.0);
        WEST_SHAPE = Block.createCuboidShape(15.0, 0.0, 0.0, 16.0, 16.0, 16.0);
        SOUTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 0.0, 16.0, 16.0, 1.0);
        NORTH_SHAPE = Block.createCuboidShape(0.0, 0.0, 15.0, 16.0, 16.0, 16.0);
    }
}
