package cmm.kubernetes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class DeploymentDto {

    private String name;
    private int replicas;
    private String namespace;

    @Builder
    public DeploymentDto(String name, int replicas, String namespace) {
        this.name = name;
        this.replicas = replicas;
        this.namespace = namespace;
    }
}
