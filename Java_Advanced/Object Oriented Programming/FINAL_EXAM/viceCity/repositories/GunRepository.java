package viceCity.repositories;

import viceCity.models.guns.Gun;
import viceCity.repositories.interfaces.Repository;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;

public class GunRepository implements Repository<Gun> {
    private ArrayDeque<Gun> guns;

    public GunRepository() {
        this.guns = new ArrayDeque<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableCollection(this.guns);
    }

    @Override
    public void add(Gun model) {
        // check if the gun already exists
        if (this.guns.stream().noneMatch(g -> g.getName().equals(model.getName()))) {
            this.guns.offer(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return this.guns.remove(model);
    }

    @Override
    public Gun find(String name) {
        return this.guns.stream().filter(g -> g.getName().equals(name)).findFirst().orElse(null);

    }
}
