<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/24/2021
  Time: 6:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script>
        $(function() {
            $('#btnPopModal').on('click', function(e) {
                //  here's the fun part, pay attention!
                var $body = $(window.frameElement).parents('body'),
                    dlg = $body.find('#myModal');
                dlg.someDialogPlugin('open');
            });
        })
    </script>
</head>
<body>
<button id="btnPopModal">click me</button>

</body>
</html>
