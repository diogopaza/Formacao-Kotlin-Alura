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
<p>Um dos pontos que o projeto arquiteturamodelo aborda no curso e o fato de ser errado o uso de duas implementacoes de uma interface. Apos pesquisa observou-se ser possivel usar varias implementacoes de uma interface. Abaixo algumas maneiras de implementar com o Spring.</p>



<h4>Referencias</h4>

<p><sub>Youtube - DevEduardoAlbuquerque - <a href="https://www.youtube.com/watch?v=_3aZCs8IGGQ&list=PLRHt7FXZbVCQmSscfVQVKT_gegPHurnHs&index=1">Treinamento Arquitetura Hexagonal</a></sub></p>
