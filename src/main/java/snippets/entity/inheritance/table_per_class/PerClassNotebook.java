package snippets.entity.inheritance.table_per_class;

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
@Table(name="inheritance_table_per_class_notebook")

@Getter
@Setter
@NoArgsConstructor
public class PerClassNotebook extends PerClassProduct {

    @Column(name = "pages")
    private Integer pages;
}
