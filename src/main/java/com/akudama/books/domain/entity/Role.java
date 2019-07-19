package com.akudama.books.domain.entity;

import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table(name = "ROLE")
public class Role {

    private Long id;
    private String name;
    private Collection<User> users;
    private Collection<Privilege> privileges;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "role_id", unique = true)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    public Collection<User> getUsers() {
        return users;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "join_role_privilege",
            joinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "role_id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "privilege_id", referencedColumnName = "privilege_id")})
    public Collection<Privilege> getPrivileges() {
        return privileges;
    }
}
