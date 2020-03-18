<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/donation"/>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Donation</title>
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<%@include file="form-header.jsp" %>

<section class="form--steps">
    <div class="form--steps-instructions">
        <div class="form--steps-container">
            <h3>Ważne!</h3>
            <p data-step="1" class="active">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="2">
                Uzupełnij szczegóły dotyczące Twoich rzeczy. Dzięki temu będziemy
                wiedzieć komu najlepiej je przekazać.
            </p>
            <p data-step="3">
                Wybierz jedną, do
                której trafi Twoja przesyłka.
            </p>
            <p data-step="4">Podaj adres oraz termin odbioru rzeczy.</p>
        </div>
    </div>

    <div class="form--steps-container">
        <div class="form--steps-counter">Krok <span>1</span>/4</div>

        <form:form action="${contextPath}" method="post" modelAttribute="donation">
            <!-- STEP 1: class .active is switching steps -->
            <div data-step="1" class="active">
                <h3>Zaznacz co chcesz oddać:</h3>

                <form:errors path="categories" cssClass="error"/>
                    <c:forEach items="${categorieslist}" var="category">
                        <div class="form-group form-group--checkbox">
                            <label>
                                <input path="categories" type="checkbox" name="categories" value="${category.id}" multiple="true"/>
                                <span class="checkbox"></span>
                                <span class="description">${category.name}</span>
                            </label>
                        </div>
                    </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 2 -->
            <div data-step="2">
                <h3>Podaj liczbę 60l worków, w które spakowałeś/aś rzeczy:</h3>

                <div class="form-group form-group--inline">
                    <label>
                        Liczba 60l worków:
                        <form:errors path="quantity" cssClass="error"/>
                        <form:input path="quantity" type="number" name="bags" step="1" min="1"/>
                    </label>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>


            <!-- STEP 4 -->
            <div data-step="3">
                <h3>Wybierz organizacje, której chcesz pomóc:</h3>

                <form:errors path="institution" cssClass="error"/>
                <c:forEach items="${institutions}" var="institut">
                    <div class="form-group form-group--checkbox">
                        <label>
                            <form:input path="institution" name="institution" value="${institut.id}"/>
                            <span class="checkbox radio"></span>
                            <span class="description">
                                <div id="institution" class="title">Fundacja "${institut.name}"</div>
                                <div class="subtitle">Cel i misja: ${institut.description}</div>
                            </span>
                        </label>
                    </div>
                </c:forEach>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 5 -->
            <div data-step="4">
                <h3>Podaj adres oraz termin odbioru rzecz przez kuriera:</h3>

                <div class="form-section form-section--columns">
                    <div class="form-section--column">
                        <h4>Adres odbioru</h4>
                        <div class="form-group form-group--inline">
                            <form:errors path="street" cssClass="error"/>
                            <label> Ulica <form:input path="street" type="text" name="street"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:errors path="city" cssClass="error"/>
                            <label> Miasto <form:input path="city" type="text" name="city"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:errors path="zipCode" cssClass="error"/>
                            <label>Kod pocztowy <form:input path="zipCode" type="text" name="zipCode"/></label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:errors path="phoneNumber" cssClass="error"/>
                            <label>Numer telefonu <form:input path="phoneNumber" type="phone"
                                                              name="phoneNumber"/></label>
                        </div>
                    </div>

                    <div class="form-section--column">
                        <h4>Termin odbioru</h4>
                        <div class="form-group form-group--inline">
                            <form:errors path="pickUpDate" cssClass="error"/>
                            <label> Data <form:input path="pickUpDate" type="date" name="pickUpDate"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:errors path="pickUpTime" cssClass="error"/>
                            <label> Godzina <form:input path="pickUpTime" type="time" name="pickUpTime"/> </label>
                        </div>

                        <div class="form-group form-group--inline">
                            <form:errors path="PickUpComment" cssClass="error"/>
                            <label>Uwagi dla kuriera <form:textarea path="pickUpComment" name="pickUpComment"
                                                                    rows="5"></form:textarea></label>
                        </div>
                    </div>
                </div>
                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="button" class="btn next-step">Dalej</button>
                </div>
            </div>

            <!-- STEP 6 -->
            <div data-step="5">
                <h3>Podsumowanie Twojej darowizny</h3>

                <div class="summary">
                    <div class="form-section">
                        <h4>Oddajesz:</h4>
                        <ul>
                            <li>
                                <span class="icon icon-bag"></span>
                                <span id="summary_bags"
                                      class="summary--text">4 worki ubrań w dobrym stanie dla dzieci</span>
                            </li>

                            <li>
                                <span class="icon icon-hand"></span>
                                <span id="summary_institution" class="summary--text">Dla fundacji "Mam marzenie" w Warszawie</span>
                            </li>
                        </ul>
                    </div>

                    <div class="form-section form-section--columns">
                        <div class="form-section--column">
                            <h4>Adres odbioru:</h4>
                            <ul>
                                <li id="summary_street">Prosta 51</li>
                                <li id="summary_city">Warszawa</li>
                                <li id="summary_zipCode">99-098</li>
                                <li id="summary_phoneNumber">123 456 789</li>
                            </ul>
                        </div>

                        <div class="form-section--column">
                            <h4>Termin odbioru:</h4>
                            <ul>
                                <li id="summary_pickUpDate">13/12/2018</li>
                                <li id="summary_pickUpTime">15:40</li>
                                <li id="summary_pickUpComment">Brak uwag</li>
                            </ul>
                        </div>
                    </div>
                </div>

                <div class="form-group form-group--buttons">
                    <button type="button" class="btn prev-step">Wstecz</button>
                    <button type="submit" class="btn">Potwierdzam</button>
                </div>
            </div>
        </form:form>
    </div>
</section>
<%@include file="form-footer.jsp" %>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

