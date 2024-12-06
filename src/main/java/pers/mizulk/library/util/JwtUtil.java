package pers.mizulk.library.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SecureDigestAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
	private static final byte[] decode = "fddddddddddddddddddddddddddddddddddddd".getBytes();
	private static final SecretKey key = Keys.hmacShaKeyFor(decode);

	public static final long MINUTE = 60 * 1000;
	public static final long HOUR = 60 * MINUTE;
	public static final long DAY = 24 * HOUR;

	public static String createJwt(long exp, Map<String, Object> claims) {
		SecureDigestAlgorithm<SecretKey, SecretKey> algorithm = Jwts.SIG.HS256;

		long expTime = System.currentTimeMillis() + exp;
		Date expDate = new Date(expTime);

		return Jwts.builder()
				.signWith(key, algorithm)
				.expiration(expDate)
				.claims(claims)
				.compact();
	}

	public static Jws<Claims> parseJwt(String jwt) {
		return Jwts.parser()
				.verifyWith(key)
				.build()
				.parseSignedClaims(jwt);
	}

}