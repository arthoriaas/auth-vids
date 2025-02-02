package com.authvids.security.jwt.controller

import com.authvids.security.jwt.domain.AuthenticationRequest
import com.authvids.security.jwt.domain.AuthenticationResponse
import com.authvids.security.jwt.domain.RefreshTokenRequest
import com.authvids.security.jwt.domain.TokenResponse
import com.authvids.security.jwt.service.AuthenticationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/auth")
class AuthController(
    private val authenticationService: com.authvids.security.jwt.service.AuthenticationService
) {
    @PostMapping
    fun authenticate(
        @RequestBody authRequest: AuthenticationRequest
    ): AuthenticationResponse =
        authenticationService.authentication(authRequest)

    @PostMapping("/refresh")
    fun refreshAccessToken(
        @RequestBody request: RefreshTokenRequest
    ): TokenResponse = TokenResponse(token = authenticationService.refreshAccessToken(request.token))
}