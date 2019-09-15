package spaceStation.models.planets;

import spaceStation.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlanetImpl implements Planet {
    private String name;
    private List<String> items;

    protected PlanetImpl(String name) {
        this.setName(name);
        this.items = new ArrayList<>();
    }

    private void setName(String name) {
        if(name == null || name.trim().isEmpty()){
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return Collections.unmodifiableCollection(this.items);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
