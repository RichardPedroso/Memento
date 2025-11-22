package br.fai.lds.memento.originator;

import br.fai.lds.memento.memento.TextMemento;

/**
 * ORIGINADOR (Originator)
 * 
 * Responsabilidades:
 * - Mantém o estado interno que pode mudar ao longo do tempo
 * - Cria mementos contendo snapshots de seu estado atual
 * - Restaura seu estado a partir de mementos
 * - É o único que tem acesso completo aos dados do memento
 */
public class TextEditor {
    // Estado interno do editor que será salvo nos mementos
    private String content;  // Conteúdo do texto
    private int cursorX;     // Posição X do cursor
    private int cursorY;     // Posição Y do cursor
    
    // Construtor - inicializa o editor com estado vazio
    public TextEditor() {
        this.content = "";
        this.cursorX = 0;
        this.cursorY = 0;
    }
    
    // Operação que modifica o estado - adiciona texto
    public void write(String text) {
        this.content += text;
    }
    
    // Operação que modifica o estado - move cursor
    public void setCursor(int x, int y) {
        this.cursorX = x;
        this.cursorY = y;
    }
    
    // Setter usado internamente para restaurar estado
    public void setContent(String content) {
        this.content = content;
    }
    
    // Getters para acessar o estado atual
    public String getContent() {
        return content;
    }
    
    public int getCursorX() {
        return cursorX;
    }
    
    public int getCursorY() {
        return cursorY;
    }
    
    /**
     * MÉTODO PRINCIPAL DO PADRÃO MEMENTO
     * Cria um snapshot (memento) do estado atual
     * 
     * @return TextMemento contendo o estado atual
     */
    public TextMemento createMemento() {
        return new TextMemento(content, cursorX, cursorY);
    }
    
    /**
     * MÉTODO PRINCIPAL DO PADRÃO MEMENTO
     * Restaura o estado a partir de um memento
     * 
     * @param memento O memento contendo o estado a ser restaurado
     */
    public void restoreFromMemento(TextMemento memento) {
        this.content = memento.getContent();
        this.cursorX = memento.getCursorX();
        this.cursorY = memento.getCursorY();
    }
    
    @Override
    public String toString() {
        return String.format("Content: '%s', Cursor: (%d,%d)", content, cursorX, cursorY);
    }
}