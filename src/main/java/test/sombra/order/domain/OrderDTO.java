package test.sombra.order.domain;

/**
 * Created by Ivan on 31.03.2017.
 */
public class OrderDTO {

    private Long goodId;

    private String username;

    public OrderDTO() {

    }

    public OrderDTO(Long goodId, String username) {
        this.goodId = goodId;
        this.username = username;
    }

    public Long getGoodId() {
        return goodId;
    }

    public void setGoodId(Long goodId) {
        this.goodId = goodId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDTO orderDTO = (OrderDTO) o;

        if (!getGoodId().equals(orderDTO.getGoodId())) return false;
        return getUsername().equals(orderDTO.getUsername());

    }

    @Override
    public int hashCode() {
        int result = getGoodId().hashCode();
        result = 31 * result + getUsername().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "OrderDTO{" +
                "goodId=" + goodId +
                ", username='" + username + '\'' +
                '}';
    }
}
