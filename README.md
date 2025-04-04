# Formacao-Kotlin-Alura

<h3>Arquitetura Hexagonal (Ports and Adapters)</h3>
<p>A arquiteutra Hexagonal busca o desacoplamento. É baseada em três pilares: CORE a parte prinicpal da aplicacao, aqui oque a aplicacao faz de fato. O segundo pilar e o Primary/Driver Side, aqui fica quem vai consumir o Core. Essa camada inicia o processo da aplicacao de fato. E por fim o Secundary/Drive Side fica as tecnologias que o CORE da aplicacao precisa para resolver seus problemas. Se algo vai ser persistido no banco a Core se comunica com a Driven Side. 
</p>
<h3>Ports and Adapters</h3>
<p>Ports sao interfaces e Adapters sao implementacoes.</p>
<p>A interface e injetada em que esta começando a consumir. Outro conceito importante e que a Core e blindada, ou seja, essas camada nao precisa conhecer, saber oque acontece com as outras camadas. </p>
<p>Cada camada pode ser observada como programas diferentes que conversam entre si, por isso pode haver repetição de dados principalmente enre os modelos e dto's.</p>

<h3>Exemplo1 projeto arquiteturamodelo</h3>
<p>No projeto arquiteturamodelo foi criado o pacote entrypoint que representa o Driver Side, ou seja o lado que vai receber requisicoes para consumir a aplicacao. Abaixo temos como ficou a essa parte da arquitetura:

<u>
  <li>entrypoint
    <ul>
      <li>controller</li>
      <li>dto</li>
    </ul>
  </li>
</ul>

</p>

<h3>Uso de multiplas Interfaces no Spring</h3>
<p>Um dos pontos que o projeto arquiteturamodelo aborda no curso e o fato de ser errado o uso de duas implementacoes de uma interface. Apos pesquisa observou-se ser possivel usar varias implementacoes de uma interface. Abaixo algumas maneiras de implementar com o Spring.

1. A primeira opcao e usar a anotacao <strong>@Qualifier("nomeBean")</strong>: na anotacao @Qualifier("oracleAdapter") e uma referencia a classe (implementcao) da interface DatabasePort, que neste exemplo pode ser OracleAdapter ou SqlAdapter, a anotacao @Qualifier define qual deve ser injetada.

```java
    @Service
class ClientAdapter(
    private val tokenPort: TokenPort,
    private val dadosCadastraisPort: DadosCadastraisPort,
    @Qualifier("oracleAdapter") private val databasePort: DatabasePort
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

   ```

2. A segunda opcao e criar um Map de Implementacoes: agora databasePort recebe um Map<String, DatabasePort> desse forma e possivel escolher qual implementacao usar, usando o seguinte codigo: databasePort["oracleAdapter"]?.salvaDadosClient(clientCore).


```java

    
    @Service
class ClientAdapter(
    private val tokenPort: TokenPort,
    private val dadosCadastraisPort: DadosCadastraisPort,
    private val databasePort: Map<String, DatabasePort>
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
        databasePort["oracleAdapter"]?.salvaDadosClient(clientCore)
        return clientCore
    }

}

   ```

</p>

<h3>Tratamento de erros no Kotlin</h3>
<p>O tratamento de erros e excecoes pode ser usando o <emph>Try/Catch</emph> do Java ou com o runCatching, este oferece algumas opcoes mais personalizaas de tratamento conforme codigo abaixo. E possivel notar que o codigo que pode apresentar algum erro esta dentro das chaves do runCatching. E mais abaixo o runCathing possui metodos para tratamento em caso de erro ou uma sequencia de acoes em caso de sucesso. O runCatching e uma opcao interessante pois com seu uso existe a possibilidade de nao se interromper o fluxo de execucao e salvar o seu resultado para ser trabalhado em caso de sucesso ou falha.

  ```java
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
            meuJogo?.descricao = meuJogo.titulo
        }
    }
    println(meuJogo)
  

  ```




</p>




<h4>Referencias</h4>

<p><sub>Youtube - DevEduardoAlbuquerque - Projeto usado arquiteturamodelo (sofrendo alteracoes da versao original para testes deste repositorio) <a href="https://www.youtube.com/watch?v=_3aZCs8IGGQ&list=PLRHt7FXZbVCQmSscfVQVKT_gegPHurnHs&index=1">Treinamento Arquitetura Hexagonal</a></sub></p>
