package by.study.news.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.apache.log4j.Logger;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger LOGGER_A = Logger.getLogger("A");
	private static final Logger LOGGER_B = Logger.getLogger("B");

	
	//@Before ("execution(public * *(..))")
	//@Before("execution(* handleError*(..))")
	//@Before("execution(* by.study.news.controller.ExceptionController.handleError(..))")
	@Before("execution(* by.study.news.dao.impl.NewsDAOImpl.save(..))")
	//@Before("execution(public String handleError(..))")

	public void beforeHandlingException(JoinPoint theJoinPoint) {

		System.out.println("entered LoggingAspect.beforeHandlingException() ");
		
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		System.out.println(methodSig);

		
		Object[] args = theJoinPoint.getArgs();

		for (Object tempArg : args) {
			
			if (tempArg.toString().toLowerCase().contains("exception") == true) {
			// logger A (to console)
			LOGGER_A.warn(tempArg.toString());
			// logger B (to file)
			LOGGER_B.warn(tempArg.toString());
			}
		}
	
		
	}
}
