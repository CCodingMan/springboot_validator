package com.ljj.springboot_validator.entity;

import com.ljj.springboot_validator.validator.FlagValidator;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Tolerate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @Auther: ljj
 * @Date: 2019/9/3 10:28
 * @Description:
 */
@Data
@Builder
public class DemoEntity implements Serializable {
    @NotBlank
    @NotNull
    @Length(min = 2, max = 10)
    private String name;

    @Min(value = 1)
    private int age;

    @NotBlank
    @Email
    private String email;

    @FlagValidator(values = "1,2,3")
    private String flag;

    @Tolerate
    public DemoEntity() {
    }
}
