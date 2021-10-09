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
            let result =  new Array();
            $.getJSON(
                "http://localhost:8080/masa/api/user-management/get_user_in_processing",
                function (data) {
                    const arr = data["userEntities"];
                    arr.forEach((element) => {
                        $.getJSON(
                            "http://localhost:8080/masa/api/request-management/requests",
                            function (data2) {
                                const arr2 = data2["requests"];
                                arr2.forEach((element2) => {
                                    console.log(element2.userId);
                                    console.log(element.id);
                                    if(element2.userId===element.id){
                                        console.log(element, element2);
                                        console.log('success');
                                        console.log(Object.assign(element,element2));
                                    }
                                });
                            });
                    });
                });



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
