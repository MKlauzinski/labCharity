<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<nav class="container container--70">
    <ul class="nav--actions">
        <sec:authorize access="isAuthenticated()">
            <li class="logged-user">
                Witaj Marcin
                <ul class="dropdown">
                    <li><a href="#">Profil</a></li>
                    <li><a href="#">Moje zbiórki</a></li>
                    <li><a href="javascript: document.logoutForm.submit()">Wyloguj</a></li>
                    <form name="logoutForm" action="<c:url value="/logout"/>" method="post" hidden="true">
                        <input hidden type="submit" value="Wyloguj">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    </form>
                </ul>
            </li>
        </sec:authorize>
        <sec:authorize access="!isAuthenticated()">
            <ul class="nav--actions">
                <li><a href="/login/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="#" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </ul>
        </sec:authorize>
    </ul>

    <ul>
        <li><a href="/" class="btn btn--without-border">Start</a></li>
        <li><a href="/#steps" class="btn btn--without-border">O co chodzi?</a></li>
        <li><a href="/#about-us" class="btn btn--without-border">O nas</a></li>
        <li><a href="/#help" class="btn btn--without-border">Fundacje i organizacje</a></li>
        <sec:authorize access="isAuthenticated()">
            <li><a href="donation" class="btn btn--without-border">Przekaż dary</a></li>
        </sec:authorize>
        <li><a href="#contact" class="btn btn--without-border">Kontakt</a></li>
    </ul>
</nav>

