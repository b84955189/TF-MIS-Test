<%@ page import="top.lking.utils.R" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--加载遮罩-----注意在服务器内部调用的路径与浏览器调用的路径问题--下面注释掉的，在服务器里是错误的，注意理解！！！--%>
<%--<jsp:include page="<%=request.getContextPath()+R.FrontPageNames.LOADING_PAGE%>" flush="true"></jsp:include>--%>

<jsp:include page="<%=R.FrontPageNames.LOADING_PAGE%>" flush="true"></jsp:include>

<div class="jumbotron">
    <h1 class="display-5">Everything is object.</h1>
    <p class="lead">I'm Jason,from China.</p>
    <hr class="my-4"/>
    <span id="error_msg" class="display-5" style="color: red;"></span>
</div>