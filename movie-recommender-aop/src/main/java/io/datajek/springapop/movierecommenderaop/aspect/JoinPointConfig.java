package io.datajek.springapop.movierecommenderaop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class JoinPointConfig {
    @Pointcut("execution(* io.datajek.springapop.movierecommenderaop.data.*.*(..))")
    public void dataLayerPointcut() {
    }

    @Pointcut("execution(* io.datajek.springapop.movierecommenderaop.busines.*.*(..))")
    public void businessLayerPointcut() {
    }

    @Pointcut("io.datajek.springapop.movierecommenderaop.aspect.JoinPointConfig.dataLayerPointcut() || "
            + "io.datajek.springapop.movierecommenderaop.aspect.JoinPointConfig.businessLayerPointcut()")
    public void allLayersPointcut() {
    }

    @Pointcut("bean(movie*)")
    public void movieBeanPointcut() {
    }

    @Pointcut("@annotation(io.datajek.springapop.movierecommenderaop.aspect.MeasureTime)")
    public void measureTimeAnnotation() {
    }
}
