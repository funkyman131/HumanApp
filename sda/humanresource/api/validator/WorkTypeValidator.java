package pl.sda.humanresource.api.validator;


import pl.sda.humanresource.config.WorkTypeConfig;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class WorkTypeValidator implements ConstraintValidator<WorkType, String> {

    private static final List<String> WORK_TYPES =
            Arrays.asList("Sprzątanie", "Obsługa maszyny", "Obsługa wózka widłowego");

    @Override
    public void initialize(WorkType constraintAnnotation){

    }

//    @Autowired
//    private WorkTypeConfig config;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
       return WORK_TYPES.contains(value);
//        return config.getTypes().contains(value.toLowerCase());
    }
}
