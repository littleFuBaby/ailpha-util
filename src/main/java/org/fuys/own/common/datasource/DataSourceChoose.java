package org.fuys.own.common.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceChoose {

	@Before(value="execution(public * org.fuys.own..*.*(..))")
	public void before(JoinPoint point) {
		Object target = point.getTarget();
		String method = point.getSignature().getName();
		Class<?>[] classz = target.getClass().getInterfaces();
		MethodSignature methodSignature = (MethodSignature) point.getSignature();
		Class<?>[] parameterTypes = methodSignature.getMethod().getParameterTypes();
		try {
			Method m = classz[0].getMethod(method, parameterTypes);
			if (m != null && m.isAnnotationPresent(DataSource.class)) {
				DataSource data = m.getAnnotation(DataSource.class);
				JdbcContextHolder.clearJdbcType();
				String name = data.value().getName();
				System.out.println("++++++++++++="+name);
				JdbcContextHolder.setJdbcType(name);
			}
		} catch (Exception e) {
		}
	}

}
