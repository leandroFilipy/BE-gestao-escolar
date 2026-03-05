# 📚 BE - Gestão Escolar | Validações com Bean Validation

✨ Projeto focado em **validações robustas utilizando Bean Validation / Hibernate Validator** em aplicações Java.  
Aqui você encontrará uma **coleção organizada das principais anotações de validação**, utilizadas para garantir **integridade, segurança e consistência de dados** em sistemas.

---

# 🚀 Tecnologias Utilizadas

- ☕ **Java**
- 🌱 **Spring / Jakarta Validation**
- 🔎 **Hibernate Validator**
- 🗄 **JPA / Hibernate**
- 🧩 **Bean Validation API**

---

# 📌 Objetivo do Projeto

Este projeto demonstra o uso de **anotações de validação** para garantir que os dados enviados para a aplicação:

✔ estejam corretos  
✔ estejam dentro de limites esperados  
✔ sigam padrões definidos  
✔ respeitem regras de negócio  

Essas validações são essenciais para **APIs REST, sistemas web e aplicações empresariais**.

---

# 🛡 1. Validações de Obrigatoriedade e Nulidade

| Anotação | Descrição |
|--------|-----------|
| `@NotNull` | O valor **não pode ser null** |
| `@NotEmpty` | Não pode ser **null nem vazio** (`""` ou coleção vazia) |
| `@NotBlank` | Não aceita **null, vazio ou apenas espaços** |
| `@Null` | O valor deve ser **obrigatoriamente null** |

💡 Muito usado para **DTOs e entrada de dados em APIs**.

---

# 🔢 2. Validações Numéricas e de Faixa

| Anotação | Descrição |
|--------|-----------|
| `@Min(value)` | Valor mínimo permitido |
| `@Max(value)` | Valor máximo permitido |
| `@DecimalMin(value)` | Mínimo para valores decimais |
| `@DecimalMax(value)` | Máximo para valores decimais |
| `@Positive` | Número **maior que zero** |
| `@PositiveOrZero` | Número **maior ou igual a zero** |
| `@Negative` | Número **menor que zero** |
| `@NegativeOrZero` | Número **menor ou igual a zero** |
| `@Range(min,max)` | Combinação de **Min + Max** |
| `@Digits(integer,fraction)` | Define limite de dígitos **antes e depois da vírgula** |

---

# 🔤 3. Validações de Texto e Padrões (Strings)

| Anotação | Descrição |
|--------|-----------|
| `@Size(min,max)` | Define tamanho mínimo e máximo |
| `@Length(min,max)` | Similar ao `@Size`, otimizado para Strings |
| `@Pattern(regexp)` | Valida usando **Expressão Regular (Regex)** |
| `@Email` | Verifica se é um **email válido** |
| `@URL` | Verifica se é uma **URL válida** |
| `@UUID` | Verifica se a String é um **UUID válido** |
| `@SafeHtml` | Protege contra **XSS removendo HTML perigoso** |
| `@CodePointLength(min,max)` | Valida tamanho considerando **Unicode (emojis, etc)** |

---

# 📅 4. Validações de Tempo e Data

| Anotação | Descrição |
|--------|-----------|
| `@Past` | Data deve estar **no passado** |
| `@PastOrPresent` | **Passado ou presente** |
| `@Future` | Data deve estar **no futuro** |
| `@FutureOrPresent` | **Futuro ou presente** |
| `@DurationMin` | Duração mínima |
| `@DurationMax` | Duração máxima |

💡 Muito usado em **cadastros, reservas, eventos e agendamentos**.

---

# 📦 5. Validações de Coleções e Estruturas

| Anotação | Descrição |
|--------|-----------|
| `@UniqueElements` | Garante que **não existam itens repetidos** |
| `@NotEmpty` | Lista **não pode estar vazia** |
| `@Size` | Lista deve ter entre **X e Y elementos** |

---

# ⚙ 6. Validações de Lógica e Estado

| Anotação | Descrição |
|--------|-----------|
| `@AssertTrue` | O campo deve ser **true** |
| `@AssertFalse` | O campo deve ser **false** |
| `@Valid` | Executa validação **em objetos aninhados** |
| `@ConvertGroup` | Permite **mudar grupo de validação** |

---

# 🪪 7. Validações de Documentos e Nicho

| Anotação | Descrição |
|--------|-----------|
| `@CreditCardNumber` | Valida **cartão de crédito (algoritmo Luhn)** |
| `@ISBN` | Valida **código ISBN de livros** |
| `@EAN` | Valida **código de barras comerciais** |
| `@Currency` | Verifica **código ISO de moeda** |
| `@CPF` | Valida **CPF brasileiro** |
| `@CNPJ` | Valida **CNPJ brasileiro** |
| `@TituloEleitoral` | Valida **Título de eleitor** |

---

# 🧮 8. Algoritmos de Verificação

| Anotação | Descrição |
|--------|-----------|
| `@LuhnCheck` | Valida números via **algoritmo de Luhn** |
| `@Mod10Check` | Validação por **módulo 10** |
| `@Mod11Check` | Validação por **módulo 11** |

---

# 🧠 9. Validações de Classe e Lógica Avançada

| Anotação | Descrição |
|--------|-----------|
| `@ScriptAssert` | Executa **script (JS/Groovy)** para validar classe |
| `@ParameterScriptAssert` | Valida **parâmetros de métodos** |
| `@GroupSequence` | Define **ordem de execução das validações** |
| `@ReportAsSingleViolation` | Agrupa múltiplos erros em **uma mensagem só** |

---

# 🧩 10. Base para Customização

Essas anotações permitem **criar suas próprias validações**.

| Anotação | Descrição |
|--------|-----------|
| `@Constraint(validatedBy={})` | Base para criar validações customizadas |
| `@ReportAsSingleViolation` | Agrupa múltiplas falhas |
| `@UnwrapValidatedValue` | Extrai valor interno de `Optional` ou wrappers |
| `@ConstraintTarget` | Define se valida **parâmetro ou retorno** |

💡 Exemplo de validação customizada:
