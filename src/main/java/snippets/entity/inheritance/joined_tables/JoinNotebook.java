package snippets.entity.inheritance.joined_tables;

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
@Table(name="inheritance_joined_table_notebook")
@Getter
@Setter
@NoArgsConstructor
public class JoinNotebook extends JoinProduct {

    @Column(name = "pages")
    private Integer pages;
}
