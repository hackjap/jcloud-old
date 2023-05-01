package cmm.kubernetes;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@Data
public class CreateDeploymentVo {

    private String name;
    private String imageName;
//    private String replicas;
    private String namespace;

}
