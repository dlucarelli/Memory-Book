package com.example.dylanlucarellicapstone.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MEMORIES")
public class Memory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "TEXT")
    private String text;
    @Column(name = "DATE")
    private Date date;

    public Memory(long id, String text, Date date) {
        this.id = id;
        this.text = text;
        this.date = date;
    }

    public Memory() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
