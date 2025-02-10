package com.authvids.security.jwt.repository

import com.authvids.security.jwt.domain.Role
import com.authvids.security.jwt.domain.User
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class UserRepository(
    encoder: PasswordEncoder
) {
    private val users = mutableSetOf(
      User(
        id = UUID.randomUUID(),
        name = "email1@gmail.com",
        password = encoder.encode("pass1"),
        role = Role.USER,
      ),
      User(
        id = UUID.randomUUID(),
        name = "email2@gmail.com",
        password = encoder.encode("pass2"),
        role = Role.ADMIN,
      ),
      User(
        id = UUID.randomUUID(),
        name = "email3@gmail.com",
        password = encoder.encode("pass3"),
        role = Role.USER,
      )
    )

    fun findByUsername(email: String): User? =
        users
          .firstOrNull { it.name == email }
}