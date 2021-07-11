package pl.sda.humanresource.api.validator;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = WorkTypeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WorkType {

    String message() default "Unknown work type";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
