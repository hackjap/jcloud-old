package cmm.kubernetes;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class NodeDto {

    private String name;
    private String status; // status/conditions/type : ready
    private String address; // status/addresses/address

    @Builder
    public NodeDto(String name, String status, String address) {
        this.name = name;
        this.status = status;
        this.address = address;
    }
}
