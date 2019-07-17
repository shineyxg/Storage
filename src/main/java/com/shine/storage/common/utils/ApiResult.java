package com.shine.storage.common.utils;

/**
 * @author : shine
 * @Project: Storage
 * @Description: 接口返回类
 * @date: 2018年10月21日 13:47
 */
public class ApiResult<T extends Object> {

    public static final int SUCCESS_CODE = 0;
    public static final int COMMON_FAILED_CODE = 1;
    public static final int ACCESS_TIMEOUT = 2;

    private int code;
    private String message;
    private Long timeStamp;
    private T data;

    public static ApiResult success(){
        return success("", "");
    }
    public static ApiResult success(Object data){
        return success("", data);
    }
    public static ApiResult success(String message, Object data){
        ApiResult result = new ApiResult();
        result.setCode(SUCCESS_CODE);
        result.setMessage(message);
        result.setTimeStamp(System.currentTimeMillis());
        result.setData(data);
        return result;
    }

    public static ApiResult failed(String message) {
        return failed(COMMON_FAILED_CODE, message);
    }
    public static ApiResult failed(int code, String message) {
        ApiResult result = new ApiResult();
        result.setCode(code);
        result.setMessage(message);
        result.setTimeStamp(System.currentTimeMillis());
        result.setData("");
        return result;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

}
