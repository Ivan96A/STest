package test.sombra.manufacturer;

import com.fasterxml.jackson.annotation.JsonIgnore;
import test.sombra.good.Good;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ivan on 22.03.2017.
 */

@Entity
@Table(name = "manufacturers")
public class Manufacturer implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "logo")
    private String logo;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
    private Set<Good> goods = new HashSet<>();

    public Manufacturer() {
    }

    public Manufacturer(String name, String country, String logo, Set<Good> goods) {
        this.name = name;
        this.country = country;
        this.logo = logo;
        this.goods = goods;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public Set<Good> getGoods() {
        return goods;
    }

    public void setGoods(Set<Good> goods) {
        this.goods = goods;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Manufacturer that = (Manufacturer) o;

        if (!getId().equals(that.getId())) return false;
        if (!getName().equals(that.getName())) return false;
        if (!getCountry().equals(that.getCountry())) return false;
        if (!getLogo().equals(that.getLogo())) return false;
        return getGoods() != null ? getGoods().equals(that.getGoods()) : that.getGoods() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getCountry().hashCode();
        result = 31 * result + getLogo().hashCode();
        result = 31 * result + (getGoods() != null ? getGoods().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", logo='" + logo + '\'' +
                '}';
    }

}
