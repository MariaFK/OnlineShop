package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignInModel {

    private String email;
    private String password;
}
