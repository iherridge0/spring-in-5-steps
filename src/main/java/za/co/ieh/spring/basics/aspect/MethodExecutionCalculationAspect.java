package za.co.ieh.spring.basics.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

	Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Around("execution(* za.co.ieh.spring.basics.basic.*.*(..))")
	public void aound(ProceedingJoinPoint joinPoint) throws Throwable {
		long startTime = System.currentTimeMillis();
		joinPoint.proceed();
		long timeTaken = System.currentTimeMillis() - startTime;
		log.info("Time Taken by {} is {}", joinPoint, timeTaken);
	}
}
