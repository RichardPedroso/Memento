package br.fai.lds.memento.main;

import br.fai.lds.memento.originator.TextEditor;
import br.fai.lds.memento.caretaker.EditorHistory;

/**
 * DEMONSTRAÇÃO DO PADRÃO MEMENTO
 * 
 * Este exemplo mostra como os três componentes trabalham juntos:
 * 
 * 1. ORIGINADOR (TextEditor): Mantém estado e cria/restaura mementos
 * 2. MEMENTO (TextMemento): Armazena snapshots imutáveis do estado
 * 3. CUIDADOR (EditorHistory): Gerencia quando salvar/restaurar estados
 * 
 * Fluxo do padrão:
 * 1. Usuário faz operação no Editor
 * 2. Editor cria Memento com estado atual
 * 3. Cuidador salva o Memento no histórico
 * 4. Para desfazer: Cuidador recupera Memento e Editor restaura estado
 */
public class Main {
    public static void main(String[] args) {
        // Criando os participantes do padrão
        TextEditor editor = new TextEditor();     // ORIGINADOR
        EditorHistory history = new EditorHistory(); // CUIDADOR
        // Os MEMENTOS serão criados dinamicamente
        
        System.out.println("=== Demonstração do Padrão Memento ===\n");
        
        // Estado inicial (sem salvar - não há necessidade)
        System.out.println("Estado inicial:");
        System.out.println(editor);
        
        // PRIMEIRA OPERAÇÃO: Escrever texto
        System.out.println("\n--- Operação 1: Escrevendo 'Olá ' ---");
        editor.write("Olá ");           // Modifica o estado do ORIGINADOR
        editor.setCursor(4, 0);         // Modifica mais o estado
        
        // PADRÃO MEMENTO EM AÇÃO:
        // 1. Originador cria memento com estado atual
        // 2. Cuidador salva o memento
        history.save(editor.createMemento());
        
        System.out.println("Estado após operação:");
        System.out.println(editor);
        System.out.println("Estados salvos: " + history.getHistorySize());
        
        // SEGUNDA OPERAÇÃO: Adicionar mais texto
        System.out.println("\n--- Operação 2: Escrevendo 'Mundo!' ---");
        editor.write("Mundo!");         // Modifica o estado novamente
        editor.setCursor(10, 0);        // Atualiza cursor
        
        // Salvando novo estado
        history.save(editor.createMemento());
        
        System.out.println("Estado após operação:");
        System.out.println(editor);
        System.out.println("Estados salvos: " + history.getHistorySize());
        
        // TERCEIRA OPERAÇÃO: Finalizar frase
        System.out.println("\n--- Operação 3: Escrevendo ' Como você está?' ---");
        editor.write(" Como você está?"); // Última modificação
        editor.setCursor(25, 0);            // Posiciona cursor no final
        
        // Salvando estado final
        history.save(editor.createMemento());
        
        System.out.println("Estado após operação:");
        System.out.println(editor);
        System.out.println("Estados salvos: " + history.getHistorySize());
        
        // DEMONSTRANDO O "DESFAZER" (UNDO)
        System.out.println("\n=== Desfazendo operações (Undo) ===");
        System.out.println("Agora vamos voltar no tempo usando os mementos salvos...");
        
        // PRIMEIRO UNDO: Volta ao estado antes da operação 3
        if (history.canUndo()) {
            System.out.println("\n--- 1º Undo: Voltando ao estado anterior ---");
            // PADRÃO MEMENTO EM AÇÃO (restauração):
            // 1. Cuidador recupera último memento
            // 2. Originador restaura seu estado usando o memento
            editor.restoreFromMemento(history.undo());
            
            System.out.println("Estado restaurado:");
            System.out.println(editor);
            System.out.println("Estados restantes: " + history.getHistorySize());
        }
        
        // SEGUNDO UNDO: Volta ao estado antes da operação 2
        if (history.canUndo()) {
            System.out.println("\n--- 2º Undo: Voltando mais um estado ---");
            editor.restoreFromMemento(history.undo());
            
            System.out.println("Estado restaurado:");
            System.out.println(editor);
            System.out.println("Estados restantes: " + history.getHistorySize());
        }
        
        // TERCEIRO UNDO: Volta ao estado antes da operação 1
        if (history.canUndo()) {
            System.out.println("\n--- 3º Undo: Voltando ao estado inicial ---");
            editor.restoreFromMemento(history.undo());
            
            System.out.println("Estado restaurado:");
            System.out.println(editor);
            System.out.println("Estados restantes: " + history.getHistorySize());
        }
        
        // RESULTADO FINAL
        System.out.println("\n=== Resumo Final ===");
        System.out.println("Histórico restante: " + history.getHistorySize() + " estados");
        System.out.println("Voltamos ao estado inicial sem quebrar encapsulamento!");
        System.out.println("\nVANTAGENS DO PADRÃO MEMENTO:");
        System.out.println("✓ Encapsulamento preservado");
        System.out.println("✓ Estados imutáveis");
        System.out.println("✓ Histórico gerenciado externamente");
        System.out.println("✓ Fácil implementação de undo/redo");
    }
}