package cn.domain;

import java.util.List;
//页面信息类，用来封装页面信息
public class PageBean<T> {   //加泛型，便于操作多种数据
    private int pageSum;   //总页数
    private int infoSum;    //总信息数
    private int currentPage; //当前页码
    private int rows;  //每页数据多少
    private List<T> list; //每页存放的数据；

    public int getPageSum() {
        return pageSum;
    }

    public void setPageSum(int pageSum) {
        this.pageSum = pageSum;
    }

    public int getInfoSum() {
        return infoSum;
    }

    public void setInfoSum(int infoSum) {
        this.infoSum = infoSum;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pageSum=" + pageSum +
                ", infoSum=" + infoSum +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                ", list=" + list +
                '}';
    }
}
