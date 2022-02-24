package com.aldeamo.bartender.model;


import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name="arrays")
public class ArrayBarTender {
    @GeneratedValue
    @Id
    private int id;
    private String inputArray;

    public ArrayBarTender() {
    }

    public ArrayBarTender(int id, String inputArray) {
        this.id = id;
        this.inputArray = inputArray;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInputArray() {
        return inputArray;
    }
}
