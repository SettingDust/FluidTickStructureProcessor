package settingdust.fluid_tick_structure_processor.v1_20.util

import com.mojang.serialization.MapCodec
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType
import settingdust.fluid_tick_structure_processor.util.StructureProcessorTypeAdapter

class StructureProcessorTypeAdapter : StructureProcessorTypeAdapter {
    override fun <T : StructureProcessor> createFromMapCodec(
        codec: MapCodec<T>
    ): StructureProcessorType<T> {
        val codec = codec.codec()
        return StructureProcessorType<T> { codec }
    }
}