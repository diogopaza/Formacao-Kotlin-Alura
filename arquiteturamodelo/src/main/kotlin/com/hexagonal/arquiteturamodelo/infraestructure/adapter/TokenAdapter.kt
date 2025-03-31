package com.hexagonal.arquiteturamodelo.infraestructure.adapter

import com.hexagonal.arquiteturamodelo.core.model.TokenCore
import com.hexagonal.arquiteturamodelo.core.ports.TokenPort
import com.hexagonal.arquiteturamodelo.infraestructure.mapper.convertTokenStsToTokenCore
import com.hexagonal.arquiteturamodelo.infraestructure.model.TokenSts
import org.springframework.stereotype.Service

@Service
class TokenAdapter : TokenPort {

    override fun getToken() =
    convertTokenStsToTokenCore(TokenSts(
        "1234567890",
        60,
        "56565656"
    ))


}