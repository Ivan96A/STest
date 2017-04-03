package test.sombra.good.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 02.04.2017.
 */
public class GoodDTO {

    List<Good> goods = new ArrayList<>();

    Double amount;

    public GoodDTO() {

    }

    public GoodDTO(List<Good> goods, Double amount) {
        this.goods = goods;
        this.amount = amount;
    }

    public List<Good> getGoods() {
        return goods;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GoodDTO goodDTO = (GoodDTO) o;

        if (!getGoods().equals(goodDTO.getGoods())) return false;
        return getAmount().equals(goodDTO.getAmount());

    }

    @Override
    public int hashCode() {
        int result = getGoods().hashCode();
        result = 31 * result + getAmount().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "GoodDTO{" +
                "goods=" + goods +
                ", amount=" + amount +
                '}';
    }
}
