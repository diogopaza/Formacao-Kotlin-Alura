package br.com.diogo

class Jogo(
//    @SerializedName("title") val titulo: String,
//    @SerializedName("thumb") val capa: String
    val titulo: String,
    val capa: String,
) {
    //no Kotiln as variaveis precisam ser inicializadas
    //variaveis com val nao pode alterar o valor posteriormente
    //no Kotlin uma boa pratica e a imutabilidade, usando o val como padrao para as variaveis
    var descricao: String? = null
    override fun toString(): String {
        return """
            Meu jogo:
            Titulo: $titulo
            Capa: $capa
            Descricao: $descricao            
        """.trimIndent()
    }


}