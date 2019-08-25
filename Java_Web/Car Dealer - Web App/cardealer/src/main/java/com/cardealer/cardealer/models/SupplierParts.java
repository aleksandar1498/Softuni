package com.cardealer.cardealer.models;


public class SupplierParts {
    private long id;

    private String name;
    private long offeredParts;
    public SupplierParts(long id, String name, long offeredParts) {
        this.id = id;
        this.name = name;
        this.offeredParts = offeredParts;
    }



    public void setId(long id) {
        this.id = id;
    }


    public long getId() {
        return this.id;
    }

    public long getOfferedParts() {
        return offeredParts;
    }

    public void setOfferedParts(long offeredParts) {
        this.offeredParts = offeredParts;

    }
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

   }
