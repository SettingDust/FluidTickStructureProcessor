package settingdust.fluid_tick_structure_processor.v1_21.util

import net.minecraft.resources.ResourceLocation
import settingdust.fluid_tick_structure_processor.util.MinecraftAdapter

class MinecraftAdapter : MinecraftAdapter {
    override fun id(namespace: String, path: String) = ResourceLocation.fromNamespaceAndPath(namespace, path)
}