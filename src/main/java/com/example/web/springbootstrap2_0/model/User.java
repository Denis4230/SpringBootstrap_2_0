package com.example.web.springbootstrap2_0.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "password")
    private String password;
    @Column(name = "username")
    private String username;
    @Column(name = "age")
    private int age;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;




    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role"))
    private Set<Role> roles;

    public User(String password, String username, int age, String firstName, String lastName, Set<Role> roles) {
        this.password = password;
        this.username = username;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.roles = roles;
    }

    public User() {
    }

    public User(String password, String username, int age, String firstName, String lastName) {
        this.password = password;
        this.username = username;
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
