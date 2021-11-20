package com.atiguigu.pojo;

import java.util.List;

public class Page<T> {
    public static final Integer PAGE_SIZE = 4;
    private Integer pageNo;
    private Integer pageSize = PAGE_SIZE;
    private Integer pageTotal;
    private Integer pageTotalCount;
    private List<T> items;
    private String url;
private Integer min;

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    private Integer max;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
//        if (pageNo < 1) {
//            pageNo = 1;
//        }
//        if (pageNo > pageTotal) {
//            pageNo = pageTotal;
//        }
        this.pageNo = pageNo;

    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "pageNo:" + pageNo + "pageSize:" + pageSize + "pageTotal:" + pageTotal + "pageTotalCount:" + pageTotalCount + "items:" + items+"url:"+url+"min:"+min+"max:"+max;
    }
}
