package com.book.project.domain.Common;

public enum ResultCode {
    OK(0, "success"),
    FAIL(-1, "서비스 이용 중 오류가 발생했습니다. 잠시 후 다시 시도해주세요."),
    INVALID_PARAMETER(-2, "유효하지 않은 파라미터 입니다."),
    METHOD_NOT_ALLOWED(-3, "지원하지 않는 메서드 요청 입니다."),
    URL_RESOURCE_NOT_FOUND(-4, "요청 리소스 정보를 찾을 수 없습니다."),
    RESOURCE_NOT_FOUND(-5, "리소스 정보를 찾을 수 없습니다."),
    INVALID_TOKEN(-6, "비정상적인 접근 입니다."),

    NOT_EXIST_CATEGORY(101, "존재하지 않습니다."),
    NOT_EXIST_PARENT(102, "상위 값이 존재하지 않습니다.")
    ;

    private int code;
    private String message;

    ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
