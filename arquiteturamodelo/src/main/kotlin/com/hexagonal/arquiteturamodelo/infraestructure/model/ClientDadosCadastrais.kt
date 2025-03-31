package com.hexagonal.arquiteturamodelo.infraestructure.model

data class ClientDadosCadastrais (
    val id: Int,
    val nome: String,
    val sobreNome: String,
    val telefone: String,
    val sexo: String
)
