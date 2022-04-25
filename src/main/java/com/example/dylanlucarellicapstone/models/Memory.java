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

    @Column(name = "date")
    private String date;

    @Column(name = "note")
    private String note;


    @ManyToOne
    @JoinColumn(name = "child_id")
    private Child child;

    public Memory() {
    }

    public Memory(Long id, String title, String date, String note, Child child) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.note = note;
        this.child = child;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Child getChild() {
        return child;
    }

    public void setChild(Child child) {
        this.child = child;
    }
}
