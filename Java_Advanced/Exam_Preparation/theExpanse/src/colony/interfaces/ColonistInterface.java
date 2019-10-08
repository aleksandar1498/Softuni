package colony.interfaces;

public interface ColonistInterface {
    String getId();
    String getFamilyId();
    int getTalent();
    int getAge();
    int getPotential();
    void grow(int years);
}
