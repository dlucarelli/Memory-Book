package com.example.dylanlucarellicapstone.models;



import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Memory")
public class Memory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Column(name = "note")
    private String note;


//    @ManyToOne
//    @JoinColumn(name = "child_id")
//    private Child child;

    public Memory() {
    }

    public Memory(Long id, String title, Date date, String note
//            , Child child
    ) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.note = note;
//        this.child = child;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

//    public Child getChild() {
//        return child;
//    }
//
//    public void setChild(Child child) {
//        this.child = child;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Memory memory = (Memory) o;
        return Objects.equals(id, memory.id) && Objects.equals(title, memory.title) && Objects.equals(date, memory.date) && Objects.equals(note, memory.note);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, date, note);
    }
}
