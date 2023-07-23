package com.kuberloudy.jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtService {
    private final JwtUtil jwtUtil;

    public TokenRes createJwt(String email, String password) {
        return jwtUtil.generateToken(
                new UsernamePasswordAuthenticationToken(email, password)
        );
    }
}
