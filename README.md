# 📌 Sistema de Validação de Atividades Complementares #

Este projeto em Java orientado a objetos tem como objetivo validar as atividades complementares de um aluno com base em regras institucionais, distribuídas em modalidades específicas. A aplicação é baseada em princípios de design sólido e utiliza padrões de projeto como Strategy, Decorator e Specification.

---

# 🚀 Apresentação do Objetivo do Projeto

No contexto acadêmico, os alunos devem cumprir 80 horas de atividades complementares, distribuídas entre 4 modalidades:

Ensino (máximo 40%)

Pesquisa e Inovação (máximo 40%)

Extensão (máximo 40%)

Complementação (máximo 20%)

Cada modalidade contém uma lista de atividades pré-definidas, com um limite máximo de horas. O sistema permite ao aluno informar as horas realizadas em cada atividade. No final, o sistema gera um parecer detalhado, validando as horas conforme os critérios e informando se o aluno cumpriu a carga horária exigida.

---

# 📊 Diagrama de Classe

// a implementar

---

# 📌 Padrões de Projeto Utilizados

## ✔️ 1. Strategy – para refatorar o cálculo das horas válidas por modalidade
Usei o padrão Strategy para que cada modalidade tenha sua própria estratégia de cálculo com base na porcentagem exigida.

40% das 80h (ou seja, até 32h) podem vir da modalidade 1 - Ensino

40% das 80h (até 32h) da modalidade 2 - Pesquisa

40% das 80h (até 32h) da modalidade 3 - Extensão

20% das 80h (até 16h) da modalidade 4 - Complementação

Criei uma interface ValidadorHoras e uma classe para cada modalidade com sua própria estratégia de cálculo.

## ✔️ 2. Decorator – para personalizar o parecer final
Usei o padrão Decorator para adicionar funcionalidades opcionais ao parecer, como:

Assinatura do coordenador

Exportar o parecer em .pdf

Criei uma interface ParecerComponente e uma classe base ParecerBasico, 
e depois criei decoradores como ParecerComAssinatura e ParecerEmPdf.

## ✔️ 3. Specification – para validar regras de negócio
Criei regras de validação reutilizáveis && combináveis. Por exemplo:

Se o aluno atingiu as 80h válidas

Se há pelo menos uma atividade por modalidade

Criei uma interface Specification e duas classes com regras, uma que verifica se o aluno tem
as 80h válidas e o outra que verifica se nenhuma atividade está vazia. Depois criei uma 
regraE (regrasCombinadas) na classe SpecificationE que verifica se ambas são verdadeiras.

---

# ⚙️ Como usar:

Fazer o download do projeto em zip e extrair.
Abrir o terminal no diretório onde está instalado o arquivo PS.jar em ProjetoAtividadeComplementar\target e executar no CMD o comando:
```sh
java -jar PS.jar
```
Ou abrir diretamente no NetBeans ou Eclipse.

**Obs: caso houver problema de versão no NetBeans, clicar com o botão direito no projeto, ir em "Resolve Project Problems...", clicar em "Resolve", selecionar "Downgrade Project Source/ Binary Format to 22" e clicar em "OK" e "Close".**

---

# 📋 Passo a passo:

Digite a matrícula do aluno.

Escolha uma modalidade pelo número.

No submenu da modalidade, selecione uma das atividades listadas.

Informe apenas as horas declaradas.

Repita para outras modalidades e atividades.

Ao finalizar, escolha 0 no menu principal para gerar o parecer.

📌 Desenvolvido por **Felipe Martins de Medeiros** — para fins educacionais no curso de Análise e Desenvolvimento de Sistemas - IFSC campus Tubarão.

