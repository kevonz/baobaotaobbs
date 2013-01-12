package com.baobaotao.domain.base;

import java.io.Serializable;

import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * <br><b>类描述:</b>
 * <pre>所示PO的父类</pre>
 *
 * @see
 */
public class BaseDomain implements Serializable {
    // 页号
    private int pageNo;
    // 每页大小
    private int pageSize;

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
