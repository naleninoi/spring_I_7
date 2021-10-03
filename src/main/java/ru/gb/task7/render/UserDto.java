package ru.gb.task7.render;

import ru.gb.task7.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserDto {

    private Long id;
    private String username;
    private List<String> roles;

    public UserDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.roles = user.getRoles().stream()
                .map(role -> role.getRoleType().toString())
                .collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public List<String> getRoles() {
        return roles;
    }
}
