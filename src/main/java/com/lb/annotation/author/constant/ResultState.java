package com.lb.annotation.author.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : lb
 * @date : 2020/9/4 10:53
 * @description :
 */
public enum  ResultState {

    SUCCESS(10000, "成功"),
    FAIL(10001, "失败"),
    SYSTEM_EXCEPTION(10005, "系统异常！"),
    WRONG_PARAM(10003, "参数错误！"),
    USER_ERROR(10004, "用户登入异常！");

    private Integer resCode;

    private String resDesc;

    public final static String RES_CODE = "resCode";
    public final static String RES_DESC = "resDesc";
    public final static String DATA = "data";

    ResultState(Integer resCode, String resDesc){
        this.resCode = resCode;
        this.resDesc = resDesc;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<>();
        map.put(RES_CODE, resCode);
        map.put(RES_DESC, resDesc);
        return map;
    }

    public Map<String, Object> toMap(Object data) {
        Map<String, Object> map = toMap();
        map.put(DATA, data);
        return map;
    }

}
