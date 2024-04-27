package ma.esi.jfxapp.model;

import java.util.Objects;

public class User {
    private Integer id;
    private String fullname;
    private String email;
    private String password;
    private String tel;

    public User(Integer id, String fullname, String email, String password, String tel) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.password = password;
        this.tel = tel;
    }

    public Integer getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getTel() {
        return tel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(fullname, user.fullname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(tel, user.tel);
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullname='" + fullname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
