package com.cardealer.cardealer.entities;


public class SupplierParts {
    public SupplierParts(long id, String name, long pId, String pName) {
        this.id = id;
        this.name = name;

        this.pId = pId;
        this.pName = pName;
    }


    private long id;

    private String name;
    private long pId;

    public void setId(long id) {
        this.id = id;
    }

    public long getpId() {
        return pId;
    }

    public void setpId(long pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    private String pName;


    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

   }
