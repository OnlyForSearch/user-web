package cn.fengyu.ssm.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author fengyu
 * @since 2016-01-22
 */
public class AppExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        AppException customException = null;
        if (ex instanceof AppException)
            customException = (AppException) ex;
        else
            customException = new AppException("系统繁忙，此时请稍候再试!", -1);

        ModelAndView modelAndView = new ModelAndView();
        //将错误信息传到页面
        modelAndView.addObject("errMsg", customException.getMessage());
        modelAndView.addObject("errCode", customException.getErrCode());
        //指向错误页面
        //  modelAndView.setViewName("error");


        return modelAndView;
    }
}
