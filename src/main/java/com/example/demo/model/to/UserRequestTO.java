package com.example.demo.model.to;

import javax.validation.constraints.NotBlank;

public class UserRequestTO {

    @NotBlank(message = "name is mandatory")
    private String name;

    public UserRequestTO() {
    }

    public UserRequestTO(@NotBlank(message = "name is mandatory") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "UserRequestTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
