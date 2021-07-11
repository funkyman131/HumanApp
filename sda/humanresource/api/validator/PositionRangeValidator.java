package pl.sda.humanresource.api.validator;

import pl.sda.humanresource.api.model.NewWork;
import pl.sda.humanresource.config.WorkTypeConfig;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;

//public class PositionRangeValidator implements ConstraintValidator<PositionRange, NewWork> {
//
//
//    private WorkTypeConfig config;
//
//    @Override
//    public void initialize(PositionRange constraintAnnotation){
//        HashSet<String> types = new HashSet<>();
//        types.add("Sprzątanie");
//        types.add("Obsługa maszyny");
//        types.add("Obsługa wózka widłowego");
//        config = new WorkTypeConfig(types);
//    }
//
//    @Override
//    public boolean isValid(NewWork work, ConstraintValidatorContext constraintValidatorContext) {
//        return config.getTypes().contains(config);
//    }
//}
