package com.hexagonal.arquiteturamodelo.infraestructure.database.oracle.model

import java.time.LocalDateTime

data class ClientEntity(
    val id: Int,
    val nome: String,
    val sobreNome: String,
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime

)
