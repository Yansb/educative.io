package io.datajek.springapop.movierecommenderaop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class ExecutionTimeAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Around("io.datajek.springapop.movierecommenderaop.aspect.JoinPointConfig.measureTimeAnnotation()")
    public Object calculateExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();

        Object returnValue = proceedingJoinPoint.proceed();

        long timeTaken = System.currentTimeMillis() - startTime;

        logger.info("Time taken by {} to complete execution is {}", proceedingJoinPoint, timeTaken);
        return returnValue;
    }
}
