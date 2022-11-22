package seckill.dormsystem.interceptor;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import seckill.dormsystem.common.utils.JwtTokenUtil;
import seckill.dormsystem.service.TokenService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Resource
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        // 跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if(request.getMethod().equals("OPTIONS")) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        response.setCharacterEncoding("utf-8");
        String accessToken = request.getHeader("accessToken");
        String refreshToken = request.getHeader("refreshToken");
        if(accessToken != null) {
            Boolean accessResult = JwtTokenUtil.checkToken(accessToken);
            if(accessResult) {
//                System.out.println("pass TokenInterceptor!");
                return true;
            }
        }
        if(refreshToken != null) {
            Boolean refreshResult = JwtTokenUtil.checkToken(refreshToken);
            if(refreshResult) {
                String newRefreshToken = tokenService.refreshToken(refreshToken);
                String uid = JwtTokenUtil.getClaim(refreshToken, "uid");
                String newAccessToken = JwtTokenUtil.generateAccessToken(uid);
                response.setHeader("accessToken", newAccessToken);
                response.setHeader("refreshToken", newRefreshToken);
//                System.out.println("pass Interceptor, refreshToken refreshed!");
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
