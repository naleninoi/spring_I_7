package ru.gb.task7.enums;

public enum RoleType {
    ROLE_MANAGER("ROLE_MANAGER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_SUPERADMIN("ROLE_SUPERADMIN")
    ;

    private final String roleName;

    RoleType(String roleName) { this.roleName = roleName; }

    @Override
    public String toString() {
        return roleName;
    }
}
