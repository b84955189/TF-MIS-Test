<%@ page import="top.lking.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="top.lking.utils.R" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    //无缓存
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", -10);

%>
<html lang="zh-cn">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/LoadingPage.scss"/>
    <title>哈哈</title>
    <script type="text/javascript">
        var error_msg='';
        var context_path='${pageContext.request.contextPath}';
    </script>
</head>
<body>

    <div class="container">
     <jsp:include page="<%=request.getContextPath()+R.FrontPageNames.TOP_PAGE%>" flush="true"></jsp:include>
        <a href="<%=request.getContextPath()+R.ServletNames.LOGOUT_SERVLET%>"><button class="btn badge-danger">注销</button></a>

        <table class="table table-hover table-bordered">
                <thead>

                <hr/>


                    <div class="col-sm-6" style="padding-left: 0px">
                        <form action="<%=request.getContextPath()+R.ServletNames.SEARCH_SERVLET%>" method="get">
                            <div class="input-group flex-nowrap">
                                <div class="input-group-prepend">
                                    <span class="input-group-text">用户名</span>
                                </div>
                                <input type="text" class="form-control" name="<%=R.RequestParamName.TYPE_USER_LOGIN%>" placeholder="查找用户"/>
                                <div class="input-group-append">
                                    <button type="submit" class="btn btn-primary btn-group-sm">搜索</button>
                                </div>
                            </div>
                        </form>
                    </div>






                <tr>
                    <th>User Name</th>
                    <th>Password</th>
                    <th>Create Date</th>
                    <th>Delete</th>
                </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.page_data.currentPageData}" var="tempPageData">
                        <tr id="tr_${tempPageData.user_id}">
                            <td>${tempPageData.user_login}</td>
                            <td>${tempPageData.user_pass}</td>
                            <td>${tempPageData.user_register_time}</td>
                            <td>
                                <a href="#">
                                    <input type="button" class="btn btn-warning disabled" value="删除"/>
                                </a>
                            </td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>

        <%--底部页码--%>
       <nav aria-label="pagination nav">
           <ul class="pagination justify-content-end" style="margin-top: 10px;">
               <c:choose>
                   <c:when test="${requestScope.page_data.currentPageCount==requestScope.page_data.startPageCount}">
                       <li class="page-item disabled"><a class="page-link" tabindex="-1" href="#"><span>&laquo;</span></a></li>
                   </c:when>
                   <c:otherwise>
                       <li class="page-item"><a class="page-link" tabindex="-1" href="${pageContext.request.contextPath}<%=R.ServletNames.SEARCH_SERVLET%>?${requestScope.page_data.queryType}=${requestScope.page_data.snippet}&<%=R.RequestParamName.PAGE_COUNT%>=${requestScope.page_data.currentPageCount-1}"><span>&laquo;</span></a></li>
                   </c:otherwise>
               </c:choose>

               <%--页码省略 标记变量--%>
               <c:set var="front_pagination" value="true" scope="request"/>
               <c:set var="back_pagination" value="true" scope="request"/>
               <%--页码省略间隔--%>
               <c:set var="pagination_interval" value="2" scope="request"/>
                <c:forEach var="page_num" begin="1" end="${requestScope.page_data.endPageCount}" step="1">
                    <c:choose>
                        <c:when test="${requestScope.page_data.currentPageCount==page_num}">
                            <li class="page-item active"><a class="page-link" href="${pageContext.request.contextPath}<%=R.ServletNames.SEARCH_SERVLET%>?${requestScope.page_data.queryType}=${requestScope.page_data.snippet}&<%=R.RequestParamName.PAGE_COUNT%>=${page_num}">${page_num}</a></li>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${page_num!=requestScope.page_data.startPageCount&&requestScope.page_data.currentPageCount-page_num>pagination_interval}">
                                    <c:if test="${front_pagination==true}">
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                    </c:if>
                                    <%--设置标记，只输出一次--%>
                                    <c:set var="front_pagination" value="false" scope="request"/>

                                </c:when>
                                <c:when test="${requestScope.page_data.endPageCount!=page_num&&page_num-requestScope.page_data.currentPageCount>pagination_interval}">
                                    <c:if test="${back_pagination==true}">
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                    </c:if>
                                    <%--设置标记，只输出一次--%>
                                    <c:set var="back_pagination" value="false" scope="request"/>
                                </c:when>
                                <c:otherwise>
                                    <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}<%=R.ServletNames.SEARCH_SERVLET%>?${requestScope.page_data.queryType}=${requestScope.page_data.snippet}&<%=R.RequestParamName.PAGE_COUNT%>=${page_num}">${page_num}</a></li>
                                </c:otherwise>
                            </c:choose>



                        </c:otherwise>
                    </c:choose>

                </c:forEach>
               <c:choose>
                   <c:when test="${requestScope.page_data.endPageCount==requestScope.page_data.currentPageCount}">
                       <li class="page-item disabled"><a class="page-link" href="#"><span>&raquo;</span></a></li>
                   </c:when>
                   <c:otherwise>
                       <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}<%=R.ServletNames.SEARCH_SERVLET%>?${requestScope.page_data.queryType}=${requestScope.page_data.snippet}&<%=R.RequestParamName.PAGE_COUNT%>=${requestScope.page_data.currentPageCount+1}"><span>&raquo;</span></a></li>
                   </c:otherwise>
               </c:choose>

           </ul>
       </nav>


    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/proper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
</body>
</html>
<%--By: Jason.Date: 3/31/2020 3:33 PM--%>