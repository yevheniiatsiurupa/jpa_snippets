package snippets.entity.inheritance.single_table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * This is parent entity (!!) class.
 * Single table type of strategy creates one table for all classes of the hierarchy
 *
 * Inheritance - type of inheritance, default Single Table
 * DiscriminatorColumn - column which holds values for differentiation of child entities,
 * default name for the column - DTYPE, but could be customized
 */
@Entity
@Table(name="inheritance_single_table_product")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="product_type")

@Getter
@Setter
@NoArgsConstructor
public class SingleProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Integer price;
}
