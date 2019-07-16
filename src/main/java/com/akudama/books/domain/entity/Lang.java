package com.akudama.books.domain.entity;

import com.akudama.books.domain.LangKind;
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
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "LANGS")
public class Lang {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lang_id", unique = true)
    private Long id;

    @Enumerated(EnumType.STRING)
    private LangKind value;

    @ManyToMany(mappedBy = "langs")
    private Set<HomeCollectionItem> homeCollectionItems;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lang lang = (Lang) o;
        return value == lang.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
