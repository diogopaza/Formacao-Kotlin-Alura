package com.hexagonal.arquiteturamodelo.infraestructure.adapter

import com.hexagonal.arquiteturamodelo.core.model.ClientCore
import com.hexagonal.arquiteturamodelo.core.ports.DadosCadastraisPort
import com.hexagonal.arquiteturamodelo.infraestructure.mapper.convertClientDadosCadastraisToClientCore
import com.hexagonal.arquiteturamodelo.infraestructure.model.ClientDadosCadastrais
import org.springframework.stereotype.Service

@Service
class DadosCadastraisAdapter : DadosCadastraisPort {

    override fun getDadosCliente(token: String, cpf: String): ClientCore {
        return convertClientDadosCadastraisToClientCore(
            ClientDadosCadastrais(
                1,
                "Pedro",
                "Pazinha",
                "45-998513318",
                "masculino"
            )
        )
    }
}