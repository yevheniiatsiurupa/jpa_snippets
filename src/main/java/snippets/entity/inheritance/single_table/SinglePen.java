package snippets.entity.inheritance.single_table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * This is child entity class
 * Table name is taken from parent class.
 * Id column is specified in the parent class.
 * Columns have to be nullable.
 *
 * DiscriminatorValue - value for differentiation of child entity in the table.
 */
@Entity
@DiscriminatorValue("PN")
@Getter
@Setter
@NoArgsConstructor
public class SinglePen extends SingleProduct {

    @Column(name = "color")
    private String color;
}
