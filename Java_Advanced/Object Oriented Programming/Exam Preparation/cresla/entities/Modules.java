package cresla.entities;

import cresla.interfaces.Module;

public abstract class Modules implements Module {


    private int id;

    Modules(int id) {
        this.id = id;
    }

    @Override
    public int getId() {
        return this.id;
    }
}
