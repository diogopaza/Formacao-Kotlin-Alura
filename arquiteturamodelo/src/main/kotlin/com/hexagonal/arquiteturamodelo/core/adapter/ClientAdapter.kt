package com.hexagonal.arquiteturamodelo.core.adapter

import com.hexagonal.arquiteturamodelo.core.model.ClientCore
import com.hexagonal.arquiteturamodelo.core.ports.DadosCadastraisPort
import com.hexagonal.arquiteturamodelo.core.ports.DatabasePort
import com.hexagonal.arquiteturamodelo.core.ports.EntrypointPort
import com.hexagonal.arquiteturamodelo.core.ports.TokenPort
import org.springframework.stereotype.Service

@Service
class ClientAdapter(
    private val tokenPort: TokenPort,
    private val dadosCadastraisPort: DadosCadastraisPort,
    private val databasePort: DatabasePort
) : EntrypointPort {
    /*
    receber o cpf via url
    gerar token STS
    buscar dados do cliente na api
    persistir os dados do clinete em banco de dados local
    * */
    override fun getClientByCpf(cpf: String): ClientCore {
        val token = tokenPort.getToken();
        val clientCore = dadosCadastraisPort.getDadosCliente(
            token.accessToken,
            cpf
        )
        databasePort.salvaDadosClient(clientCore)
        return clientCore
    }

}