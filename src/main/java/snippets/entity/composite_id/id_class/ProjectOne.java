package snippets.entity.composite_id.id_class;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * IdClass is used to specify a composite primary key
 * that is mapped to multiple fields or properties of the entity.
 *
 * Names of the entity fields and their types must match the fields and types
 * from the id class.
 */
@Entity
@Table(name="composite_id_class_project")
@IdClass(ProjectOneId.class)

@Getter
@Setter
@NoArgsConstructor
public class ProjectOne {
    @Id
    private Integer departmentId;

    @Id
    private Long projectId;
}
