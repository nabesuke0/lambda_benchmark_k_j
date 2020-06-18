package jp.co.valus.lambda_benchmark;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.UUID;
import java.util.stream.LongStream;

public class JavaBenchmarkHandler implements RequestHandler<Object, Object> {

    static long maxLoopNum = Long.parseLong(System.getenv("max_loop_num"));

    @Override
    public Object handleRequest(Object input, Context context) {
        LambdaLogger logger = context.getLogger();

        logger.log("================ start ================");
        long startTime = System.currentTimeMillis();

        LongStream.range(0, maxLoopNum).forEach(i ->
                UUID.randomUUID().toString()
        );

        long endTime = System.currentTimeMillis();


        logger.log(String.format("loop count = %d measureTimeMillis = %d", maxLoopNum, endTime - startTime));

        logger.log("================  end  ================");

        return 1;
    }
}
