package com.demussong.enums;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/9/28 19:50
 */


public enum FileVisitPatternEnum {

    unsupported("/**"),pub("/api/pub"),esb("/api/esb"),sso("/api/sso");

    private String pathPrefix;

    private FileVisitPatternEnum(String pathPrefix) {

        this.pathPrefix=pathPrefix;
    }

    public String getPathPrefix() {
        return pathPrefix;
    }

    public void setPathPrefix(String pathPrefix) {
        this.pathPrefix = pathPrefix;
    }

    public static FileVisitPatternEnum getByPath(String path) {

        for(FileVisitPatternEnum tmp:FileVisitPatternEnum.values()) {

            if(path!=null&&path.startsWith(tmp.getPathPrefix())) {

                return tmp;
            }
        }
        return unsupported;
    }
}

