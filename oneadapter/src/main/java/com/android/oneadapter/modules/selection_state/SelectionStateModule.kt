package com.android.oneadapter.modules.selection_state

abstract class SelectionStateModule {

    abstract fun provideModuleConfig(builder: SelectionModuleConfig.Builder): SelectionModuleConfig
    open fun onSelectionUpdated(selectedCount: Int) {}
}