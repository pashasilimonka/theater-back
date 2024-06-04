package edu.sylymonka.theater.config;/*
  @author   silim
  @project   theater
  @class  UserAuthProvider
  @version  1.0.0 
  @since 03.06.2024 - 17.27
*/

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import edu.sylymonka.theater.dto.user.UserDto;
import edu.sylymonka.theater.service.UserService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.security.core.Authentication;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {
    @Value("${security.jwt.token.secret-key:secret-value}")
    private String secretKey;

    private final UserService userService;
    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(String email) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 1000 * 60 * 60 * 24);
        return JWT.create()
                .withIssuer(email)
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(Algorithm.HMAC256(secretKey));
    }

    public Authentication validateToken(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretKey))
                .build();

        DecodedJWT jwt = verifier.verify(token);

        UserDto user = userService.findByLogin(jwt.getIssuer());

        return new UsernamePasswordAuthenticationToken(user,null, Collections.emptyList());
    }

}
