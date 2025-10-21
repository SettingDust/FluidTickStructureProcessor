package settingdust.fluid_tick_structure_processor.neoforge.util

import net.neoforged.fml.loading.FMLLoader
import net.neoforged.fml.loading.LoadingModList
import settingdust.fluid_tick_structure_processor.util.LoaderAdapter

class LoaderAdapter : LoaderAdapter {
    override val isClient: Boolean
        get() = FMLLoader.getDist().isClient

    override fun isModLoaded(modId: String) = LoadingModList.get().getModFileById(modId) != null
}