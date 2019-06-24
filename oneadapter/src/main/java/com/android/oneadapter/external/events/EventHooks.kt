package com.android.oneadapter.external.events

import androidx.annotation.NonNull

sealed class EventHook<M>

abstract class ClickEventHook<M> : EventHook<M>() {
    companion object {
        val TAG: String = ClickEventHook::class.java.simpleName
    }

    abstract fun onClick(@NonNull model: M)
}