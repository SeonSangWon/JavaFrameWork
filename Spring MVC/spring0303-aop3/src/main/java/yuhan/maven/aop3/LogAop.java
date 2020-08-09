package yuhan.maven.aop3;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogAop {

	@Pointcut("within(yuhan.maven.aop3.*)")
	private void PointCutMethod() {
		
	}
	
	@Around("PointCutMethod()")
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		String signatrureStr = joinpoint.getSignature().toLongString();
		
		System.out.println(signatrureStr + "is Start");
		long st = System.currentTimeMillis();
		
		try {
			Object obj = joinpoint.proceed();
			
			return joinpoint;
		}finally {
			//End Time
			long et = System.currentTimeMillis();
			
			System.out.println(signatrureStr + "is Finished");
			System.out.println(signatrureStr + "경과시간 : " + (et-st));
		}
	}
}
