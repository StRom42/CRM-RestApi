package Models.Users.Roles;

import org.springframework.security.core.GrantedAuthority;

public enum Permissions implements GrantedAuthority {
    ReplyPermission, ReportPermission, ConfigurationPermission;

    @Override
    public String getAuthority() {
        return name();
    }
}
