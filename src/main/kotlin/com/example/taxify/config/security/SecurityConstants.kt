package com.example.taxify.config.security

class SecurityConstants {

    companion object {
        val JWT_SECRET = "secret=n2r5u8x/A%D*G-KaPdSgVkYp3s6v9y\$B&E(H+MbQeThWmZq4t7w!z%C*F-J@NcRf"
        val AUTH_LOGIN_URL = "/authenticate"
        val TOKEN_HEADER = "Authorization"
        val TOKEN_PREFIX = "Bearer "
        val TOKEN_TYPE = "JWT"
        val TOKEN_ISSUER = "taxify-app"
        val TOKEN_AUDIENCE = "taxify-app"
    }
}