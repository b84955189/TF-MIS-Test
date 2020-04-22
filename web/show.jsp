<%@ page import="top.lking.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="top.lking.utils.R" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //无缓存
    response.setHeader("Pragma","No-cache");
    response.setHeader("Cache-Control","no-cache");
    response.setDateHeader("Expires", -10);

    List<User> list=(List<User>) session.getAttribute(R.MesString.DATA_KEY);
%>
<html lang="zh-cn">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/my.css"/>
    <title>哈哈</title>
    <script type="text/javascript">
        var error_msg='';
        var context_path='${pageContext.request.contextPath}';
    </script>
</head>
<body>

    <div class="container">
     <jsp:include page="/html/TopPage.html" flush="true"></jsp:include>

       <table class="table table-hover table-bordered">
           <thead>

           <hr/>
           <a href="${pageContext.request.contextPath}/logout"><input type="button" class="btn btn-success" value="注销" style="float: right;"/></a>
           <div class="search_box">
               <form action="${pageContext.request.contextPath}/search.do" method="get">
                   <div class="input-group flex-nowrap">
                       <div class="input-group-prepend">
                           <span class="input-group-text">用户名</span>
                       </div>
                       <input type="text" class="form-control" name="<%=R.LoveQQSQLConfig.USER_LOGIN%>" placeholder="查找用户"/>
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
                <%
                    for (User user:list) {

                        %>
                        <tr id="tr_<%=user.getUser_id()%>">
                            <td><%=user.getUser_login()%></td>
                            <td><%=user.getUser_pass()%></td>
                            <td><%=user.getUser_register_time()%></td>
                            <td>
                               <a href="${pageContext.request.contextPath}/login"><input type="button" class="btn btn-warning" value="Delete" onclick="delUserAjax('<%=user.getUser_id()%>')"/></a>
                            </td>
                        </tr>
                        <%

                    }
                %>

           </tbody>
       </table>
    </div>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/proper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
</body>
</html>
<%--By: Jason.Date: 3/31/2020 3:33 PM--%>