package com.demussong.enums;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/11/1 19:35
 */
public enum JoinTypeEnum {
    inner("INNER JOIN"),
    left("LEFT JOIN");

    String joinVal;

    private JoinTypeEnum(String joinVal) {
        this.joinVal = joinVal;
    }

    public static JoinTypeEnum getTypeByValue(String source) {

        for (JoinTypeEnum value : values()) {
            if (value.name().equals(source)) {
                return value;
            }
        }
        return null;
    }

    public String getJoinVal() {
        return joinVal;
    }

}
