package snippets.entity.composite_id.embedded_id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * EmbeddedId is applied for composite primary key which is Embeddable class.
 * Relationship mapping defined within embedded id class are not supported.
 *
 * There must be only one EmbeddedId annotation and no Id annotations.
 */
@Entity
@Table(name="composite_id_embedded_project")

@Getter
@Setter
@NoArgsConstructor
public class ProjectTwo {
    @EmbeddedId
    private ProjectTwoId id;
}
