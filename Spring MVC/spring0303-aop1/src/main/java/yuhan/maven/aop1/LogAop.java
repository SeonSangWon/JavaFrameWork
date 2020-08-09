package yuhan.maven.aop1;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAop {
	
	public Object loggerAop(ProceedingJoinPoint joinpoint) throws Throwable {
		
		//호출되는 정보 자체를 가져옴
		//String signatrureStr = joinpoint.getSignature().toLongString();
		String signatrureStr = joinpoint.getSignature().toShortString();
		
		System.out.println(signatrureStr + "is Start");
		
		//현재 시스템 시간 구하기
		//Start Time
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
