package settingdust.fluid_tick_structure_processor.util

import com.mojang.serialization.MapCodec
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType

interface StructureProcessorTypeAdapter {
    companion object : StructureProcessorTypeAdapter by ServiceLoaderUtil.findService()

    fun <T : StructureProcessor> createFromMapCodec(codec: MapCodec<T>): StructureProcessorType<T>
}