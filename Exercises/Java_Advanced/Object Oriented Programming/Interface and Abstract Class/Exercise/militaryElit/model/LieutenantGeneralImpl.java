package militaryElit.model;

import militaryElit.interfaces.LieutenantGeneral;
import militaryElit.interfaces.Private;
import militaryElit.interfaces.Soldier;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {
    Set<Private> privates;
    public LieutenantGeneralImpl(int id, String firstName, String lastName,double salary) {
        super(id, firstName, lastName,salary);
        privates = new TreeSet<>(new Comparator<Private>() {
            @Override
            public int compare(Private o1, Private o2) {
                return o2.getId()-o1.getId();
            }
        });
    }

    @Override
    public void addPrivate(PrivateImpl priv) {
        this.privates.add(priv);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder(super.toString());
        builder.append(System.lineSeparator());
        builder.append("Privates:");
        for (Private aPrivate : this.privates) {
            builder.append(System.lineSeparator());
            builder.append(aPrivate);
        }
        return builder.toString();
    }
}
