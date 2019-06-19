package iteratorsandcomparators.petclinics;

public class Room implements Comparable<Room>{
    static int id=0;
    boolean isFree;
    int roomId;
    Pet pet;

    public Room() {
        this.roomId=++id;
        this.isFree = true;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public Pet getPet() {
        return pet;
    }

    public boolean setPet(Pet pet) {
        if(this.isFree){
            this.pet = pet;
            this.setFree(false);
            return true;
        }
        return false;

    }

    @Override
    public int compareTo(Room o) {
        return Integer.compare(this.roomId,o.roomId);
    }
}
