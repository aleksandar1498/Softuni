package com.cardealer.cardealer.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id
    @Column(name = "supplier_id")
    private long supplierId;
    @Column(name = "name")
    private String name;
    @Column(name = "is_importer",columnDefinition = "bit(1)")
    private boolean isImporter;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    private Set<Parts> parts;

    public Supplier() {
    }

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isImporter() {
        return isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }
}
