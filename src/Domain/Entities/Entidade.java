package Domain.Entities;

import Shared.Utils.UniqueIdGenerator;

/**
 * A classe abstrata {@code Entidade} representa uma entidade genérica no domínio do sistema.
 * Cada entidade possui um identificador único gerado automaticamente ao ser instanciada.
 * A geração do identificador é realizada através do {@code UniqueIdGenerator}.
 */

public abstract class Entidade {

    // Campo para armazenar o identificador único da entidade
    private String id;

    /**
     * Construtor padrão da classe {@code Entidade}.
     * Ao ser chamado, gera automaticamente um identificador único para a entidade.
     */

    public Entidade() {
        this.id = UniqueIdGenerator.generate();
    }

    /**
     * Obtém o identificador único da entidade.
     *
     * @return O identificador único gerado para a entidade.
     */

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

