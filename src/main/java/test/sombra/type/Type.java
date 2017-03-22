package test.sombra.type;

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
@Table(name = "types")
public class Type implements Serializable{

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "type")
    private Set<Good> goods = new HashSet<>();

    public Type() {
    }

    public Type(Long id, String name, Set<Good> goods) {
        this.id = id;
        this.name = name;
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

        Type type = (Type) o;

        if (getId() != null ? !getId().equals(type.getId()) : type.getId() != null) return false;
        if (getName() != null ? !getName().equals(type.getName()) : type.getName() != null) return false;
        return getGoods().equals(type.getGoods());

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + getGoods().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", goods=" + goods +
                '}';
    }
}
