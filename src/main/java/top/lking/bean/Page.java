package top.lking.bean;

import lombok.Data;

import java.util.List;

/**
 * 分页Bean
 * @author Jason
 * @version 1.0
 * @date 4/25/2020 3:16 PM
 */
@Data
public class Page {
    //起始页码
    private int startPageCount;
    //结束页码
    private int endPageCount;
    //当前页码
    private int currentPageCount;
    //数据总量
    private int totalData;
    //页面数据查询方式
    private String queryType;
    //查询片段
    private String snippet;

    //当前页数据
    private List<User> currentPageData;




}
