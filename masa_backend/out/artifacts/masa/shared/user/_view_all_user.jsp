<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- Created by
IntelliJ IDEA. User: Ngoc Thieu Date: 9/19/2021 Time: 1:11 PM To change this
template use File | Settings | File Templates. --%> <%@ page
        contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All User In System</title>
    <link
            rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
    />
    <link
            href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css"
            rel="stylesheet"
    />
    <link
            rel="stylesheet"
            href="path/to/font-awesome/css/font-awesome.min.css"
    />
    <script
            defer
            src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
            integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
            crossorigin="anonymous"
    ></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <style></style>
    <script>
    </script>
</head>
<body>
<section class="text-gray-600 body-font">

    <div class="container px-5 py-5 mx-auto">
        <div class="flex flex-wrap w-full mb-8">
            <div class="w-full mb-6 lg:mb-0 sm:ml-20">
                <h1
                        class="mb-2 text-5xl font-medium text-gray-900 sm:text-4xl title-font"
                >
                    All Users In Masa System
                </h1>
                <div class="w-20 h-1 bg-green-500 rounded"></div>
            </div>
        </div>
        <%--        <h1 id="userId" style="display: none">--%>
        <%--            ${sessionScope.CURRENT_USER.getId()}--%>
        <%--        </h1>--%>
        <script>
            const container = document.getElementById("container");
            let i = 0;
            $.getJSON(
                "http://localhost:8080/masa/api/user-management/all",
                function (data) {
                    // console.log('data', data)
                    let htmlElements = "";
                    const arr = data["users"];
                    arr.forEach((element) => {
                        i++;
                        htmlElements +=
                            '<tr>'
                            +'<th id="index">'+i+'</th>'
                            +'<td id="iD">'
                            +element.id
                            +'</td>'
                            +'<td id="email">'
                            +element.email
                            +'</td>'
                            +'<td id="fullName">'
                            +element.fullName
                            +'</td>'
                            +'<td id="role">'
                            +element.role.type
                            +'</td>'
                            +'<td id="status">'
                            +element.status.status
                            +'</td>'
                            +'</tr>';
                        // console.log(element);
                        let container = document.getElementById("container");
                        container.innerHTML = htmlElements;
                    });
                }
            );
        </script>
        <script></script>
    </div>

</section>
<%--<div id="container"></div>--%>

<div id="target"></div>

<table class="table table-dark sm:ml-20" style="padding: 10px">
    <thead thead-light>
    <tr>
        <th scope="col">Index</th>
        <th scope="col">ID</th>
        <th scope="col">Email</th>
        <th scope="col">Full Name</th>
        <th scope="col">Role</th>
        <th scope="col">Status</th>
    </tr>
    <tbody id="container">
    <%--        <tr>--%>
    <%--            <div id="container"></div>--%>
    <%--        </tr>--%>
    </tbody>
    </thead>
</table>
<br/>
</body>
</html>
