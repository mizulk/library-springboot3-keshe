package pers.mizulk.library.interceptor;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import pers.mizulk.library.util.JwtUtil;

@Slf4j
@Component
public class JwtTokenInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		if (!(handler instanceof HandlerMethod)) return true;

		String token = request.getHeader("token");

		if (token == null) {
			log.info("token is null");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return false;
		}

		try {
			Jws<Claims> claimsJws = JwtUtil.parseJwt(token);
			Object name = claimsJws.getPayload().get("name");
			log.info("authorized. name: {}", name);
			return true;
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			log.info("unauthorized. token: {}", token);
			return false;
		}

	}
}
