package service.validator;

import entity.Authorization;

public class GredentionalValidator {
    public static boolean isCorrect(Authorization authorization){
        return isLoginCorrect(authorization.getLogin()) && isPasswordCorrect(authorization.getPassword());
    }

    public static boolean isLoginCorrect(String login) {
        return login.length() > 2;
    }

    public static boolean isPasswordCorrect(String password){
        return password.length() > 2;
    }
}
