package Domain.Entities;

import Shared.Utils.UniqueIdGenerator;

public abstract class Entidade {
    private String id;

    public Entidade() {
        this.id = UniqueIdGenerator.generate();
    }

    public String getId() {
        return this.id;
    }
}
