# Telas de receitas — plano de implementação

**Objetivo:** entregar duas telas Android em XML: lista com fotos, tempo e custo; detalhes com ingredientes e preparo.
**Arquitetura:** manter Activity, dois Fragments, Navigation e View Binding existentes. Dados locais de três receitas; seleção por ID nos argumentos da navegação. Layout de cartão reutilizável em XML, fotos locais, sem novas dependências.
**Visual escolhido:** verde, creme, fotos em destaque, cartões arredondados e tipografia clara. Textos em português e custos ilustrativos por receita inteira.
**Tecnologias:** Kotlin, Android XML, Material Components e Navigation.

1. Substituir os layouts `fragment_first.xml` e `fragment_second.xml`; criar `item_recipe.xml`, estilos, cores e ícones. Remover controles de exemplo da Activity.
2. Criar catálogo local e preencher a lista e os detalhes com o mesmo objeto de receita. Passar somente `recipe_id` e usar retorno pela pilha de navegação.
3. Incluir três fotos no drawable-nodpi e documentar suas fontes.
4. Validar com `:app:assembleDebug :app:lintDebug`, inspecionar erros e verificar navegação, rolagem e restauração quando houver emulador disponível.

**Critérios:** cada cartão mostra foto, nome, minutos e custo; cada seleção abre seus próprios ingredientes e passos; voltar retorna à lista; conteúdo funciona offline e aceita rolagem.
