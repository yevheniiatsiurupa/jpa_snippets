package snippets.entity.inheritance.joined_tables;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * This is parent entity (!!) class.
 * Joined table type of strategy creates one table for each class of the hierarchy.
 * Id column is specified in parent table, but will be present in each table and will be
 * used for joining tables when needed.
 *
 * Inheritance - type of inheritance
 */
@Entity
@Table(name="inheritance_joined_table_product")
@Inheritance(strategy = InheritanceType.JOINED)

@Getter
@Setter
@NoArgsConstructor
public class JoinProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private Integer price;
}
