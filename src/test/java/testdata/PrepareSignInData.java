package testdata;

import models.SignInModel;
import utils.FakerMessageGenerator;

public class PrepareSignInData {

    public static SignInModel getValidData() {
        return SignInModel.builder()
                .email(FakerMessageGenerator.generateEmail())
                .password(FakerMessageGenerator.generatePassword())
                .build();
    }
}
