package settingdust.fluid_tick_structure_processor

import org.apache.logging.log4j.LogManager
import settingdust.fluid_tick_structure_processor.util.MinecraftAdapter
import settingdust.fluid_tick_structure_processor.util.ServiceLoaderUtil

object FluidTickStructureProcessor {
    const val ID = "fluid_tick_structure_processor"

    val LOGGER = LogManager.getLogger()

    init {
        ServiceLoaderUtil.defaultLogger = LOGGER
    }

    fun id(path: String) = MinecraftAdapter.id(ID, path)
}