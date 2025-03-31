package com.hexagonal.arquiteturamodelo.entrypoint.mapper

import com.hexagonal.arquiteturamodelo.core.model.ClientCore
import com.hexagonal.arquiteturamodelo.entrypoint.dto.ClientResponse

fun clientCoreToClientResponse(clientCore: ClientCore): ClientResponse =
    ClientResponse(
        clientCore.name,
        clientCore.lastName
    )