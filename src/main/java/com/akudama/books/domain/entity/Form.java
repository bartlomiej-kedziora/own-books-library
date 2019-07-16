package com.akudama.books.domain.entity;

import com.akudama.books.domain.BookKind;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "FORMS")
public class Form {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "form_id", unique = true)
    private Long id;

    @Enumerated(EnumType.STRING)
    private BookKind value;

    @ManyToMany(mappedBy = "forms")
    private Set<HomeCollectionItem> homeCollectionItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Form form = (Form) o;
        return value == form.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
