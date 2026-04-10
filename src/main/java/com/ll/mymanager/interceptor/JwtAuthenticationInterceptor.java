package com.ll.mymanager.interceptor;


import com.ll.mymanager.pojo.ApiResponse;
import com.ll.mymanager.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import tools.jackson.databind.ObjectMapper;

@Slf4j
@Component
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    private static final String TOKEN_PREFIX = "Bearer ";
    private static final String AUTH_HEADER = "Authorization";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        String authHeader = request.getHeader(AUTH_HEADER);

        if (authHeader == null || !authHeader.startsWith(TOKEN_PREFIX)) {
            log.warn("请求路径: {}, 缺少或无效的Authorization头", request.getRequestURI());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            ApiResponse<Void> result = ApiResponse.error(401,"未登录，请先登录");
            response.getWriter().write(new ObjectMapper().writeValueAsString(result));
            return false;
        }

        String token = authHeader.substring(TOKEN_PREFIX.length());

        try {
            JwtUtils.validateToken(token);
            return true;

        } catch (Exception e) {
            log.error("Token验证失败: {}", e.getMessage());
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.setContentType("application/json;charset=UTF-8");
            ApiResponse<Void> result = ApiResponse.error(401,"Token无效或已过期");
            response.getWriter().write(new ObjectMapper().writeValueAsString(result));
            return false;
        }
    }
}
