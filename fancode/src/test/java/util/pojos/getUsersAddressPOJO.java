package util.pojos;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class getUsersAddressPOJO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private getUsersAddressGeoPOJO geo;
}
