<%@ page import="com.devlogs.masa_backend.common.Masa"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="../styles/styles.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
    <link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet" />
   
    <link rel="dns-prefetch" href="//unpkg.com" />
    <link rel="dns-prefetch" href="//cdn.jsdelivr.net" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script
            defer
            src="https://use.fontawesome.com/releases/v5.0.8/js/all.js"
            integrity="sha384-SlE991lGASHoBfWbelyBPLsUlwY1GwNDJo3jSJO04KZ33K2bwfV9YBauFfnzvynJ"
            crossorigin="anonymous"
    ></script>
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.js" defer></script>
    <style>
        div#carousel_wrapper {
            overflow: hidden;
            position: relative;
            width: 5000px;
            height: 400px;
        }

        ul {
            padding: 0px;
            /* margin-left: 20%; */
            /* margin-right: 20%; */
            position: absolute;
            left: 0px;
            width: 450px;
            height: 450px;
            overflow: hidden;
        }
        ul li {
            list-style: none;
            float: left;
        }
        ul li div {
            border: 1px solid white;
            width: 300px;
            height: 400px;
        }

        .modal.fade {
            opacity: 1;
        }
        .modal.fade .modal-dialog {
            -webkit-transform: translate(0);
            -moz-transform: translate(0);
            transform: translate(0);
        }
        html {
            font-family: Lato, "Helvetica Neue", Arial, Helvetica, sans-serif;
            font-size: 14px;
        }

        h5 {
            font-size: 1.28571429em;
            font-weight: 700;
            line-height: 1.2857em;
            margin: 0;
        }

        .card {
            font-size: 1em;
            overflow: hidden;
            padding: 0;
            border: none;
            border-radius: 0.28571429rem;
            box-shadow: 0 1px 3px 0 #d4d4d5, 0 0 0 1px #d4d4d5;
        }

        .card-block {
            font-size: 1em;
            position: relative;
            margin: 0;
            padding: 1em;
            border: none;
            border-top: 1px solid white;
            box-shadow: none;
        }

        .card-img-top {
            display: block center;
            margin: auto;
            width: 70%;
            height: auto;
        }

        .card-title {
            font-size: 1.28571429em;
            font-weight: 700;
            line-height: 1.2857em;
        }

        .card-text {
            clear: both;
            margin-top: 0.5em;
            color: rgba(0, 0, 0, 0.68);
        }

        .card-footer {
            font-size: 1em;
            position: static;
            top: 0;
            left: 0;
            max-width: 100%;
            padding: 0.75em 1em;
            color: rgba(0, 0, 0, 0.4);
            border-top: 1px solid white !important;
            background: #fff;
        }

        .card-inverse .btn {
            border: 1px solid rgba(0, 0, 0, 0.05);
        }

        .profile {
            position: absolute;
            top: -12px;
            display: inline-block;
            overflow: hidden;
            box-sizing: border-box;
            width: 25px;
            height: 25px;
            margin: 0;
            border: 1px solid #fff;
            border-radius: 50%;
        }

        .profile-avatar {
            display: block;
            width: 100%;
            height: 100%;
            border-radius: 50%;
        }

        .profile-inline {
            position: relative;
            top: 0;
            display: inline-block;
        }

        .profile-inline ~ .card-title {
            display: inline-block;
            margin-left: 4px;
            vertical-align: top;
        }

        .text-bold {
            font-weight: 700;
        }

        .meta {
            font-size: 1em;
            color: rgba(0, 0, 0, 0.4);
        }

        .meta a {
            text-decoration: none;
            color: rgba(0, 0, 0, 0.4);
        }

        .meta a:hover {
            color: rgba(0, 0, 0, 0.87);
        }
    </style>
    <script>
        function testAnim(x) {
            $(".modal .modal-dialog").attr("class", "modal-dialog  " + x + "  animated");
        }
        $("#myModal").on("show.bs.modal", function (e) {
            var anim = $("#entrance").val();
            testAnim(anim);
        });
        $("#myModal").on("hide.bs.modal", function (e) {
            var anim = $("#exit").val();
            testAnim(anim);
        });
    </script>
</head>
<body>
<div class="w-full body-font mb-6 lg:mb-0 sm:ml-20">
    <h1 class="mb-2 text-5xl font-medium text-gray-900 title-font" style="font-size: 20px; font-weight: 600" id="topictitle">Software Engineering Meetings</h1>
    <div class="w-20 h-1 bg-blue-500 rounded" style="background-color: #66ce93"></div>
</div>
<script>
    const idtopic = location.search.replace("?topicId=", '');
    if(idtopic==='1'){
        document.getElementById("topictitle").innerText = "Software Engineering Meetings";
    }else if(idtopic==='10'){
        document.getElementById("topictitle").innerText = "Graphic Design Meetings";
    }else if(idtopic==='4'){
        document.getElementById("topictitle").innerText = "Artificial Intelligence";
    }else if(idtopic==='7'){
        document.getElementById("topictitle").innerText = "Business management";
    }else if(idtopic==='2'){
        document.getElementById("topictitle").innerText = "Digital Maketing";
    }else if(idtopic==='5'){
        document.getElementById("topictitle").innerText = "English Language";
    }else if(idtopic==='3'){
        document.getElementById("topictitle").innerText = "Information Assurance";
    }else if(idtopic==='6'){
        document.getElementById("topictitle").innerText = "Japanese Language";
    }else if(idtopic==='8'){
        document.getElementById("topictitle").innerText = "Multimedia";
    }else if(idtopic==='9'){
        document.getElementById("topictitle").innerText = "Soft Skills";
    }
</script>
<div class="container">
    <div class="row" id="rowne">
        <!-- The meeting bat dau o day -->
        <script>
            let htmlElements = "";
            let i=0;
            $.getJSON("${Masa.SERVER_HOST}/api/meeting-management/topic/meetings/${param.topicId}", function (data) {
                let htmlElementsNewMeeting = "";
                const arrNewMeeting = data["meetings"];
                arrNewMeeting.forEach((element) => {
                    var startConvertNewMeeting = new Date(element.startTime); // create Date object
                    var startConvertNewMeetingTime = startConvertNewMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
                    var endConvertConvertNewMeeting = new Date(element.startTime); // create Date object
                    var endConvertConvertNewMeetingTime = endConvertConvertNewMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
                    i++;
                    htmlElements +=
                        '<div class="mt-4 transition duration-500 transform col-sm-6 col-md-4 col-lg-3 hover:shadow-xl hover:scale-110" style="width:300px">'
                        +'<div class="card">'
                        +'<img'
                        +' class="card-img-top"'
                        +'src="https://image.freepik.com/free-vector/programming-concept-illustration_114360-1213.jpg"'
                        +'/>'
                        +'<div class="card-block" style="text-align: center">'
                        +'<h1 class="text-xl font-bold text-green-600">'+element.title+'</h1>'
                        +'<h2 class="text-lg text-indigo-600" style="color: #414e62">with mentor: <strong class="text-indigo-600" style="color: coral">'+element.mentor.fullName+'</strong></h2>'
                        +'<p class="mt-4 text-gray-600">'+startConvertNewMeetingTime.slice(16,21)+' '+ startConvertNewMeetingTime.slice(4,10)+'</p>'
                        +'</div>'
                        +'<div class="card-footer">'
                        +'<button'
                        +' type="button"'
                        +' class="float-left py-2 mt-1 mb-4 mr-2 font-semibold tracking-widest bg-blue-500 hover:bg-indigo-900 text-white font-bold py-2 px-4 border bg-indigo-800 rounded-md"'
                        +' onclick=parent.calldialog('+element.id+')'
                        +'>'
                        +'See more'
                        +'</button>'
                        +'<a href="'+element.platform.url+'" target="_blank">'
                        +'<button'
                        +' type="button"'
                        +' class="float-right px-3 py-2 mt-1 mb-4 mr-2 font-semibold tracking-widest bg-transparent hover:bg-green-500 text-green-700 font-semibold hover:text-white py-2 px-4 border border-green-500 hover:border-transparent rounded-lg""'
                        +'>'
                        +'Join now'
                        +' </button>'
                        +'</a>'
                        +'</div>'
                        +'</div>'
                        +'</div>'
                });
                document.getElementById("rowne").innerHTML = htmlElements;
            });
        </script>

        <!-- Meeting card ket thuc o day nha, add cai sau o ngay duoi luon -->
    </div>

    <!-- Dialog -->
</div>
</body>
</html>

