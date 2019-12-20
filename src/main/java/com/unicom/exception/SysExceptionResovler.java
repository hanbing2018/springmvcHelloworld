package com.unicom.exception;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author hanbing
 * @create 2019-09-09 18:30
 */
public class SysExceptionResovler implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
//        SysException se = null;
//        if (e instanceof SysException){
//            se = (SysException) e;
//        }else {
//            se = new SysException("系统错误");
//        }
        ModelAndView mv = new ModelAndView("error");
        mv.addObject("errormsg", e.getMessage());
        System.out.println(e.getMessage());
        return mv;
    }
}
