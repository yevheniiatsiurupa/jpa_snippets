package snippets.entity.inheritance.mapped_superclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * This is parent non-entity (!!) class.
 * It describes common fields for child classes. They will be included in child tables.
 * Parent class itself is not mapped to any table.
 */
@MappedSuperclass

@Getter
@Setter
@NoArgsConstructor
public class SuperProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Integer price;
}
