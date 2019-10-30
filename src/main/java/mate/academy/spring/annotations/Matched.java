package mate.academy.spring.annotations;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Constraint(validatedBy = PasswordMatcher.class)
@Documented
public @interface Matched {
    String message() default "Passwords have to match!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
