package io.datajek.springapop.movierecommenderaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @After("io.datajek.springapop.movierecommenderaop.aspect.JoinPointConfig.dataLayerPointcut()")
    public void LogAfterException(JoinPoint joinPoint) {
        logger.info("Method executed {}", joinPoint);
    }

}
