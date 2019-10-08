package colony.interfaces;

import colony.models.colonists.Colonist;

import java.util.List;

public interface ColonyInterface {
   int getMaxFamilyCount();
   int getMaxFamilyCapacity();
   void addColonist(Colonist colonist);
}
