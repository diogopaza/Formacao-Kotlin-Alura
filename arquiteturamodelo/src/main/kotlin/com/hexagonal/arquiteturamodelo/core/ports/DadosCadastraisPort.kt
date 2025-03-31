package com.hexagonal.arquiteturamodelo.core.ports

import com.hexagonal.arquiteturamodelo.core.model.ClientCore

interface DadosCadastraisPort {

    fun getDadosCliente(token: String, cpf: String): ClientCore
}