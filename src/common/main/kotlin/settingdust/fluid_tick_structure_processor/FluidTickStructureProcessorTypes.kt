package settingdust.fluid_tick_structure_processor

import com.mojang.serialization.MapCodec
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessor
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType
import settingdust.fluid_tick_structure_processor.processor.FluidTickProcessor

@Suppress("UNCHECKED_CAST")
object FluidTickStructureProcessorTypes {
    val FluidTick by lazy {
        BuiltInRegistries.STRUCTURE_PROCESSOR.get(FluidTickStructureProcessorKeys.FluidTick) as StructureProcessorType<FluidTickProcessor>
    }

    fun register(register: (ResourceLocation, MapCodec<out StructureProcessor>) -> Unit) {
        register(FluidTickStructureProcessorKeys.FluidTick, FluidTickProcessor.MAP_CODEC)
    }
}