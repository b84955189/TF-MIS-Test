<%@ page import="top.lking.utils.R" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--加载遮罩--%>
<jsp:include page="<%=request.getContextPath()+R.FrontPageNames.LOADING_PAGE%>" flush="true"></jsp:include>

<div class="jumbotron">
    <h1 class="display-5">Everything is object.</h1>
    <p class="lead">I'm Jason,from China.</p>
    <hr class="my-4"/>
    <span id="error_msg" class="display-5" style="color: red;"></span>
</div>