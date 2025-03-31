package com.hexagonal.arquiteturamodelo.infraestructure.mapper

import com.hexagonal.arquiteturamodelo.core.model.ClientCore
import com.hexagonal.arquiteturamodelo.core.model.TokenCore
import com.hexagonal.arquiteturamodelo.infraestructure.model.ClientDadosCadastrais
import com.hexagonal.arquiteturamodelo.infraestructure.model.TokenSts

fun convertTokenStsToTokenCore(token: TokenSts) =
        TokenCore(
            token.accessToken,
            token.expireIn,
            token.refreshToken
        )

fun convertClientDadosCadastraisToClientCore(clientDadosCadastrais: ClientDadosCadastrais) =
    ClientCore(
        clientDadosCadastrais.nome,
        clientDadosCadastrais.sobreNome
    )
