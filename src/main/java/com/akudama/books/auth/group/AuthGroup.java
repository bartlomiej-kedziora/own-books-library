package com.akudama.books.auth.group;

import com.akudama.books.auth.user.User;
import com.akudama.books.auth.utils.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "AUTH_USER_GROUP")
public class AuthGroup {

    @Id
    @Column(name = "AUTH_USER_GROUP_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "id", initialValue = 1, allocationSize = 100)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "AUTH_GROUP")
    @Enumerated(EnumType.STRING)
    private Role authGroup;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public AuthGroup(Long id, String username, Role authGroup) {
        this.id = id;
        this.username = username;
        this.authGroup = authGroup;
    }

    public AuthGroup(String username, Role authGroup, User user) {
        this.username = username;
        this.authGroup = authGroup;
        this.user = user;
    }
}
