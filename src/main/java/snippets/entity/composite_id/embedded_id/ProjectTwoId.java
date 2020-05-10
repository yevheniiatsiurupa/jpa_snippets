package snippets.entity.composite_id.embedded_id;

import lombok.Data;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ProjectTwoId implements Serializable {
    private Integer departmentId;
    private Long projectId;
}
