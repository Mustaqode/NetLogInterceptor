package dev.mustaq.netloginterceptor

import android.content.Context
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.File
import java.lang.Exception
import java.util.concurrent.TimeUnit

/**
 * Created by Mustaq Sameer on 11/06/20
 */

class NetLogInterceptor : Interceptor {

    private val context: Context? = NetLog.context

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val requestTime = System.nanoTime()
        val response = chain.proceed(request)
        val responseTime = System.nanoTime()
        callog(request, response, requestTime, responseTime)
        return response
    }

    private fun callog(
        request: Request,
        response: Response,
        requestTime: Long,
        responseTime: Long
    ) {
        val url = request.url.toString()
        val headers = request.headers.toList()
        val code = response.code.toString()
        val totalResponseTimeInMs = responseTime - requestTime
        val totalResponseTime = TimeUnit.NANOSECONDS.toMillis(totalResponseTimeInMs)
        val divider = "\n\n............................."
        var header = ""
        headers.forEach { (type, value) ->
            header = "$header \n$type : $value"
        }
        val log =
            "\n $url \nresponseCode:$code \ntotalTime:$totalResponseTime \nheaders: \n$header $divider"

        try {
            val path = context?.getExternalFilesDir(null)
            val directory = File(path, "NetLog")
            if (!directory.exists())
                directory.mkdirs()
            val file = File(directory, "NetLog.txt")
            file.appendText(log)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}


