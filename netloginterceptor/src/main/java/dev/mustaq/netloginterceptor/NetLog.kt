package dev.mustaq.netloginterceptor

import android.content.Context

/**
 * Created by Mustaq Sameer on 11/06/20
 */

object NetLog {
    var context: Context? = null
    fun init(context: Context) {
        this.context = context
    }
}