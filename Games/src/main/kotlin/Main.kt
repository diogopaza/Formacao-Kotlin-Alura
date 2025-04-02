package br.com.diogo

import com.google.gson.Gson
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.*


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    lateinit var json: String;
    val scan = Scanner(System.`in`)
    println("Digite o id")
    val id = scan.nextLine()
    val client: HttpClient = HttpClient.newHttpClient()
//    try {
//        val request = HttpRequest.newBuilder()
//            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
//            .build()
//        val response = client
//            .send(request, BodyHandlers.ofString())
//        json = response.body();
//        println(json)
//        val gson = Gson()
//
//        val infoJogo = gson.fromJson(json, InfoJogo::class.java)
//        //val info = gson.fromJson(json, Info::class.java)
//        //println(info)
//        val meuJogo = Jogo(
//            infoJogo.info.title,
//            infoJogo.info.thumb
//        )
//        println(meuJogo)
//    } catch (e: Exception) {
//        println("Erro ao buscar jogo: ${e.localizedMessage}")
//    }

//    val meuArray = arrayOf('a','b','c')
//    println(meuArray.size)
      var meuJogo: Jogo? = null

    //Usando runCatchinf
    val resultado = runCatching {
        val request = HttpRequest.newBuilder()
            .uri(URI.create("https://www.cheapshark.com/api/1.0/games?id=$id"))
            .build()
        val response = client
            .send(request, BodyHandlers.ofString())
        json = response.body();
        println(json)
        val gson = Gson()

        val infoJogo = gson.fromJson(json, InfoJogo::class.java)
        //val info = gson.fromJson(json, Info::class.java)
        //println(info)
        meuJogo = Jogo(
            infoJogo.info.title,
            infoJogo.info.thumb
        )
    }

    resultado.onFailure {
        println("Jogo inexistente. Tente outro id")
    }

    resultado.onSuccess {
        println("Deseja mudar a descricao do jogo: sim(s) ou  nao(n)")
        val mudardescricao = scan.nextLine()
        if(mudardescricao.equals("s", true)){
            println("Digite a nova descricao")
            val novaDescricao = scan.nextLine()
            meuJogo?.descricao = novaDescricao
        } else {
            println("A descricao tera o mesmo nome do titulo")
            meuJogo?.descricao = meuJogo?.titulo
        }
    }
    println(meuJogo)


}