package com.authvids.security.jwt.controller

import com.nimbusds.jose.jwk.JWKSet
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/.well-known")
class JwksController(
    private val jwkSet: JWKSet
) {
    @GetMapping("/jwks.json")
    fun getJwks(): Map<String, Any> {
        return jwkSet.toJSONObject()
    }
}