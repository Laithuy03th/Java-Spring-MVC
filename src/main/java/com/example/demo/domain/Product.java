package com.example.demo.domain;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    @NotEmpty(message = "tên sản phẩm không được để trống")
    private String name;

    @NotNull

    @DecimalMin(value = "0", inclusive = false, message = "Giá sản phẩm phải lớn hơn 0")
    private double price;

    private String image;

    @NotNull
    @NotEmpty(message = "detailDesc không được để trống")
    @Column(columnDefinition = "TEXT")
    private String detailDesc;

    @NotNull
    @NotEmpty(message = "short description cannot be empty")
    private String shortDesc;

    @NotNull
    @Min(value = 1, message = "Số lượng sản phẩm phải lớn hơn 0")
    private long quantity;

    @NotNull
    private long sold;

    @NotNull
    private String factory;

    @NotNull
    private String target;

    public Product() {

    }

    public Product(String name, double price, String image, String detailDesc, String shortDesc, long quantity,
            long sold, String factory, String target, long id) {
        this.name = name;
        this.price = price;
        this.image = image;
        this.detailDesc = detailDesc;
        this.shortDesc = shortDesc;
        this.quantity = quantity;
        this.sold = sold;
        this.factory = factory;
        this.target = target;
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetailDesc() {
        return detailDesc;
    }

    public void setDetailDesc(String detailDesc) {
        this.detailDesc = detailDesc;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public long getQuantity() {
        return quantity;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getSold() {
        return sold;
    }

    public void setSold(long sold) {
        this.sold = sold;
    }

    public String getFactory() {
        return factory;
    }

    public void setFactory(String factory) {
        this.factory = factory;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", image=" + image + ", detailDesc=" + detailDesc
                + ", shortDesc=" + shortDesc + ", quantity=" + quantity + ", sold=" + sold + ", factory=" + factory
                + ", target=" + target + ", getName()=" + getName() + ", getPrice()=" + getPrice() + ", getImage()="
                + getImage() + ", getDetailDesc()=" + getDetailDesc() + ", getShortDesc()=" + getShortDesc()
                + ", getClass()=" + getClass() + ", getQuantity()=" + getQuantity() + ", getSold()=" + getSold()
                + ", getFactory()=" + getFactory() + ", getTarget()=" + getTarget() + ", hashCode()=" + hashCode()
                + ", toString()=" + super.toString() + "]";
    }

}
