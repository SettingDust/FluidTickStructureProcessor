package settingdust.fluid_tick_structure_processor.fabric

import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import settingdust.fluid_tick_structure_processor.FluidTickStructureProcessor
import settingdust.fluid_tick_structure_processor.FluidTickStructureProcessorTypes
import settingdust.fluid_tick_structure_processor.util.Entrypoint
import settingdust.fluid_tick_structure_processor.util.StructureProcessorTypeAdapter

object FluidTickStructureProcessorFabric {
    init {
        requireNotNull(FluidTickStructureProcessor)
        Entrypoint.construct()
    }

    fun init() {
        FluidTickStructureProcessorTypes.register { id, codec ->
            Registry.register(
                BuiltInRegistries.STRUCTURE_PROCESSOR,
                id,
                StructureProcessorTypeAdapter.createFromMapCodec(codec)
            )
        }

        Entrypoint.init()
    }

    fun clientInit() {
        Entrypoint.clientInit()
    }
}
