package validatePassword.validators;

import validatePassword.exceptions.ValidateException;
import validatePassword.exceptions.ValidateNameException;

public class NameValidator implements Validator {
    @Override
    public void validate(String value) throws ValidateException {
        if (value == null || value.isEmpty()) {
            throw new ValidateNameException("Имя не должно быть пустым");
        }
    }
}