# Guia de Estudo - Padrão Memento

## 🎯 O que é o Padrão Memento?

O Memento é um padrão comportamental que permite **salvar e restaurar estados** de objetos sem quebrar o encapsulamento.

### 🔍 Analogia do Mundo Real
Imagine um **jogo de videogame** com sistema de save:
- **Jogador** = Originador (tem estado que muda)
- **Save file** = Memento (snapshot imutável do progresso)
- **Sistema de saves** = Cuidador (gerencia quando salvar/carregar)

## 🏗️ Estrutura do Padrão

### 1. **ORIGINADOR** (TextEditor)
```
📋 Responsabilidades:
✓ Mantém estado interno
✓ Cria mementos (snapshots)
✓ Restaura estado de mementos
✓ Único com acesso total aos dados do memento
```

### 2. **MEMENTO** (TextMemento)
```
📋 Responsabilidades:
✓ Armazena estado de forma IMUTÁVEL
✓ Permite acesso apenas ao originador
✓ Pode ter metadados (timestamp, etc.)
✓ Funciona como "cápsula do tempo"
```

### 3. **CUIDADOR** (EditorHistory)
```
📋 Responsabilidades:
✓ Decide QUANDO salvar estados
✓ Gerencia coleção de mementos
✓ Implementa lógica de undo/redo
✓ NÃO acessa conteúdo dos mementos
```

## 🔄 Fluxo de Funcionamento

```
1. Usuário faz operação
   ↓
2. Originador cria memento
   ↓
3. Cuidador salva memento
   ↓
4. [Tempo depois] Usuário quer desfazer
   ↓
5. Cuidador recupera memento
   ↓
6. Originador restaura estado
```

## 💡 Conceitos-Chave para Memorizar

### 🔒 **ENCAPSULAMENTO**
- Cuidador nunca acessa dados internos
- Memento só expõe dados para o originador
- Estado privado permanece privado

### 🧊 **IMUTABILIDADE**
- Memento nunca muda após criação
- Campos `final` garantem isso
- Estados salvos ficam íntegros

### 📚 **SEPARAÇÃO DE RESPONSABILIDADES**
- Cada classe tem UMA responsabilidade clara
- Originador: gerencia estado
- Memento: armazena estado
- Cuidador: gerencia histórico

## ✅ Quando Usar o Memento?

### ✅ **USE quando:**
- Precisa implementar undo/redo
- Quer salvar checkpoints/snapshots
- Precisa reverter transações
- Quer manter histórico de mudanças

### ❌ **NÃO use quando:**
- Estados são muito grandes (consome RAM)
- Mudanças são muito frequentes
- Não precisa de histórico
- Objetos têm referências complexas

## 🎯 Vantagens vs Desvantagens

### ✅ **Vantagens:**
- Preserva encapsulamento
- Estados imutáveis e seguros
- Fácil implementar undo/redo
- Separação clara de responsabilidades

### ⚠️ **Desvantagens:**
- Pode consumir muita memória
- Overhead de criar muitos objetos
- Complexidade adicional para casos simples

## 🔗 Padrões Relacionados

- **Command**: Frequentemente usado junto (comandos salvam mementos)
- **Prototype**: Alternativa mais simples em alguns casos
- **Iterator**: Pode salvar posição de iteração

## 🧪 Exercícios para Praticar

1. **Modifique o exemplo** para incluir formatação (negrito, itálico)
2. **Implemente redo** além do undo
3. **Adicione limite** ao histórico (ex: máximo 10 estados)
4. **Crie versão** com múltiplos editores independentes
5. **Implemente serialização** dos mementos para disco

## 🎓 Perguntas para Autoavaliação

1. Por que o Memento deve ser imutável?
2. O que acontece se o Cuidador acessar dados internos do Memento?
3. Como o padrão preserva encapsulamento?
4. Qual a diferença entre Memento e simples backup de dados?
5. Quando seria melhor usar Prototype ao invés de Memento?

---

**💡 Dica de Estudo:** Execute o código várias vezes e observe como cada classe interage. Tente quebrar o encapsulamento propositalmente para entender sua importância!