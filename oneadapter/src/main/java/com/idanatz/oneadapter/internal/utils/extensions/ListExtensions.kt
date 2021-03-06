package com.idanatz.oneadapter.internal.utils.extensions

import com.idanatz.oneadapter.external.interfaces.Diffable

internal fun <T : Diffable, M : Diffable> MutableList<T>.removeClassIfExist(classToRemove: Class<M>) {
    findIndexOfClass(classToRemove)?.let { foundIndex -> removeAt(foundIndex) }
}

internal fun <T : Diffable, M : Diffable> MutableList<T>.findIndexOfClass(classToFind: Class<M>): Int? {
    return indexOfFirst { classToFind.isInstance(it) }.takeIf { it != -1 }
}

internal fun <T : Diffable, M : Diffable> MutableList<T>.isClassExists(classToFind: Class<M>): Boolean {
    return indexOfFirst { classToFind.isInstance(it) } != -1
}

internal fun <T : Diffable> MutableList<T>.removeAllItems(itemsToRemove: List<T>) {
    itemsToRemove.forEach { removeAt(getIndexOfItem(it)) }
}

internal fun <T : Diffable> List<T>.getIndexOfItem(itemToFind: T): Int {
    return indexOfFirst { item ->
        when (item.javaClass == itemToFind.javaClass) {
            true -> item.getUniqueIdentifier() == itemToFind.getUniqueIdentifier()
            false -> false
        }
    }
}