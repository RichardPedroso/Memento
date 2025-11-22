package br.fai.lds.memento.memento;

/**
 * MEMENTO
 * 
 * Responsabilidades:
 * - Armazena o estado interno do Originador de forma imutável
 * - Fornece acesso aos dados apenas para o Originador
 * - Mantém metadados como timestamp
 * - Não permite modificação após criação (imutabilidade)
 * 
 * IMPORTANTE: Esta classe é como uma "fotografia" do estado
 * do TextEditor em um momento específico no tempo.
 */
public class TextMemento {
    // Campos FINAL = IMUTABILIDADE (característica essencial do Memento)
    private final String content;   // Snapshot do conteúdo do texto
    private final int cursorX;      // Snapshot da posição X do cursor
    private final int cursorY;      // Snapshot da posição Y do cursor
    private final long timestamp;   // Metadado: quando foi criado
    
    /**
     * Construtor - recebe o estado e o "congela" (torna imutável)
     * Chamado apenas pelo Originador (TextEditor)
     * 
     * @param content Conteúdo do texto no momento da criação
     * @param cursorX Posição X do cursor no momento da criação
     * @param cursorY Posição Y do cursor no momento da criação
     */
    public TextMemento(String content, int cursorX, int cursorY) {
        this.content = content;
        this.cursorX = cursorX;
        this.cursorY = cursorY;
        this.timestamp = System.currentTimeMillis(); // Marca quando foi criado
    }
    
    // Getters - permitem acesso aos dados salvos
    // Apenas o Originador deve usar estes métodos
    
    public String getContent() {
        return content;
    }
    
    public int getCursorX() {
        return cursorX;
    }
    
    public int getCursorY() {
        return cursorY;
    }
    
    // Metadado - pode ser acessado pelo Cuidador para informações
    public long getTimestamp() {
        return timestamp;
    }
}