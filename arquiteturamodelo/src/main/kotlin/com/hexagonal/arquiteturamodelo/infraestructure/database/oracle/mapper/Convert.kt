package com.hexagonal.arquiteturamodelo.infraestructure.database.oracle.mapper

import com.hexagonal.arquiteturamodelo.core.model.ClientCore
import com.hexagonal.arquiteturamodelo.infraestructure.database.oracle.model.ClientEntity
import java.time.LocalDateTime
import java.util.UUID

fun clientCoreToclientEntity(clientCore: ClientCore) =
    ClientEntity(
        1,
        clientCore.name,
        clientCore.lastName,
        LocalDateTime.now(),
        LocalDateTime.now()
    )

fun clientEntityToclientCore(clientEntity: ClientEntity) =
    ClientCore(
        clientEntity.nome,
        clientEntity.sobreNome
    )