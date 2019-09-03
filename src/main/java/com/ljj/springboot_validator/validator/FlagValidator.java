package com.ljj.springboot_validator.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author: ljj
 * @Date: 2019/9/3 11:14
 * @Description: 自定义注解
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = FlagValidatorClass.class)
public @interface FlagValidator {
    String values();
    String message() default "flag不存在";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
