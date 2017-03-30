package test.sombra.good.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import test.sombra.manufacturer.domain.Manufacturer;
import test.sombra.order.domain.Order;
import test.sombra.type.domain.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ivan on 22.03.2017.
 */

@Entity
@Table(name = "goods")
public class Good implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "status")
    private boolean status;

    @Column(name = "material")
    private String material;

    @Column(name = "picture")
    private String picture;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private Manufacturer manufacturer;

    @JsonIgnore
    @ManyToMany(targetEntity = Order.class)
    private Set<Order> orders = new HashSet<>();

    public Good() {

    }

    public Good(String name, Double price, boolean status, String material, String picture, Type type, Manufacturer manufacturer, Set<Order> orders) {
        this.name = name;
        this.price = price;
        this.status = status;
        this.material = material;
        this.picture = picture;
        this.type = type;
        this.manufacturer = manufacturer;
        this.orders = orders;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (isStatus() != good.isStatus()) return false;
        if (!getId().equals(good.getId())) return false;
        if (!getName().equals(good.getName())) return false;
        if (!getPrice().equals(good.getPrice())) return false;
        if (!getMaterial().equals(good.getMaterial())) return false;
        if (!getPicture().equals(good.getPicture())) return false;
        if (!getType().equals(good.getType())) return false;
        if (!getManufacturer().equals(good.getManufacturer())) return false;
        return getOrders() != null ? getOrders().equals(good.getOrders()) : good.getOrders() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getPrice().hashCode();
        result = 31 * result + (isStatus() ? 1 : 0);
        result = 31 * result + getMaterial().hashCode();
        result = 31 * result + getPicture().hashCode();
        result = 31 * result + getType().hashCode();
        result = 31 * result + getManufacturer().hashCode();
        result = 31 * result + (getOrders() != null ? getOrders().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Good{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", material='" + material + '\'' +
                ", picture='" + picture + '\'' +
                ", type=" + type +
                ", manufacturer=" + manufacturer +
                ", orders=" + orders +
                '}';
    }
}
