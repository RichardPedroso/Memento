package br.fai.lds.memento.caretaker;

import br.fai.lds.memento.memento.TextMemento;
import java.util.Stack;

/**
 * CUIDADOR (Caretaker)
 * 
 * Responsabilidades:
 * - Gerencia o histórico de mementos (quando salvar, quando restaurar)
 * - Mantém uma coleção de mementos organizados
 * - Implementa lógica de "desfazer" (undo)
 * - NÃO acessa o conteúdo interno dos mementos
 * - NÃO modifica os mementos
 * 
 * IMPORTANTE: O Cuidador trata os mementos como "caixas pretas"
 * - Sabe QUANDO usá-los, mas não sabe O QUE contém
 */
public class EditorHistory {
    // Pilha para armazenar o histórico de estados (LIFO - Last In, First Out)
    // Usa Stack para implementar "desfazer" - o último estado salvo é o primeiro a ser restaurado
    private final Stack<TextMemento> history = new Stack<>();
    
    /**
     * Salva um memento no histórico
     * Chamado sempre que o Originador quer "fazer backup" de seu estado
     * 
     * @param memento O memento a ser salvo (criado pelo Originador)
     */
    public void save(TextMemento memento) {
        history.push(memento); // Adiciona no topo da pilha
    }
    
    /**
     * Implementa a funcionalidade "desfazer"
     * Remove e retorna o último memento salvo
     * 
     * @return O último memento salvo, ou null se não houver histórico
     */
    public TextMemento undo() {
        if (!history.isEmpty()) {
            return history.pop(); // Remove do topo da pilha
        }
        return null; // Não há nada para desfazer
    }
    
    /**
     * Verifica se é possível desfazer alguma operação
     * 
     * @return true se existe histórico, false caso contrário
     */
    public boolean canUndo() {
        return !history.isEmpty();
    }
    
    /**
     * Retorna o tamanho do histórico (quantos estados estão salvos)
     * Útil para debug e informações ao usuário
     * 
     * @return Número de mementos no histórico
     */
    public int getHistorySize() {
        return history.size();
    }
}