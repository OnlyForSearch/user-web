package cn.fengyu.ssm.interceptor;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author fengyu
 * @since 2016-01-22
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            AuthPassport authPassport = ((HandlerMethod) handler)
                    .getMethodAnnotation(AuthPassport.class);
            // 没有声明需要权限,或者声明不验证权限
            if (authPassport == null || !authPassport.validate())
                return true;
            else {
                // 在这里实现自己的权限验证逻辑
                // 如果验证成功返回true（这里直接写false来模拟验证失败的处理）
                HttpSession session = request.getSession();
                String username = (String) session.getAttribute("username");
                if (username != null) {
                    return true;
                }
                //执行这里表示用户身份需要认证，跳转登陆页面
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            }
        }


        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler, Exception ex)
            throws Exception {


    }
}
