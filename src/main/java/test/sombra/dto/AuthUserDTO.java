package test.sombra.dto;


/**
 * Created by Ivan on 27.03.2017.
 */
public class AuthUserDTO {

    private String username;

    private String firstName;

    private String role;

    private boolean active;

    private String massage;

    public AuthUserDTO() {

    }

    public AuthUserDTO(String username, String firstName, String role, boolean active, String massage) {
        this.username = username;
        this.firstName = firstName;
        this.role = role;
        this.active = active;
        this.massage = massage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthUserDTO that = (AuthUserDTO) o;

        if (isActive() != that.isActive()) return false;
        if (!getUsername().equals(that.getUsername())) return false;
        if (!getFirstName().equals(that.getFirstName())) return false;
        if (!getRole().equals(that.getRole())) return false;
        return getMassage().equals(that.getMassage());

    }

    @Override
    public int hashCode() {
        int result = getUsername().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getRole().hashCode();
        result = 31 * result + (isActive() ? 1 : 0);
        result = 31 * result + getMassage().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "AuthUserDTO{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", role='" + role + '\'' +
                ", active=" + active +
                ", massage='" + massage + '\'' +
                '}';
    }
}
