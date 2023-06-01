package com.book.project.domain.Exception;

import com.book.project.domain.Common.ResultCode;

public class BusinessException extends RuntimeException {

    private ResultCode errorCode;

    public BusinessException(ResultCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ResultCode getErrorCode() {
        return errorCode;
    }

}
