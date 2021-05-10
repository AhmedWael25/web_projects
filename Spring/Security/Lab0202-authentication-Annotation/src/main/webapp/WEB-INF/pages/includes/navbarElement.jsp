<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>--%>
<%--<%@taglib prefix="security" uri="http://www.springframework.org/security/tags" %>--%>
<%--<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%--<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="${contextPath}">Home</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav">

                <li class="nav-item">
                    <a class="nav-link" href="#">Features</a>
                </li>

                <security:authorize access="hasAuthority('ROLE_ADMIN')" >
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/admin/dashboard">DashBoard</a>
                    </li>
                </security:authorize>

                <security:authorize access="hasAuthority('ROLE_USER')" >
                    <li class="nav-item">
                        <a class="nav-link" href="${contextPath}/profile">Profile</a>
                    </li>
                </security:authorize>

                <security:authorize access="!isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${contextPath}/login">Login</a>
                    </li>
                </security:authorize>

                <security:authorize access="isAuthenticated()">
                    <li class="nav-item">
                        <a class="nav-link active" aria-current="page" href="${contextPath}/logout">Logout</a>
                    </li>
                </security:authorize>

                <li class="nav-item">
                    <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                </li>
            </ul>
        </div>
    </div>
</nav>