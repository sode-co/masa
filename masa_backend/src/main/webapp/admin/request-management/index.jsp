<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/7/2021
  Time: 8:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script>
            let arrRequests =  new Array();
            let arrUserRequests =  new Array();
            let m = new Array();
            $.getJSON(
                "http://localhost:8080/masa/api/request-management/requests",
                function (data) {
                    const arr = data["requests"];
                    let m1 = new Map();
                    arr.forEach((element) => {
                        if(element.status==="PROCESSING"){
                            console.log('PROCESSING', element)
                            arrRequests.push(element);
                            m.push(element);
                        }
                    });
                }
            )
            $.getJSON(
                "http://localhost:8080/masa/api/user-management/get_user_in_processing",
                function (data) {
                    const arr = data["userEntities"];
                    arr.forEach((element) => {
                        arrUserRequests.push(element);
                        m.push(element);
                    });
                }
            )
            console.log('map outside ',m);
            console.log('arr outside ', arrRequests);
            console.log('arr outside ', arrUserRequests);
            for(let i=0; i<=arrRequests.length; i++){
                console.log('test');
                console.log(arrRequests);
            }


        </script>
</head>

<body>
<h1>Request manage</h1>
<script>
    console.log('arr body ', arrRequests);
    console.log('arr body ', arrUserRequests);

</script>
</body>
</html>
