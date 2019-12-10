package com.akudama.books.auth.user;

import com.akudama.books.auth.group.AuthGroup;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id")
//    @SequenceGenerator(name = "id", initialValue = 1, allocationSize = 100)
    private Long id;

    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;

    @Column(name = "PASSWORD")
    private String password;

    @OneToMany(targetEntity = AuthGroup.class, mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<AuthGroup> authGroups;

    public User(String username, String password,
            List<AuthGroup> authGroups) {
        this.username = username;
        this.password = password;
        this.authGroups = authGroups;
    }
}
