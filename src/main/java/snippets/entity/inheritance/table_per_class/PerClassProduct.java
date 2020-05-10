package snippets.entity.inheritance.table_per_class;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * This is parent entity (!!) class.
 * Table per class type of strategy creates one table for each class of the hierarchy.
 * Columns from parent class will be present in tables of each child class.
 *
 * Inheritance - type of inheritance
 */
@Entity
@Table(name="inheritance_table_per_class_product")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Getter
@Setter
@NoArgsConstructor
public class PerClassProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "price")
    private Integer price;
}
