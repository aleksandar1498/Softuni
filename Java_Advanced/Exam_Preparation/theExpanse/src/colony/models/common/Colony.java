package colony.models.common;

import colony.interfaces.ColonyInterface;
import colony.models.colonists.Colonist;
import colony.models.repositories.ColonyRepositoryImpl;

public class Colony implements ColonyInterface {

    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private ColonyRepositoryImpl colonyRepository ;
    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.colonyRepository = new ColonyRepositoryImpl();
    }

    public ColonyRepositoryImpl getColonyRepository() {
        return this.colonyRepository;
    }

    @Override
    public int getMaxFamilyCount() {
        return this.maxFamilyCount;
    }

    @Override
    public int getMaxFamilyCapacity() {
        return this.maxFamilyCapacity;
    }

    @Override
    public void addColonist(Colonist colonist) {
        if(this.colonyRepository.find(colonist.getFamilyId()) != null){
            if(this.colonyRepository.find(colonist.getFamilyId()).getRepository().count() < this.getMaxFamilyCapacity()){
                this.colonyRepository.addColonist(colonist.getFamilyId(),colonist);
            }
        }else{
            if(this.colonyRepository.count() < getMaxFamilyCount()){
                this.colonyRepository.addFamily(new Family(colonist.getFamilyId()));
                this.colonyRepository.addColonist(colonist.getFamilyId(),colonist);
            }
        }
    }

}
