/*
package com.it;

*/
/**
 * to do
 *
 * @author Hj
 * @date 2021/8/9
 *//*

@Component
@Aspect
public class AnnotationAspect {

    //这里将自定义注解作为形参，@annotation可直接使用形参引入
    @Around("@annotation(leo)")
    public Object doAround(ProceedingJoinPoint pjp , LeopardAnno leo) throws Throwable{
        System.out.println(leo.key());
        System.out.println(leo.recodeLog());
        System.out.println("-------开始拦截");
        System.out.println("类路径名："+pjp.getSourceLocation().getWithinType().getName());
        System.out.println("方法名："+pjp.getSignature().getName());
        Object proceed = pjp.proceed();
        System.out.println("-------结束拦截");
        return proceed;
    }
}
*/
