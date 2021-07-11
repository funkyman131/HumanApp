package pl.sda.humanresource.api;

import pl.sda.humanresource.api.model.Errors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;

@RestControllerAdvice
public class HRAppErrorHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(HRAppErrorHandler.class);

    @ExceptionHandler(IllegalStateException.class)
    public Errors handleIllegalError(IllegalStateException ex) {
        LOGGER.error("Error", ex);
        return Errors.builder().errors(Collections.singletonList(ex.getMessage())).build();
    }
}
