# 🎓 Escola API — Microserviço Java Spring Boot

Microserviço desenvolvido com *Java 17* e *Spring Boot 3.2* para gerenciamento de notas escolares.

---

## 🚀 Como Executar

### Pré-requisitos
- Java 17+
- Maven 3.8+

### Rodando o projeto

bash
# Clonar o repositório
git clone <seu-link-aqui>
cd escola-api

# Compilar e executar
mvn spring-boot:run


A API estará disponível em: http://localhost:8080

---

## 📋 Endpoints

### 1. Calcular Média — POST /api/escola/calcular-media

Recebe as notas do aluno e retorna se foi aprovado ou reprovado.

*Request Body:*
json
{
  "nome": "João Silva",
  "nota1": 7.0,
  "nota2": 8.0
}


*Resposta (aprovado — média > 5):*
json
{
  "nome": "João Silva",
  "nota1": 7.0,
  "nota2": 8.0,
  "media": 7.5,
  "situacao": "APROVADO",
  "mensagem": "Parabéns João Silva, você foi aprovado."
}


*Resposta (reprovado — média < 5):*
json
{
  "nome": "Maria",
  "nota1": 3.0,
  "nota2": 2.0,
  "media": 2.5,
  "situacao": "REPROVADO",
  "mensagem": "Maria, você foi reprovado."
}


*Resposta (nota de corte — média == 5):*
json
{
  "nome": "Carlos",
  "nota1": 5.0,
  "nota2": 5.0,
  "media": 5.0,
  "situacao": "REPROVADO",
  "mensagem": "Carlos, você não atingiu a nota de corte e foi reprovado."
}


---

### 2. Data e Hora Local — GET /api/escola/data-hora

Retorna a data e hora atual do servidor.

*Resposta:*
json
{
  "dataHoraLocal": "07/06/2026 14:35:22",
  "fuso": "America/Sao_Paulo",
  "diaSemana": "domingo"
}


---

## 🧪 Testando com cURL

bash
# Calcular média
curl -X POST http://localhost:8080/api/escola/calcular-media \
  -H "Content-Type: application/json" \
  -d '{"nome": "João", "nota1": 7.0, "nota2": 8.0}'

# Data e hora
curl http://localhost:8080/api/escola/data-hora


---

## 🏗️ Estrutura do Projeto


escola-api/
├── src/main/java/com/escola/api/
│   ├── EscolaApiApplication.java       # Classe principal
│   ├── controller/
│   │   ├── EscolaController.java       # Endpoints REST
│   │   └── GlobalExceptionHandler.java # Tratamento de erros
│   ├── service/
│   │   └── EscolaService.java          # Regras de negócio
│   └── dto/
│       ├── AlunoNotaRequestDTO.java    # Entrada da requisição
│       ├── MediaResponseDTO.java       # Resposta da média
│       └── DataHoraResponseDTO.java    # Resposta data/hora
├── src/main/resources/
│   └── application.properties
└── pom.xml


---

## 🛠️ Tecnologias

| Tecnologia | Versão |
|---|---|
| Java | 17 |
| Spring Boot | 3.2.0 |
| Spring Web | 3.2.0 |
| Spring Validation | 3.2.0 |
| Maven | 3.8+ |
