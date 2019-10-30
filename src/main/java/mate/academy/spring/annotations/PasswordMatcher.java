package mate.academy.spring.annotations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import mate.academy.spring.dto.UserRegistrationDto;

public class PasswordMatcher
        implements ConstraintValidator<Matched, Object> {

    @Override
    public void initialize(Matched constraintAnnotation) {}

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        UserRegistrationDto dto = (UserRegistrationDto) object;
        return dto.getPassword().equals(dto.getRepeatPassword());
    }
}
