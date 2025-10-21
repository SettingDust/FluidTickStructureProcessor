package settingdust.fluid_tick_structure_processor.neoforge

import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import settingdust.fluid_tick_structure_processor.FluidTickStructureProcessor
import settingdust.fluid_tick_structure_processor.util.Entrypoint
import thedarkcolour.kotlinforforge.neoforge.forge.MOD_BUS

@Mod(FluidTickStructureProcessor.ID)
object FluidTickStructureProcessorNeoForge {
    init {
        requireNotNull(FluidTickStructureProcessor)
        Entrypoint.construct()
        MOD_BUS.apply {
            addListener<FMLCommonSetupEvent> {
                Entrypoint.init()
            }
            addListener<FMLClientSetupEvent> { Entrypoint.clientInit() }
        }
    }
}