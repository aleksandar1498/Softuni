package militaryElit.model;

import militaryElit.common.Repair;
import militaryElit.enums.Corps;
import militaryElit.interfaces.Engineer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    List<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName,double salary, Corps corps) {
        super(id, firstName, lastName,salary, corps);
        this.repairs = new ArrayList<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append(String.format("Corps: %s",super.getCorps().name()));
        builder.append(System.lineSeparator());
        builder.append("Repairs:");
        for (Repair repair : this.repairs) {
            builder.append(System.lineSeparator());
            builder.append("  ").append(repair);
        }
        return builder.toString();
    }
}
