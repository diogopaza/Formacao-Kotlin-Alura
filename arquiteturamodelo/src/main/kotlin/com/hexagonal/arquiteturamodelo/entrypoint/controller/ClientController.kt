package com.hexagonal.arquiteturamodelo.entrypoint.controller

import com.hexagonal.arquiteturamodelo.entrypoint.dto.ClientResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/dados")
class ClientController {

    @GetMapping("/client/{cpf}")
    fun getClientByCpf(@PathVariable cpf: String): ResponseEntity<ClientResponse> {
        val clientResponse = ClientResponse(
            name = "Bill",
            lastName = "Gates",
        )
        return ResponseEntity.ok(clientResponse)
    }

}