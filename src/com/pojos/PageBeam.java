package com.pojos;

import java.io.Serializable;
import java.util.List;

public class PageBeam implements Serializable {
    public  PageBeam(){}
    private Integer pageNumber;   //当前页面
    private Integer pageSize;   //每页数据
    private Integer recods;   //所有
    private Integer startPage;
    private Integer endpage;
    private Integer allPages;
    private Integer startIndex;   //每页开始页面的第一个下标索引
    private List<Shop> shops;

    @Override
    public String toString() {
        return "PageBeam{" +
                "pageNumber=" + pageNumber +
                ", pageSize=" + pageSize +
                ", recods=" + recods +
                ", startPage=" + startPage +
                ", endpage=" + endpage +
                ", allPages=" + allPages +
                ", startIndex=" + startIndex +
                ", shops=" + shops +
                '}';
    }

    public PageBeam(int pageNumber, int pageSize, int recods)
    {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.recods = recods;
        if (recods%pageSize==0)
        {
            this.allPages = recods/pageSize;
        }
        else
        {
            this.allPages = recods/pageSize+1;
        }
        this.startIndex = pageSize*(pageNumber-1);
        this.startPage=1;
        this.endpage=5;
        if (allPages<=5) {
            this.startPage = 1;
            this.endpage = this.allPages;
        }
        else
            {
                this.startPage = this.pageNumber-2;
                this.endpage = this.pageNumber+2;
                if (startPage < 1)
                {
                    this.startPage = 1;
                    this.endpage = 5;
                }
                if (endpage > allPages)
                {
                    this.startPage = endpage-4;
                    this.endpage = this.allPages;
                }
        }


    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getRecods() {
        return recods;
    }

    public void setRecods(Integer recods) {
        this.recods = recods;
    }

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getEndpage() {
        return endpage;
    }

    public void setEndpage(Integer endpage) {
        this.endpage = endpage;
    }

    public Integer getAllPages() {
        return allPages;
    }

    public void setAllPages(Integer allPages) {
        this.allPages = allPages;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(Integer startIndex) {
        this.startIndex = startIndex;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
