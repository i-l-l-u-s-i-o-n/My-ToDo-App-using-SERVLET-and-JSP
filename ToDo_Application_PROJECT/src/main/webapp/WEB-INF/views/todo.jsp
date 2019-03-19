<%--
  Created by IntelliJ IDEA.
  User: SHIVAM
  Date: 21-02-2019
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="shortcut icon" type="image/png" href="https://cdn1.iconfinder.com/data/icons/nuvola2/128x128/apps/korganizer_todo.png" />
    <title>Todos</title>
    <%--<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"--%>
          <%--rel="stylesheet">--%>



    <!-- Latest compiled and minified CSS -->
    <%--<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">--%>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" integrity="sha384-fnmOCqbTlWIlj8LyTjo7mOUStjsKC4pOpQbqyi7RrhN7udi9RwhKkMHpvLbHG9Sr" crossorigin="anonymous">


    <style>
        body{
            background: url("https://hdqwalls.com/download/dark-abstract-shapes-qp-1920x1080.jpg");
            color: white;
            font-family: 'Montserrat', sans-serif;
        }

        tr{
            color: #f5f5f5;
        }

        th{
            color: #000000;
            text-transform: uppercase;
            word-spacing: 2px;
            letter-spacing: 2px;
            font-weight: 900;
            font-size: x-large;
        }
        table{
            border: 1px solid white;
            background-color: #000000;
            background-image: linear-gradient(315deg, #000000 0%, #414141 74%);
        }
        .table thead th{
            border: 0;
        }
        tr:hover{
            color: white;
            font-size: x-large;
        }
        .footer {
            position: relative;
            bottom: 0;
            width: 100%;
            height: 60px;
            background-color: #000000;
            background-image: linear-gradient(315deg, #000000 80%, #414141 74%);
            border-top: 2px solid;
        }
        p{
            text-align: center;
            color: #8D8D8D;
            text-transform: uppercase;
            letter-spacing: 4px;
            word-spacing: 7px;
            font-size: medium;
            padding-top: 1%;
        }

        h1 {
            padding-top: 10%;
            text-align: center;
            padding-bottom: 5%;
            color: #c0c0c0;
            letter-spacing: 3px;
            word-spacing: 8px;
            font-weight: 100;

        }
        #welcome_text{
            text-transform: uppercase;

        }
        .bg-light{
            background-color: #000000;
            background-image: linear-gradient(315deg, #000000 80%, #414141 74%);
            border-bottom: 2px solid;
        }
        .btn-secondary {
            color: #fff;
            /* background-color: #6c757d; */
            /* border-color: #6c757d; */
            background-color: #000000;
            background-image: linear-gradient(315deg, #000000 0%, #414141 74%);
        }
        .btn{
            border: 0.1px solid transparent;
        }
        #logout{
            text-decoration: none;
            color: #ececec;
        }
        #logout:hover{
            text-decoration: none;
        }
    </style>
</head>

<body>

<%--<nav class="navbar navbar-default">--%>

    <%--<a href="/" class="navbar-brand">VISION</a>--%>

    <%--<ul class="nav navbar-nav">--%>
        <%--<li ><a href="#">Home</a></li>--%>
        <%--<li class="active"><a href="/list_todo">Todos</a></li>--%>
        <%--<li><a href="http://www.github.com/shivam1097">Shivam</a></li>--%>
    <%--</ul>--%>

    <%--<a href="/logout"><button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Log Out</button></a>--%>

<%--</nav>--%>

<nav class="navbar navbar-expand-lg navbar-dark bg-light" style="position: fixed; width: 100%">
    <a class="navbar-brand" href="#">My ToDo</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item ">
                <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li><a class="nav-link active" href="/list_todo">Todos</a></li>

        </ul>

        <a href="/logout" id="logout">Log Out &nbsp;<i class="fas fa-sign-out-alt"></i></a>
    </div>
</nav>

<div class="container">
    <h1> <span id="welcome_text">Welcome ${name} to </span>My ToDo</h1>



    <table class="table">
        <thead>
            <th>Description</th>
            <th>Category</th>
            <th>Due Date</th>
            <th>Action</th>
        </thead>

        <tbody>
        <%--           The List         element_of_list          --%>
        <%--              ^                   ^                  --%>
        <c:forEach items="${list}"         var="todo">
            <tr >
                <td>${todo.detail}</td>
                <td>${todo.category}</td>
                <td>${todo.due_date}</td>
                <td><a class="btn btn-danger btn-sm" href="/delete_ToDo?todo=${todo.detail}&category=${todo.category}" >Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a style="width: 100%; margin-bottom: 23%; padding: 1% 0" class="btn btn-secondary" href="/add_todo">ADD ToDo &nbsp;<i class="far fa-calendar-plus"></i></a>




</div>

<footer class="footer">
    <p >Developed by ~ SHIVAM SHUKLA (shivam.dev1097@gmail.com)</p>
</footer>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<%--<script src="webjars/jquery/1.9.1/jquery.min.js"></script>--%>
<%--&lt;%&ndash;<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>&ndash;%&gt;--%>
<%--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>--%>

</body>

</html>