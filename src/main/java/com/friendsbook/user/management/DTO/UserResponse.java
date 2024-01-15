package com.friendsbook.user.management.DTO;

public class UserResponse {
    private String name;
    private String email;
    private Integer id;
    private String status;

    public UserResponse(String name, String email, Integer id, String status) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public UserResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserResponse setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public UserResponse setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public UserResponse setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", id='" + id + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
