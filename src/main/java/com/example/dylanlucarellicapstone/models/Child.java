package com.example.dylanlucarellicapstone.models;

import com.example.dylanlucarellicapstone.security.User;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Child")
public class Child {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "kidsName")
    private String name;

    @Column(name = "age")
    private Long age;

//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    @OneToMany(mappedBy ="id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

    private Collection<Memory> memory;

    public Child() {
    }

    public Child(Long id, String name, Long age, Collection<Memory> memories) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.memory = memories;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public Collection<Memory> getMemory() {
        return memory;
    }

    public void setMemory(Collection<Memory> memory) {
        this.memory = memory;
    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
}
