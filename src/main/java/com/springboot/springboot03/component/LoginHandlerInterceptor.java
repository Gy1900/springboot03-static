package com.springboot.springboot03.component;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by gy on 2019/5/30 0030 19:53
 * 获取loginUser，是否为null
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        Object s = request.getSession().getAttribute("loginUser");
//        if (s == null) {
//            request.setAttribute("msg", "请先登录");
////           request.getRequestDispatcher("index") -把模板给转发器
//            request.getRequestDispatcher("index").forward(request, response);
////            内部：
////            RequestDispatcher.class getRequestDispatcher(String path)但是在处理过程中是mv
////            Request.class中 context.getServletContext().getRequestDispatcher(relative); relative -/index
////            DispatcherServlet.class中 函数render(ModelAndView mv,XXX)，mv-index
//            return false;
//        } else {
            return true;
//        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
