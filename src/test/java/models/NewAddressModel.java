package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewAddressModel {

    private String company;
    private String address;
    private String city;
    private String state;
    private String zipcode;
    private String homePhone;
    private String mobilePhone;
    private String addressTitle;

}
