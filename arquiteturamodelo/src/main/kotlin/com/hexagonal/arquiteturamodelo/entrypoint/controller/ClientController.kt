package com.hexagonal.arquiteturamodelo.entrypoint.controller

import com.hexagonal.arquiteturamodelo.core.ports.EntrypointPort
import com.hexagonal.arquiteturamodelo.entrypoint.mapper.clientCoreToClientResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dados")
class ClientController(
    val entrypointPort: EntrypointPort
) {

    @GetMapping("/client/{cpf}")
    fun getClientByCpf(@PathVariable cpf: String) =
        ResponseEntity.ok(
            clientCoreToClientResponse(entrypointPort.getClientByCpf(cpf))
        )
}
