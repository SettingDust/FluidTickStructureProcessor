package settingdust.fluid_tick_structure_processor.forge

import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import settingdust.fluid_tick_structure_processor.FluidTickStructureProcessor
import settingdust.fluid_tick_structure_processor.util.Entrypoint
import thedarkcolour.kotlinforforge.forge.MOD_BUS

@Mod(FluidTickStructureProcessor.ID)
object FluidTickStructureProcessorForge {
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