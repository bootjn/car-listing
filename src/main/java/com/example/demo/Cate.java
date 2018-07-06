package com.example.demo;

import javax.persistence.*;

@Entity
public class Cate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String catetype;

    //@OneToOne(mappedBy = "cate")
    //private Car car;

    //@OneToMany(mappedBy = "")

    //@ManyToMany(fetch = FetchType.EAGER)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private Car car;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCatetype() {
        return catetype;
    }

    public void setCatetype(String catetype) {
        this.catetype = catetype;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
