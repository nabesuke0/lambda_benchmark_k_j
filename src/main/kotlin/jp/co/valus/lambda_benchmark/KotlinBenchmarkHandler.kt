package jp.co.valus.lambda_benchmark

import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestHandler
import java.util.*
import kotlin.system.measureTimeMillis

class KotlinBenchmarkHandler : RequestHandler<Any, Any> {
    companion object {
        private val maxLoopNum = System.getenv("max_loop_num").toLong()
    }

    override fun handleRequest(input: Any?, context: Context?): Any {
        val logger = context?.logger

        logger?.log("================ start ================")
        val execMillis = measureTimeMillis {
            (1..maxLoopNum).forEach { _ ->
                UUID.randomUUID().toString()
            }
        }

        logger?.log("loop count = $maxLoopNum measureTimeMillis = $execMillis")

        logger?.log("================  end  ================")

        return 1
    }
}