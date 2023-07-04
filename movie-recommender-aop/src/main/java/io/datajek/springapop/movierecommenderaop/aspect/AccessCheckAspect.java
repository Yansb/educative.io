package io.datajek.springapop.movierecommenderaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AccessCheckAspect {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* io.datajek.springapop.movierecommenderaop..*.*(String,..)) || execution(String io.datajek.springapop.movierecommenderaop..*.*(..))")
    public void userAccess(JoinPoint joinPoint) {
        logger.info("Allowed execution for {}", joinPoint);
    }
}
