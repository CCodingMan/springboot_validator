package com.ljj.springboot_validator.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Auther: ljj
 * @Date: 2019/9/3 11:22
 * @Description: 自定义注解类
 */
public class FlagValidatorClass implements ConstraintValidator<FlagValidator, Object> {
    private String values;

    @Override
    public void initialize(FlagValidator constraintAnnotation) {
        this.values = constraintAnnotation.values();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        String[] value_array = values.split(",");
        boolean isFlag = false;
        for (String str: value_array){
            if (str.equals(value)){
                isFlag = true;
                break;
            }
        }
        return isFlag;
    }
}
