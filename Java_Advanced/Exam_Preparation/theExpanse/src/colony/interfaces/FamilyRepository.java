package colony.interfaces;

import colony.models.colonists.Colonist;

import java.util.List;

public interface FamilyRepository extends Repository<Colonist> {
        void addColonist(Colonist colonist);
        void removeColonist(String memberId);
        List<Colonist> getAll();
}
