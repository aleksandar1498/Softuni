package colony.interfaces;

import colony.models.colonists.Colonist;
import colony.models.common.Family;

import java.util.List;

public interface ColonyRepository extends Repository<Family> {
    void removeFamily(String id);

    List<Colonist> getColonistsByFamilyId(String familyId);
    void removeColonist(String familyId, String memberId);
    void  addColonist(String familyId,Colonist colonist);
    void addFamily(Family family);
    List<Family> getAll();
}
