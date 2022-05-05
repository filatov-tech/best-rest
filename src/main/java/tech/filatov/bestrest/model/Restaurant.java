package tech.filatov.bestrest.model;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant extends AbstractNamedEntity{

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Vote> votes;

    @OneToMany(fetch = FetchType.LAZY)
    private Set<Dish> dishes;

    public Restaurant(Integer id, String name) {
        super(id, name);
    }
}
