package util.pojos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class getTodoPOJO {
    private int userId;
    private int id;
    private String title;
    private boolean completed;
}



