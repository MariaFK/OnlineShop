package testdata;

import models.NewAddressModel;
import utils.FakerMessageGenerator;

public class PrepareNewAddressData {

    public static NewAddressModel getValidData() {
        return NewAddressModel.builder()
                .company(FakerMessageGenerator.generateCompany())
                .address(FakerMessageGenerator.generateAddress())
                .city(FakerMessageGenerator.generateCity())
                .state("Florida")
                .zipcode(FakerMessageGenerator.generateZipcodePassword())
                .homePhone(FakerMessageGenerator.generateHomePhone())
                .mobilePhone(FakerMessageGenerator.generateMobilePhone())
                .addressTitle(FakerMessageGenerator.generateAddressTitle())
                .build();
    }
}
