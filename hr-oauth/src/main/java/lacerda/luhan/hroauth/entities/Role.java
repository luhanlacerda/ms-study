package lacerda.luhan.hroauth.entities;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Role implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String roleName;

}
