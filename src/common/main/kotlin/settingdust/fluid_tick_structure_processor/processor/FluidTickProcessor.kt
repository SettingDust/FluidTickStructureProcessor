package settingdust.fluid_tick_structure_processor.processor

import com.mojang.serialization.MapCodec
import net.minecraft.core.BlockPos
import net.minecraft.world.level.LevelAccessor
import net.minecraft.world.level.LevelReader
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate
import settingdust.fluid_tick_structure_processor.FluidTickStructureProcessorTypes

object FluidTickProcessor : StructureProcessor() {
    val MAP_CODEC = MapCodec.unit(FluidTickProcessor)

    override fun getType() = FluidTickStructureProcessorTypes.FluidTick

    override fun processBlock(
        level: LevelReader,
        offset: BlockPos,
        pos: BlockPos,
        blockInfo: StructureTemplate.StructureBlockInfo,
        relativeBlockInfo: StructureTemplate.StructureBlockInfo,
        settings: StructurePlaceSettings
    ): StructureTemplate.StructureBlockInfo {
        if (level !is LevelAccessor || relativeBlockInfo.state().fluidState.isEmpty) return relativeBlockInfo
        level.scheduleTick(relativeBlockInfo.pos(), relativeBlockInfo.state().fluidState.type, 0)
        return relativeBlockInfo
    }
}