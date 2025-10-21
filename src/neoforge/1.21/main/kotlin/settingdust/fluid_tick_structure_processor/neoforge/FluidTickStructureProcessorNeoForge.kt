package settingdust.fluid_tick_structure_processor.neoforge

import net.minecraft.core.registries.Registries
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.neoforge.registries.RegisterEvent
import settingdust.fluid_tick_structure_processor.FluidTickStructureProcessor
import settingdust.fluid_tick_structure_processor.FluidTickStructureProcessorTypes
import settingdust.fluid_tick_structure_processor.util.Entrypoint
import settingdust.fluid_tick_structure_processor.util.StructureProcessorTypeAdapter
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
            addListener<RegisterEvent> { event ->
                when (event.registryKey) {
                    Registries.STRUCTURE_PROCESSOR -> FluidTickStructureProcessorTypes.register { id, value ->
                        event.register(
                            Registries.STRUCTURE_PROCESSOR,
                            id
                        ) { StructureProcessorTypeAdapter.createFromMapCodec(value) }
                    }
                }
            }
        }
    }
}