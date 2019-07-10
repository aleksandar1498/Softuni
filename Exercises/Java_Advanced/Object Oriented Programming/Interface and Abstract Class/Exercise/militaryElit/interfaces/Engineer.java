package militaryElit.interfaces;

import militaryElit.common.Repair;

import java.util.Collection;

public interface Engineer {
    void addRepair(Repair repair);
    Collection<Repair> getRepairs();
}
