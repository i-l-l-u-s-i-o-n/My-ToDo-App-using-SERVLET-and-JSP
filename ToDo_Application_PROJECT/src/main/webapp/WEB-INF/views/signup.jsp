<%--
  Created by IntelliJ IDEA.
  User: SHIVAM
  Date: 24-02-2019
  Time: 21:29
  To change this template use File | Settings | File Templates.
--%>
<%@include file="../common/header.jspf"%>
<%@include file="../common/navbar.jspf"%>


<div class="container">
    <h1>What to do next ? </h1>
    <form action="/signup" method="POST" class="form-group">
        <input type="text" name="name" placeholder="Username : " class="form-control" required>
        <br>
        <input type="email" name="email" placeholder="Email : " class="form-control" required>
        <br>
        <input type="password" name="pass" placeholder="Password : " class="form-control" required>
        <%--<input style="margin-top: 25px;" class="btn btn-primary" type="submit" value="Sign up">--%>
        <button style="margin-top: 25px;" class="btn btn-secondary" type="submit">Sign Up &nbsp;<i class="fas fa-user-check"></i></button>
    </form>
    <p>${Error}</p>

</div>


<%@include file="../common/footer.jspf"%>
