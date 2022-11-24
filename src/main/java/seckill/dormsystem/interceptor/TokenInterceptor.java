package seckill.dormsystem.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import seckill.dormsystem.common.utils.JwtTokenUtil;
import seckill.dormsystem.service.RedisService;
import seckill.dormsystem.service.TokenService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private TokenService tokenService;

    @Resource
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if(request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String[] authHeader = request.getHeader("Authorization").split(" ");
        if(authHeader.length == 2 && "Bearer".equals(authHeader[0])) {
            String accessToken = authHeader[1];
            Boolean verifyResult = tokenService.checkToken(accessToken);
            Boolean redisResult = redisService.hasKey(accessToken);
            if(verifyResult && redisResult) {
                System.out.println("pass TokenInterceptor!");
                return true;
            }
        }
        response.setContentType("application/json; charset=utf-8");
        try {
            JSONObject json = new JSONObject();
            json.put("msg", "token check failed");
            json.put("code", "500");
            response.getWriter().append(json.toString());
            System.out.println("verify failed!");
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}
