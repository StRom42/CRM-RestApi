package com.crm.data.Models.Lead;

import com.crm.data.Models.Clients.Client;
import com.crm.data.Models.Users.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "leads")
public class Lead implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(targetEntity = LeadState.class)
    @JoinColumn(name = "lead_to_state", nullable = false)
    private LeadState currentState;

    @ManyToOne(targetEntity = Client.class)
    @JoinColumn(name = "lead_to_client", nullable = false)
    private Client client;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "lead_to_user", nullable = false)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LeadState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(LeadState currentState) {
        this.currentState = currentState;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
