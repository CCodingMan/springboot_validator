package com.ljj.springboot_validator.controller;

import com.ljj.springboot_validator.entity.DemoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

/**
 * @Auther: ljj
 * @Date: 2019/9/3 10:42
 * @Description:
 */
@RestController
public class IndexController {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/vaildator")
    public String vaildator(@Valid DemoEntity demoEntity, BindingResult bindingResult){
        StringBuffer msg = new StringBuffer();
        if (bindingResult.hasErrors()){
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            Locale currentLocal = LocaleContextHolder.getLocale();
            for (FieldError fieldError: fieldErrors){
                String errorMessage = messageSource.getMessage(fieldError, currentLocal);
                msg.append(String.format("%s:%s,", fieldError.getField(), errorMessage));
            }
            return msg.toString();
        }
        return String.format("验证通过,用户名称：%s，用户年龄：%d, 用户邮箱：%s"
                , demoEntity.getName()
                , demoEntity.getAge()
                , demoEntity.getEmail());
    }

}
