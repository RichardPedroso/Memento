# Guia de Estudo - Padrão Memento
  🎯 O que é o Padrão Memento?
  O Memento é um padrão comportamental que permite salvar e restaurar estados de objetos sem quebrar o encapsulamento.



# 🔍 Analogia do Mundo Real
  Imagine um jogo de videogame com sistema de save:

Jogador = Originador (tem estado que muda)<br>
Save file = Memento (snapshot imutável do progresso)<br>
Sistema de saves = Cuidador (gerencia quando salvar/carregar)<br>



# 🏗️ Estrutura do Padrão

#### 1. ORIGINADOR (TextEditor)<br>

📋 Responsabilidades:<br>
✓ Mantém estado interno<br>
✓ Cria mementos (snapshots)<br>
✓ Restaura estado de mementos<br>
✓ Único com acesso total aos dados do memento<br>

#### 2. MEMENTO (TextMemento)
📋 Responsabilidades:<br>
✓ Armazena estado de forma IMUTÁVEL<br>
✓ Permite acesso apenas ao originador<br>
✓ Pode ter metadados (timestamp, etc.)<br>
✓ Funciona como "cápsula do tempo"<br>

#### 3. CUIDADOR (EditorHistory)
📋 Responsabilidades:<br>
✓ Decide QUANDO salvar estados<br>
✓ Gerencia coleção de mementos<br>
✓ Implementa lógica de undo/redo<br>
✓ NÃO acessa conteúdo dos mementos<br>

# 🔄 Fluxo de Funcionamento
1. Usuário faz operação<br>
   ↓<br>
2. Originador cria memento<br>
   ↓<br>
3. Cuidador salva memento<br>
   ↓<br>
4. [Tempo depois] Usuário quer desfazer<br>
   ↓<br>
5. Cuidador recupera memento<br>
   ↓<br>
6. Originador restaura estado<br>

## 💡 Conceitos-Chave para Memorizar
#### 🔒 ENCAPSULAMENTO
Cuidador nunca acessa dados internos
Memento só expõe dados para o originador
Estado privado permanece privado

#### 🧊 IMUTABILIDADE
Memento nunca muda após criação
Campos final garantem isso
Estados salvos ficam íntegros 

#### 📚 SEPARAÇÃO DE RESPONSABILIDADES
Cada classe tem UMA responsabilidade clara
Originador: gerencia estado
Memento: armazena estado
Cuidador: gerencia histórico

# ✅ Quando Usar o Memento?

#### ✅ USE quando:
Precisa implementar undo/redo
Quer salvar checkpoints/snapshots
Precisa reverter transações
Quer manter histórico de mudanças

#### ❌ NÃO use quando:
Estados são muito grandes (consome RAM)
Mudanças são muito frequentes
Não precisa de histórico
Objetos têm referências complexas

# 🎯 Vantagens vs Desvantagens

#### ✅ Vantagens:
Preserva encapsulamento
Estados imutáveis e seguros
Fácil implementar undo/redo
Separação clara de responsabilidades

#### ⚠️ Desvantagens:
Pode consumir muita memória
Overhead de criar muitos objetos
Complexidade adicional para casos simples

#### 🔗 Padrões Relacionados
Command: Frequentemente usado junto (comandos salvam mementos)
Prototype: Alternativa mais simples em alguns casos
Iterator: Pode salvar posição de iteração

### 💡 Dica de Estudo: Execute o código várias vezes e observe como cada classe interage. Tente quebrar o encapsulamento propositalmente para entender sua importância!
