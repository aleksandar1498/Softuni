package colony.models.common;

import colony.interfaces.FamilyInterface;
import colony.interfaces.FamilyRepository;
import colony.models.colonists.Colonist;
import colony.models.repositories.FamilyRepositoryImpl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Family implements FamilyInterface {
    private String id;
    private FamilyRepository repository;

        public Family(String id) {
        this.id = id;
        this.repository = new FamilyRepositoryImpl();
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public FamilyRepository getRepository() {
        return this.repository;
    }
}
