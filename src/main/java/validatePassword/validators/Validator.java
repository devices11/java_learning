package validatePassword.validators;

import validatePassword.exceptions.ValidateException;

public interface Validator {
    void validate(String value) throws ValidateException;
}