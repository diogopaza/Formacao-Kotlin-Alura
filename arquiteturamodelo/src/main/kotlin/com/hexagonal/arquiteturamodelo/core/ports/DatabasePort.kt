package com.hexagonal.arquiteturamodelo.core.ports

import com.hexagonal.arquiteturamodelo.core.model.ClientCore

interface DatabasePort {

    fun salvaDadosClient(clientCore: ClientCore): ClientCore
}