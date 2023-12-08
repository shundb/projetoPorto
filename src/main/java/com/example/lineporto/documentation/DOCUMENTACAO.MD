**Documentação do Código**

---

### Pacote: com.example.lineporto.Controller

#### Classe: NavioController

##### Métodos:

1. **mostrarFormulario**
   - **Tipo:** `GET`
   - **Mapeamento:** `/navios/formulario`
   - **Descrição:** Exibe o formulário para inserção de informações do navio.
   - **Parâmetros:**
     - `Model model`: Objeto para adicionar atributos usados na renderização da view.
   - **Retorno:** Nome da página HTML para exibir o formulário (`navio-form.html`).

2. **atracarNavio**
   - **Tipo:** `POST`
   - **Mapeamento:** `/navios/formulario`
   - **Descrição:** Processa as informações do formulário, verifica se o navio pode atracar e redireciona para a página de resultado.
   - **Parâmetros:**
     - `NavioInfoClass navioInfoClass`: Objeto contendo informações do navio.
     - `Model model`: Objeto para adicionar atributos usados na renderização da view.
   - **Retorno:** Redirecionamento para `/navios/atracar`.

3. **resultadoAtracacao**
   - **Tipo:** `GET`
   - **Mapeamento:** `/navios/atracar`
   - **Descrição:** Exibe o resultado da atracação.
   - **Parâmetros:**
     - `Model model`: Objeto para adicionar atributos usados na renderização da view.
   - **Retorno:** Nome da página HTML para exibir o resultado (`resultado-atracacao.html`).

#### Atributos:

- `private AtracacaoService atracacaoservice`: Serviço de atracação injetado por Spring.

---

### Pacote: com.example.lineporto.Navios

#### Classe: NavioInfoClass

##### Atributos:

1. `private String nome`: Nome do navio.
2. `private String empresa`: Nome da empresa do navio.
3. `private String tipoCarga`: Tipo de carga do navio.
4. `private double tamanho`: Tamanho do navio.
5. `private double largura`: Largura do navio.
6. `private double profundidade`: Profundidade do navio.

##### Métodos Get/Set para cada atributo.

---

### Pacote: com.example.lineporto.Service.impl

#### Classe: AtracacaoServiceImpl

##### Atributos:

- `private String motivo`: Razão pela qual o navio não pode atracar.

##### Métodos:

1. **podeAtracar**
   - **Descrição:** Verifica se o navio pode atracar com base nas regras de negócios.
   - **Parâmetros:**
     - `NavioInfoClass navioInfoClass`: Objeto contendo informações do navio.
   - **Retorno:** `boolean` indicando se o navio pode atracar.

2. **getMotivo**
   - **Retorno:** `String` contendo a razão pela qual o navio não pode atracar.

3. **setMotivo**
   - **Parâmetros:**
     - `String motivo`: Razão pela qual o navio não pode atracar.

---

### Pacote: com.example.lineporto.Service

#### Interface: AtracacaoService

##### Métodos:

1. **podeAtracar**
   - **Descrição:** Declaração do método para verificar se o navio pode atracar.
   - **Parâmetros:**
     - `NavioInfoClass navioInfoClass`: Objeto contendo informações do navio.
   - **Retorno:** `boolean` indicando se o navio pode atracar.

---

### Pacote: com.example.lineporto

#### Classe: LineportoApplication

##### Métodos:

1. **main**
   - **Descrição:** Ponto de entrada da aplicação Spring Boot.
   - **Parâmetros:**
     - `String[] args`: Argumentos de linha de comando.

---

### Arquivo HTML: navio-form.html

- **Descrição:** Formulário Thymeleaf para entrada de informações do navio.

---

### Arquivo HTML: resultado-atracacao.html

- **Descrição:** Página Thymeleaf para exibir o resultado da atracação, incluindo informações do navio e mensagem sobre a possibilidade de atracação.

