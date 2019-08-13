package com.enjoywith.enjoywith.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "events")
public class Event {
    @Id
    private int id;
    @Column(name = "tst")
    private String tst;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTst() {
        return tst;
    }

    public void setTst(String tst) {
        this.tst = tst;
    }

    public Event() {
    }

    public Event(int id, String tst) {
        this.id = id;
        this.tst = tst;
    }


}
