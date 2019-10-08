package colony;

import colony.models.colonists.engineers.SoftwareEngineer;
import colony.models.common.Colony;

public class Main {
    public static void main(String[] args) {
        Colony colony = new Colony(2,1);
        colony.addColonist(new SoftwareEngineer("alex","stefanov",10,20));
        colony.addColonist(new SoftwareEngineer("alex","stefanova",10,20));
colony.getColonyRepository().getAll().stream().forEach(x -> {
    System.out.println(x.getId());
    x.getRepository().getAll().forEach(f -> {
        System.out.println("  "+f.getFamilyId()+" "+f.getAge());
    });
});
    }
}
