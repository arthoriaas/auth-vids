package com.authvids.security.jwt.domain


import com.fasterxml.jackson.annotation.JsonProperty
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor

@NoArgsConstructor
@AllArgsConstructor
class AuthenticationRequest(
    @JsonProperty("username") val username: String,
    @JsonProperty("password") val password: String
)

@NoArgsConstructor
@AllArgsConstructor
data class AuthenticationResponse(
    val accessToken: String,
    val refreshToken: String,
)
@NoArgsConstructor
@AllArgsConstructor
data class RefreshTokenRequest(
    @JsonProperty("token") val token: String
)
@NoArgsConstructor
@AllArgsConstructor
data class TokenResponse(
    val token: String
)