<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="ClientHeader.jsp" %>

<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html lang="en">

<body data-gr-c-s-loaded="true" style="">

<div id="wrapper">


    <div id="page-wrapper">

        <div class="row">
            <div class="col-lg-6">

                <span>${principal.username}</span>
                <label>${principal.id}</label>
                <form employeeRole="form" action="/report/save" method="post">
                    <c:set var="report" value="${report}"/>
                    <div class="form-group">
                        <label>Tittle</label>
                        <input class="form-control" id="tittle" placeholder="${report.tittle}">
                    </div>

                    <div class="form-group">
                        <label>Report content</label>
                        <textarea class="form-control" id="content">${report.content}</textarea>
                    </div>

                    <button type="submit" class="btn btn-default">Save</button>
                    <button type="reset" class="btn btn-default">Cancel</button>

                </form>

            </div>

        </div>
    </div>
</div>


</body>
</html>
