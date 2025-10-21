package settingdust.fluid_tick_structure_processor.fabric

import settingdust.fluid_tick_structure_processor.FluidTickStructureProcessor
import settingdust.fluid_tick_structure_processor.util.Entrypoint

object FluidTickStructureProcessorFabric {
    init {
        requireNotNull(FluidTickStructureProcessor)
        Entrypoint.construct()
    }

    fun init() {
        Entrypoint.init()
    }

    fun clientInit() {
        Entrypoint.clientInit()
    }
}
