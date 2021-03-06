package test.sombra.order.domain;

import test.sombra.good.domain.Good;
import test.sombra.user.domain.CustomUser;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Ivan on 22.03.2017.
 */
@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToMany(targetEntity = Good.class, mappedBy = "orders", cascade = CascadeType.ALL)
    private Set<Good> goods = new HashSet<>();

    @OneToOne
    @MapsId
    private CustomUser user;

    public Order() {
    }

    public Order(Set<Good> goods, CustomUser user) {
        this.goods = goods;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Good> getGoods() {
        return goods;
    }

    public void setGoods(Set<Good> goods) {
        this.goods = goods;
    }

    public CustomUser getUser() {
        return user;
    }

    public void setUser(CustomUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (getId() != null ? !getId().equals(order.getId()) : order.getId() != null) return false;
        if (!getGoods().equals(order.getGoods())) return false;
        return getUser() != null ? getUser().equals(order.getUser()) : order.getUser() == null;

    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + getGoods().hashCode();
        result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goods=" + goods +
                ", user=" + user +
                '}';
    }
}
