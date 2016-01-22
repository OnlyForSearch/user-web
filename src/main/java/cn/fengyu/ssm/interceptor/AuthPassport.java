package cn.fengyu.ssm.interceptor;

import java.lang.annotation.*;

/**自定义注解AuthPassport权限
 * @author Administrator
 *
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthPassport {
	boolean validate() default true;
}