package com.example.course_project.Domains;

import java.io.Serializable;

public class NatureDomain implements Serializable {

    private String name;
    private Double fee;
    private String pic;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFee() {
        return fee;
    }

    public void setFee(Double fee) {
        this.fee = fee;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public NatureDomain(String name, Double fee, String pic) {
        this.name = name;
        this.fee = fee;
        this.pic = pic;
    }
}
