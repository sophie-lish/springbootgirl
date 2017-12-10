package com.liush.girl.exception;

import com.liush.girl.enums.ResultEnum;
import lombok.Getter;

@Getter
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
