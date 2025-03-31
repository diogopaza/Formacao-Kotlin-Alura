package com.hexagonal.arquiteturamodelo.infraestructure.database.oracle.adapter

import com.hexagonal.arquiteturamodelo.core.model.ClientCore
import com.hexagonal.arquiteturamodelo.core.ports.DatabasePort
import com.hexagonal.arquiteturamodelo.infraestructure.database.oracle.mapper.clientCoreToclientEntity
import com.hexagonal.arquiteturamodelo.infraestructure.database.oracle.mapper.clientEntityToclientCore
import org.springframework.stereotype.Service

class OracleAdapter: DatabasePort {
    override fun salvaDadosClient(clientCore: ClientCore): ClientCore {
        val clientEntity = clientCoreToclientEntity(clientCore)
        println("Salvando no Oracle o cliente: ${clientCore.name}")
        val persistencia = true
        return clientEntityToclientCore(clientEntity)
    }
}