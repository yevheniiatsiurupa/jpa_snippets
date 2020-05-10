package snippets.entity.composite_id.id_class;

import lombok.Data;

import java.io.Serializable;

@Data
public class ProjectOneId implements Serializable {
    private Integer departmentId;
    private Long projectId;
}
