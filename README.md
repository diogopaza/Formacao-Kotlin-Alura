# Formacao-Kotlin-Alura

<h3>Arquitetura Hexagonal (Ports and Adapters)</h3>
<p>A arquiteutra Hexagonal busca o desacoplamento. É baseada em três pilares: CORE a parte prinicpal da aplicacao, aqui oque a aplicacao faz de fato. O segundo pilar e o Primary/Driver Side, aqui fica quem vai consumir o Core. Essa camada inicia o processo da aplicacao de fato. E por fim o Secundary/Drive Side fica as tecnologias que o CORE da aplicacao precisa para resolver seus problemas. Se algo vai ser persistido no banco a Core se comunica com a Driven Side. 
</p>
<h3>Ports and Adapters</h3>
<p>Ports sao interfaces e Adapters sao implementacoes.</p>

