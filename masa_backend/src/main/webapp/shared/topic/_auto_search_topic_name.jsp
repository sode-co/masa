<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/6/2021
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='https://fonts.googleapis.com/css?family=Quicksand:400,700' rel='stylesheet' type='text/css' />
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.0.0.min.js" /></script>

    <link href="https://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.min.css" rel="stylesheet" />
    <link
    href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css"
    rel="stylesheet"
  />
  <link
    rel="stylesheet"
    href="path/to/font-awesome/css/font-awesome.min.css"
  />
  <link rel="dns-prefetch" href="//unpkg.com" />
  <link rel="dns-prefetch" href="//cdn.jsdelivr.net" />
    <!--[if IE 7]>
    <link href="https://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome-ie7.min.css" rel="stylesheet" />
    <![endif]-->

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font: 16px Arial;
        }

        .autocomplete {
            position: relative;
            display: inline-block;
        }

        input {
            border: 1px solid transparent;
            background-color: #f1f1f1;
            font-size: 13px;
            border-radius: 5px !important;
            height: 50px;
            padding-left: 10px;
        }

        input[type=text] {
            background-color: #f1f1f1;
            width: 100%;
            padding-left: 10px;
        }

        input[type=submit] {
            background-color: DodgerBlue;
            color: #fff;
            cursor: pointer;
        }

        .autocomplete-items {
            position: absolute;
            border: 1px solid #ffffff;
            border-bottom: none;
            border-top: none;
            z-index: 99;
            top: 100%;
            left: 0;
            right: 0;
        }

        .autocomplete-items div {
            padding: 10px;
            cursor: pointer;
            background-color: #fff;
            border-bottom: 1px solid #d4d4d4;
        }

        .autocomplete-items div:hover {
            background-color: #e9e9e9;
        }

        .autocomplete-active {
            background-color: DodgerBlue !important;
            color: #ffffff;
        }
        .searchButton {
            width: 40px;
            height: 36px;
            border: 1px solid #00B4CC;
            background: #00B4CC;
            text-align: center;
            color: #fff;
            border-radius: 0 5px 5px 0;
            cursor: pointer;
            font-size: 20px;
            padding-top: 5px;
        }
    </style>
</head>
<body>
<script>
    function searchtopic(){
        const searchKeyword = document.getElementById("myInput").value;
        window.open("http://localhost:8080/masa/member/meeting/view_meeting_by_topic_name.jsp?&search="+searchKeyword);
    }
</script>

<!-- <div class="flex justify-between px-3 py-1 mt-5 mb-2 border-2 rounded-md rounde-md">
    <div class="autocomplete">
    <input class="flex-grow text-gray-600 outline-none focus:text-blue-600" name="topic" type="text" placeholder="Enter topic name..." />
    </div>
    <spa>
      <svg xmlns="http://www.w3.org/2000/svg" class="w-6 h-6 text-gray-400 transition duration-100 cursor-pointer hover:text-blue-400" onclick="searchtopic()" fill="none" viewBox="0 0 24 24" stroke="currentColor">
        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z" />
      </svg>
    </spa>
  </div> -->

<div class="flex justify-between px-3 py-1 mt-5 mb-2 border-2 rounded-md searchBar rounde-md" style="display: inline-block">
    <div class="autocomplete" style="width:300px;">
        <input class="flex flex-col flex-1 text-gray-600 outline-none" id="myInput" type="text" name="topic" placeholder="Enter topic name here...">
    </div>
    <button style="background-color: transparent; border: none; cursor: pointer" onclick="searchtopic()">
        <i class="flex flex-col flex-1 icon-search icon-2x"></i>
    </button>
</div>



<script>
    function autocomplete(inp, arr) {
        var currentFocus;
        inp.addEventListener("input", function(e) {
            var a, b, i, val = this.value;
            closeAllLists();
            if (!val) { return false;}
            currentFocus = -1;
            a = document.createElement("DIV");
            a.setAttribute("id", this.id + "autocomplete-list");
            a.setAttribute("class", "autocomplete-items");
            this.parentNode.appendChild(a);
            for (i = 0; i < arr.length; i++) {
                if (arr[i].substr(0, val.length).toUpperCase() == val.toUpperCase()) {
                    b = document.createElement("DIV");
                    b.innerHTML = "<strong>" + arr[i].substr(0, val.length) + "</strong>";
                    b.innerHTML += arr[i].substr(val.length);
                    b.innerHTML += "<input type='hidden' value='" + arr[i] + "'>";
                    b.addEventListener("click", function(e) {
                        inp.value = this.getElementsByTagName("input")[0].value;
                        closeAllLists();
                    });
                    a.appendChild(b);
                }
            }
        });
        inp.addEventListener("keydown", function(e) {
            var x = document.getElementById(this.id + "autocomplete-list");
            if (x) x = x.getElementsByTagName("div");
            if (e.keyCode == 40) {
                currentFocus++;
                addActive(x);
            } else if (e.keyCode == 38) {
                currentFocus--;
                addActive(x);
            } else if (e.keyCode == 13) {
                e.preventDefault();
                if (currentFocus > -1) {
                    if (x) x[currentFocus].click();
                }
            }
        });
        function addActive(x) {
            if (!x) return false;
            removeActive(x);
            if (currentFocus >= x.length) currentFocus = 0;
            if (currentFocus < 0) currentFocus = (x.length - 1);
            x[currentFocus].classList.add("autocomplete-active");
        }
        function removeActive(x) {
            for (var i = 0; i < x.length; i++) {
                x[i].classList.remove("autocomplete-active");
            }
        }
        function closeAllLists(elmnt) {
            var x = document.getElementsByClassName("autocomplete-items");
            for (var i = 0; i < x.length; i++) {
                if (elmnt != x[i] && elmnt != inp) {
                    x[i].parentNode.removeChild(x[i]);
                }
            }
        }
        document.addEventListener("click", function (e) {
            closeAllLists(e.target);
        });
    }
    var topics = ["Agile", "Artificial Intelligence", "Business management", "Digital Maketing",
        "English Language", "Information Assurance", "Japanese Language", "Soft Skills", "Software Engineering"]

    autocomplete(document.getElementById("myInput"), topics);
</script>

</body>
</html>

