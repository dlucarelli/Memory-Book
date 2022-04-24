package com.example.dylanlucarellicapstone.models;

import javax.persistence.*;

@Entity
@Table(name = "Memory")
public class Memory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "note")
    private String note;

    public Memory() {
    }

    public Memory(Long id, String title, String note) {
        this.id = id;
        this.title = title;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
