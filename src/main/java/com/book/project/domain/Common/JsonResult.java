package com.book.project.domain.Common;

import lombok.Getter;


@Getter
public class JsonResult {
    private int code;
    private String message;
    private Object data;

    public JsonResult(int code, String message) {
        this(code, message, null);
    }

    public JsonResult(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static JsonResult createJsonResult(ResultCode code) {
        return new JsonResult(
                code.getCode(),
                code.getMessage());
    }

    public static JsonResult createJsonResult(ResultCode code, Object data) {
        return new JsonResult(
                code.getCode(),
                code.getMessage(),
                data);
    }
}
