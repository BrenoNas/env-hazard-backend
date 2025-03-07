package com.breno.envhazardtracker.shared;
import jakarta.validation.*;
import java.util.Set;

public abstract class SelfValidating<T> {

    private final Validator validator;

    protected SelfValidating() {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            validator = factory.getValidator();
        }
   }

    /**
     * Evaluates all Bean Validations on the attributes of this
     * instance.
     */
     @SuppressWarnings("unchecked")
   protected void validateSelf() {
        Set<ConstraintViolation<T>> violations = validator.validate((T) this);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
