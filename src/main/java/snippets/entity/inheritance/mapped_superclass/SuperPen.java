package snippets.entity.inheritance.mapped_superclass;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * This is child entity class.
 * Id column is specified in the parent class.
 */
@Entity
@Table(name="inheritance_mapped_superclass_pen")

@Getter
@Setter
@NoArgsConstructor
public class SuperPen extends SuperProduct {

    @Column(name = "color")
    private String color;
}
