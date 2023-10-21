package ManagerStudent.model;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {
    public static int count = 0;
    private Integer id;
    private String name;
    private Date dateOfBirth;
    private String address;
    private Double height;
    private Double weight;

    public Person( String name, Date dateOfBirth, String address, Double height, Double weight){
        this.id = ++count ;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    public Date getDateOfBirth(){
        return dateOfBirth;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setHeight(double height){
        this.height = height;
    }
    public Double getHeight(){
        return height;
    }
    public void setWeight(double weight){
        this.weight = weight;
    }
    public Double getWeight(){
        return weight;
    }
    @Override
    public String toString(){
        return "ID: " + id + "\n" + "Name: " + name + "\n" + "Date: " + dateOfBirth + "\n" + "Address: " + address + "\n" +
                "Height: " + height + "\n" + "Weight: " + weight;
    }
}
