package com.cxg.eip.controller.interceptor;

import com.cxg.eip.model.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    // 在处理请求的目标 handler 方法前执行preHandle
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        if (user!=null){
            return true;
        }else {
            session.setAttribute("loginmsg","请先登录！");
            response.sendRedirect("/login");
            return true;
        }
    }
    // 在目标 handler 方法之后，渲染视图之前postHandle
    // 渲染视图之后执行afterCompletion
}
