package util.pojos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class getUsersPOJO {
    private int id;
    private String name;
    private String username;
    private String email;
    private getUsersAddressPOJO address;
    private String phone;
    private String website;
    private getUsersCompanyPOJO company;

}



