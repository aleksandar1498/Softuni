package colony.models.repositories;

import colony.interfaces.ColonyRepository;
import colony.interfaces.FamilyRepository;
import colony.interfaces.Repository;
import colony.models.colonists.Colonist;
import colony.models.common.Colony;
import colony.models.common.Family;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ColonyRepositoryImpl implements ColonyRepository {
    Map<String, Family> families;

    public ColonyRepositoryImpl() {
        this.families = new LinkedHashMap<>();
    }


    @Override
    public void removeFamily(String id) {
        this.families.remove(id);
    }

    @Override
    public List<Colonist> getColonistsByFamilyId(String familyId) {
        System.out.println();
        return this.families.get(familyId).getRepository().getAll();
    }

    @Override
    public void removeColonist(String familyId, String memberId) {
        if (this.families.containsKey(familyId)) {
            this.families.get(familyId).getRepository().removeColonist(memberId);
            if (this.families.get(familyId).getRepository().count() == 0) {
                this.families.remove(familyId);
            }
        }
    }

    @Override
    public void addColonist(String familyId, Colonist colonist) {
        if (!this.families.containsKey(familyId)) {
            this.families.put(familyId, new Family(familyId));
        }
        this.families.get(familyId).getRepository().addColonist(colonist);
    }

    @Override
    public void addFamily(Family family) {
        //TODO
    }

    @Override
    public List<Family> getAll() {
        return new ArrayList<>(this.families.values());
    }

    @Override
    public Family find(String id) {
        return this.families.get(id);
    }

    @Override
    public int count() {
        return this.families.size();
    }


}
