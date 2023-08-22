package com.demussong.object;


import java.util.List;


import java.util.Objects;

public class FieldsInfo {

    // 关键字
    private String columnWrap;

    // 逻辑字段
//    private Boolean logicFlag;

    // 模型别名
    private String modelAlias;

    // 字段别名
    private String columnCode;

    // 表 + 字段别名
    private String columnAliasCode;

    // 字段别名
    private String columnAs;

    //展示名
    private String showName;

    // 字段类型
    private String columnType;

    // 字段描述
    private String columnName;

    // 查询条件
    private List<String> queryOperator;

    // 是否加密
    private Boolean encryptFlag;

    // 是否为主键
    private Boolean primaryKeyFlag;

    // 样本数据
    private List<String> sampleData;

    // 是否加盐
    private Boolean saltFlag;

    // 基础字段（非函数调用）
    private Boolean basicFlag;

    private Integer order = Constants.DEFAULT_FIELD_ORDER;

    // 数据源是否需要解密
    private Boolean sourceNeedDecrypt;

    private Integer obsoleteFlag = Constants.DEFAULT_OBSOLETE_FLAG;



    private boolean booleanEquals(Boolean b1, Boolean b2) {
        if (b1 == null && b2 != null && b2) {
            return false;
        }
        if (b2 == null && b1 != null && b1) {
            return false;
        }
        return true;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FieldsInfo that = (FieldsInfo) o;
        return Objects.equals(columnWrap, that.columnWrap) && Objects.equals(modelAlias,
                that.modelAlias) && Objects.equals(columnCode, that.columnCode) && Objects.equals(
                columnAliasCode, that.columnAliasCode) && Objects.equals(columnAs, that.columnAs)
                && Objects.equals(showName, that.showName) && Objects.equals(columnType,
                that.columnType) && Objects.equals(columnName, that.columnName) && Objects.equals(
                queryOperator, that.queryOperator) && booleanEquals(encryptFlag, that.encryptFlag)
                && booleanEquals(primaryKeyFlag, that.primaryKeyFlag) && Objects.equals(sampleData,
                that.sampleData) && booleanEquals(saltFlag, that.saltFlag) && booleanEquals(basicFlag,
                that.basicFlag) && Objects.equals(order, that.order) && booleanEquals(
                sourceNeedDecrypt, that.sourceNeedDecrypt) && Objects.equals(obsoleteFlag, that.obsoleteFlag);
    }

    @Override
    public int hashCode() {
        return Objects.hash(columnWrap, modelAlias, columnCode, columnAliasCode, columnAs, showName, columnType,
                columnName, queryOperator, sampleData, order, obsoleteFlag);
    }

    public String getColumnWrap() {
        return columnWrap;
    }

    public void setColumnWrap(String columnWrap) {
        this.columnWrap = columnWrap;
    }

    public String getModelAlias() {
        return modelAlias;
    }

    public void setModelAlias(String modelAlias) {
        this.modelAlias = modelAlias;
    }

    public String getColumnCode() {
        return columnCode;
    }

    public void setColumnCode(String columnCode) {
        this.columnCode = columnCode;
    }

    public String getColumnAliasCode() {
        return columnAliasCode;
    }

    public void setColumnAliasCode(String columnAliasCode) {
        this.columnAliasCode = columnAliasCode;
    }

    public String getColumnAs() {
        return columnAs;
    }

    public void setColumnAs(String columnAs) {
        this.columnAs = columnAs;
    }

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public List<String> getQueryOperator() {
        return queryOperator;
    }

    public void setQueryOperator(List<String> queryOperator) {
        this.queryOperator = queryOperator;
    }

    public Boolean getEncryptFlag() {
        return encryptFlag;
    }

    public void setEncryptFlag(Boolean encryptFlag) {
        this.encryptFlag = encryptFlag;
    }

    public Boolean getPrimaryKeyFlag() {
        return primaryKeyFlag;
    }

    public void setPrimaryKeyFlag(Boolean primaryKeyFlag) {
        this.primaryKeyFlag = primaryKeyFlag;
    }

    public List<String> getSampleData() {
        return sampleData;
    }

    public void setSampleData(List<String> sampleData) {
        this.sampleData = sampleData;
    }

    public Boolean getSaltFlag() {
        return saltFlag;
    }

    public void setSaltFlag(Boolean saltFlag) {
        this.saltFlag = saltFlag;
    }

    public Boolean getBasicFlag() {
        return basicFlag;
    }

    public void setBasicFlag(Boolean basicFlag) {
        this.basicFlag = basicFlag;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Boolean getSourceNeedDecrypt() {
        return sourceNeedDecrypt;
    }

    public void setSourceNeedDecrypt(Boolean sourceNeedDecrypt) {
        this.sourceNeedDecrypt = sourceNeedDecrypt;
    }

    public Integer getObsoleteFlag() {
        return obsoleteFlag;
    }

    public void setObsoleteFlag(Integer obsoleteFlag) {
        this.obsoleteFlag = obsoleteFlag;
    }
}
