package com.idanatz.oneadapter.tests.module_configs.layout_module_config

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.idanatz.oneadapter.external.modules.ItemModule
import com.idanatz.oneadapter.external.modules.ItemModuleConfig
import com.idanatz.oneadapter.helpers.BaseTest
import com.idanatz.oneadapter.internal.holders.ViewBinder
import com.idanatz.oneadapter.internal.validator.MissingConfigArgumentException
import com.idanatz.oneadapter.models.TestModel1
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class InvalidLayoutResourceShouldThrowException : BaseTest() {

    @Test(expected = MissingConfigArgumentException::class)
    fun test() {
        val itemModule = object : ItemModule<TestModel1>() {
            override fun provideModuleConfig() = object : ItemModuleConfig() {
                override fun withLayoutResource() = INVALID_RESOURCE
            }

            override fun onBind(model: TestModel1, viewBinder: ViewBinder) {}
        }

        oneAdapter.attachItemModule(itemModule)
    }
}