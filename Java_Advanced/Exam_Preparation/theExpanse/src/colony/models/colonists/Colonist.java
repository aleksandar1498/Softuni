package colony.models.colonists;

import colony.interfaces.ColonistInterface;

public abstract class Colonist implements ColonistInterface {
    private String id;
    private String familyId;
    private int talent;
    private int age;

     protected Colonist(String id, String familyId, int talent, int age) {
        this.id = id;
        this.familyId = familyId;
        this.talent = talent;
        this.age = age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public String getFamilyId() {
        return this.familyId;
    }

    @Override
    public int getTalent() {
        return this.talent;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    @Override
    public void grow(int years) {
        this.setAge(this.getAge()+years);
    }
}
