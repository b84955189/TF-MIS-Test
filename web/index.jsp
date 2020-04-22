<%@ page import="top.lking.utils.R" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>

    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css"/>
    <title>欢迎</title>
    <script type="text/javascript">
        var error_msg='${sessionScope.session_msg}';
    </script>
</head>
<body>
    <div class="container">

        <jsp:include page="<%=request.getContextPath()+R.FrontPageNames.TOP_PAGE%>" flush="true"></jsp:include>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div class="form-group">
                <div class="form-row">
                    <div class="col">
                        <label for="account_input">用户名</label>
                        <input id="account_input" type="text" onfocus="cleanError();" class="form-control" name="<%=R.LoveQQSQLConfig.USER_LOGIN%>" placeholder="用户名"/>
                    </div>
                    <div class="col">
                        <label for="passwd_input">密码</label>
                        <input id="passwd_input" type="password" onfocus="cleanError();" class="form-control" name="<%=R.LoveQQSQLConfig.USER_PASS%>" placeholder="密码"/>
                    </div>

                </div>
                <div class="form-group" style="margin-top: 10px;text-align: center">
                    <input type="submit" class="btn btn-primary" value="登录"/>
                    <a href="${pageContext.request.contextPath}/register.jsp"><input type="button" class="btn btn-success" value="注册"/></a>
                </div>

            </div>
        </form>

    </div>
    <%
        session.removeAttribute(R.MesString.MSG_KEY);
    %>
    <script src="${pageContext.request.contextPath}/js/jquery-3.3.1.slim.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/proper.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/my.js"></script>
</body>
</html>
<%--By: Jason.Date: 3/31/2020 3:33 PM--%>