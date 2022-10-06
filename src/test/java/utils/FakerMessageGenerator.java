package utils;

import com.github.javafaker.Faker;


public class FakerMessageGenerator {

    public static String generateEmail() {
        return new Faker().internet().emailAddress();
    }

    public static String generatePassword() {
        return new Faker().internet().password();
    }

    public static String generateCompany() {
        return new Faker().company().name();
    }

    public static String generateAddress() {
        return new Faker().address().streetAddress();
    }

    public static String generateCity() {
        return new Faker().address().city();
    }

    public static String generateZipcodePassword() {
        return new Faker().number().digits(5);
    }

    public static String generateHomePhone() {
        return new Faker().phoneNumber().cellPhone();
    }

    public static String generateMobilePhone() {
        return new Faker().phoneNumber().cellPhone();
    }

    public static String generateAddressTitle() {
        return new Faker().harryPotter().character().toUpperCase();
    }




}
