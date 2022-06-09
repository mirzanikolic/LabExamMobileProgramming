package com.example.mirzanikolic;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "mobiles")
public class Mobile {
    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name = "model")
    private String model;

    @ColumnInfo(name = "color")
    private String color;

    @ColumnInfo(name = "memory")
    private String memory;

    @ColumnInfo(name = "price")
    private String price;

    @ColumnInfo(name = "camera_pixels")
    private String camera_pixels;

    @ColumnInfo(name = "year_of_manufacturing")
    private String year_of_manufacturing;

    @Ignore
    public Mobile(long id, String model, String color, String memory, String price, String camera_pixels, String year_of_manufacturing) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.memory = memory;
        this.price = price;
        this.camera_pixels = camera_pixels;
        this.year_of_manufacturing = year_of_manufacturing;
    }

    public Mobile(String model, String color, String memory, String price, String camera_pixels, String year_of_manufacturing) {
        this.model = model;
        this.color = color;
        this.memory = memory;
        this.price = price;
        this.camera_pixels = camera_pixels;
        this.year_of_manufacturing = year_of_manufacturing;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCamera_pixels() {
        return camera_pixels;
    }

    public void setCamera_pixels(String camera_pixels) {
        this.camera_pixels = camera_pixels;
    }

    public String getYear_of_manufacturing() {
        return year_of_manufacturing;
    }

    public void setYear_of_manufacturing(String year_of_manufacturing) {
        this.year_of_manufacturing = year_of_manufacturing;
    }
}
