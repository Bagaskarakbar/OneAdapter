package com.android.oneadapter.modules.selection_state

import com.android.oneadapter.utils.MissingBuilderArgumentException

class SelectionModuleConfig private constructor(
        var selectionType: SelectionType
) {

    class Builder {
        private var selectionType: SelectionType? = null

        fun withSelectionType(selectionType: SelectionType): Builder {
            this.selectionType = selectionType
            return this
        }

        fun build(): SelectionModuleConfig {
            selectionType?.let { selectionType ->
                return SelectionModuleConfig(selectionType)
            } ?: throw MissingBuilderArgumentException("SelectionModuleBuilder missing selection type")
        }
    }
}

enum class SelectionType {
    Single, Multiple
}