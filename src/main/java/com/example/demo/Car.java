package com.example.demo;




import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Entity
public class Car {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String pictureUrl;

    private String brand;

    private String modelname;

    private int year;

    private int msrp;


    //
    //@OneToOne(cascade = CascadeType.ALL)
    //@JoinColumn(name = "cate_id")
    //private Cate cate;


    @OneToMany(mappedBy = "car",
        cascade = CascadeType.ALL,
        fetch = FetchType.EAGER)

    public Set<Cate> cates;



    public Car() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }














    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMsrp() {
        return msrp;
    }

    public void setMsrp(int msrp) {
        this.msrp = msrp;
    }

    /*public Cate getCate() {
        return cate;
    }

    public void setCate(Cate cate) {
        this.cate = cate;
    }*/

    public Set<Cate> getCates() {
        return cates;
    }

    public void setCates(Set<Cate> cates) {
        this.cates = cates;
    }
}
