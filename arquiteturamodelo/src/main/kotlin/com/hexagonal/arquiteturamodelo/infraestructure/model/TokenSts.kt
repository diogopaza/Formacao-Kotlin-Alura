package com.hexagonal.arquiteturamodelo.infraestructure.model

data class TokenSts(
    val accessToken: String,
    val expireIn: Int,
    val refreshToken: String,
)

