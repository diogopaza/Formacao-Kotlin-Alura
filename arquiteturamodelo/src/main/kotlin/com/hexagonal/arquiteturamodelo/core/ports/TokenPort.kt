package com.hexagonal.arquiteturamodelo.core.ports

import com.hexagonal.arquiteturamodelo.core.model.TokenCore

interface TokenPort {

   fun getToken(): TokenCore
}