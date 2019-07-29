package militaryElit.model;

import militaryElit.interfaces.LeutenantGeneral;
import militaryElit.interfaces.Private;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    Set<Private> privates;
    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
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
            builder.append("  ").append(aPrivate);
        }
        return builder.toString();
    }
}
