<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/4/2021
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <script src="https://cdn.tiny.cloud/1/jq1a1p24pc9o6qg9ovftz51uteowbcodeq41e39ci12r0pnt/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>

    <script>
        tinymce.init({
            selector: '#mytextarea'
        });
        function testText(){
            const test = $("#mytextarea").html();
            console.log(tinyMCE.activeEditor.getContent());
            console.debug(tinyMCE.activeEditor.getContent());

        }
    </script>

</head>

<body>
    <h1>TinyMCE Quick Start Guide</h1>
        <div id="mytextarea">Hello, World!</div>
    <button onclick="testText()">Test</button>
</body>
</html>
