package colony.models.repositories;

import colony.interfaces.FamilyRepository;
import colony.models.colonists.Colonist;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FamilyRepositoryImpl implements FamilyRepository {
    Map<String, Colonist> colonists;

    public FamilyRepositoryImpl() {
        this.colonists = new LinkedHashMap<>();
    }

    @Override
    public void addColonist(Colonist colonist) {
        if (!this.colonists.containsKey(colonist.getId())) {
            this.colonists.put(colonist.getId(), colonist);
        }
    }

    @Override
    public void removeColonist(String memberId) {
        this.colonists.remove(memberId);

    }

    @Override
    public Colonist find(String id) {
        return this.colonists.get(id);
    }

    @Override
    public int count() {
        return this.colonists.size();
    }

    @Override
    public List<Colonist> getAll() {
        System.out.println();
        return new ArrayList<>(this.colonists.values());
    }
}
