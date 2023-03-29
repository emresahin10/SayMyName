package com.emresahin.saymyname.common.initializer

import android.content.Context
import androidx.startup.Initializer
import com.skydoves.only.Only

class OnlyInitializer : Initializer<Unit> {
    override fun create(context: Context) {
        Only.init(context)
    }

    override fun dependencies() = emptyList<Class<out Initializer<*>>>()
}
