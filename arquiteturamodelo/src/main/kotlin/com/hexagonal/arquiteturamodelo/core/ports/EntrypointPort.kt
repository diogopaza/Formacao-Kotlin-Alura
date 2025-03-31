package com.hexagonal.arquiteturamodelo.core.ports

import com.hexagonal.arquiteturamodelo.core.model.ClientCore

interface EntrypointPort {

    fun getClientByCpf(cpf: String): ClientCore



}