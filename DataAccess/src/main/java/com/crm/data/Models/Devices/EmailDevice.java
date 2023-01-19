package com.crm.data.Models.Devices;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.*;

@Entity
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "emailDevices")
public class EmailDevice extends AbstractDevice{
    @Column
    private String host;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private Long port;
    @Column
    private String protocol;

    {
        setDeviceType("emailDevice");
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getPort() {
        return port;
    }

    public void setPort(Long port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
