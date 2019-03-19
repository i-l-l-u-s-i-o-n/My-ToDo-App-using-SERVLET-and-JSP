<%--
  Created by IntelliJ IDEA.
  User: SHIVAM
  Date: 21-02-2019
  Time: 20:51
  To change this template use File | Settings | File Templates.
--%>

<%--We have put the common part of jsp's into the header , footer and navigation.jspf file--%>
<%--and now we are includeing them--%>
<%--jspf -> jsp fragments--%>
<%--we can also do it for all the jsp's--%>
<%--but here we are doing it only for login.jsp to show this functionality--%>
<%@include file="../common/header.jspf"%>
<%@include file="../common/navbar.jspf"%>


<div class="container">
    <h1 style="text-align: center;">What to do next ? </h1>
    <form action="/login" method="POST" class="form-group d-inline">
        <input type="text" name="name" placeholder="Username : " class="form-control">
        <br>
        <input type="password" name="pw" placeholder="Password : " class="form-control">
        <%--<input style="margin-top: 25px;margin-left: 25px " class="btn btn-default" type="submit" value="Log In "><i class="fas fa-user-check"></i>--%>
        <button type="submit" style="margin-top: 25px;margin-left: 25px " class="btn btn-secondary btn-lg">LogIn &nbsp;<i class="fas fa-user-plus"></i></button>
    </form>
    <a href="/signup"><button style="margin-top: 25px; margin-left: 25px" class="btn btn-secondary btn-lg" type="submit">Sign Up &nbsp;<i class="fas fa-user-check"></i></button></a>


    <p>${Error}</p>

</div>


<%@include file="../common/footer.jspf"%>

