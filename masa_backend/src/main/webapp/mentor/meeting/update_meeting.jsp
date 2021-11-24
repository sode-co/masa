<%@ page import="com.devlogs.masa_backend.common.Masa"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>
    <meta charset="utf-8">
    <link rel="shortcut icon" href="${Masa.ICON_URL}"/>
    <title>Update meeting</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdn.tiny.cloud/1/jq1a1p24pc9o6qg9ovftz51uteowbcodeq41e39ci12r0pnt/tinymce/5/tinymce.min.js" referrerpolicy="origin"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <script>
        tinymce.init({
            selector: '#mytextarea',
            width: "700",
            height: "200",
        });
    </script>

    <script>
        function jsonCreate () {
            const startDate = (""+document.getElementById("start-date").value+" "+ document.getElementById("start-time").value+":00").replace(/-/g,"/")
            const start = new Date(startDate);
            const millisecondsStart = start.getTime();
            console.log("millisStart: " + millisecondsStart)
            console.log("millisStart: " + document.getElementById("start-date").value)
            // var dateString = "10/23/2015"; // Oct 23
            // var dateObject = new Date(dateString);
            const endDate = (""+document.getElementById("end-date").value+" "+ document.getElementById("end-time").value+":00").replace(/-/g,"/")
            const end = new Date(endDate);
            const millisecondsEnd = end.getTime();
            console.log("milliesEnd: " + millisecondsEnd)

            let diff = Math.round((millisecondsEnd-millisecondsStart)/1000);

            const d = Math.floor(diff/(24*60*60));
            diff = diff-(d*24*60*60);
            const h = Math.floor(diff/(60*60));
            diff = diff-(h*60*60);
            const m = Math.floor(diff/(60));
            diff = diff-(m*60);
            const s = diff;

            document.getElementById("time-elapsed").innerHTML = "Your meeting lasts: "+d+" day(s), "+h+" hour(s), "+m+" minute(s), "+s+" second(s)";

            let platformInput = document.getElementById("platform").value;
            if (platformInput.includes('G')) platformInput="GOOGLE_MEET";
            else platformInput='ZOOM';
            if(millisecondsEnd <= millisecondsStart){
                alert('End time of meeting must be bigger than start time');
            }else{
                const description = $("#mytextarea").html();
                const json = {
                    "id": window.location.href.slice(window.location.href.indexOf('?id='), window.location.href.indexOf('&host=')).replace('?id=','').replace('Z',''),
                    "title": document.getElementById("title").value,
                     //"host": "ME100001",
                    "host": "${CURRENT_USER.getId()}",
                    "platform": platformInput,
                    "topic": document.getElementById("topic").value,
                    "startTime": millisecondsStart,
                    "endTime": millisecondsEnd,
                    "description": tinyMCE.activeEditor.getContent(),
                }
                console.log(json);
                const options = {
                    method: 'POST',
                    body: JSON.stringify(json),
                    headers: {
                        'Content-Type': 'application/json'
                    }
                }
                fetch('${Masa.SERVER_HOST}/api/meeting/update', options)
                    .then(res => res.json())
                    .then(res => alert('Update your meeting SUCCESS!'))
                    .catch(err => alert('Oops, try again with title length in range 10 and 20 :) '));
            }
        }
    </script>
    <style>
        body{
            background-color: #33cc99;
        }
        .createform{
            padding-left: 300px !important;
        }
    </style>


</head>

<body>
<h1 style="display: none" id="current-user">${sessionScope.CURRENT_USER.id}</h1>
<div class="container createform">
    <br/>
    <br/>
    <div class="row">
        <div class="col-sm-2" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> Title<span style="color: red">*</span> :</span>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-8" style="width: 730px">
            <input type="text" class="form-control" pattern="[a-zA-Z]" placeholder="Add Title" aria-label="Title" aria-describedby="basic-addon1" id="title" required>
        </div>
    </div>
    <p style="margin-left: 340px; font-style: italic; color: #f6a3a3">Meeting title's length must be between 10 to 20 characters</p>
    <div class="row">
        <div class="col-sm-2" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> From<span style="color: red">*</span> :</span>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-3" style="width: 365px">
            <input type="date" id="start-date" name="trip-start" class="form-control">

        </div>
        <script>
            document.getElementById("start-date").valueAsDate = new Date();
        </script>
        <div class="col-sm-3" style="width: 365px">
            <input type="time" id="start-time" value='now' class="form-control" />
        </div>
    </div>

    <br/>
    <div class="row">
        <div class="col-sm-2" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> To<span style="color: red">*</span> :</span>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3" style="width: 365px">
            <input type="date" id="end-date"class="form-control">

        </div>
        <script>
            document.getElementById("end-date").valueAsDate = new Date();
        </script>
        <div class="col-sm-3" style="width: 365px">
            <input type="time" id="end-time" value='now' class="form-control" />
        </div>
    </div>
    <script>
        $(function(){
            var d = new Date(),
                h = d.getHours(),
                m = d.getMinutes();
            if(h < 10) h = '0' + h;
            if(m < 10) m = '0' + m;
            $('input[type="time"][value="now"]').each(function(){
                $(this).attr({'value': h + ':' + m});
            });
        });
    </script>
    <p id="time-elapsed" style="font-style: italic; margin-left: 200px"></p>

    <br/>
    <div class="row">
        <div class="col-sm-3" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> Platform<span style="color: red">*</span> :</span>
        </div>
        <div class="col-sm-3" style="margin-left: 63px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> Topic<span style="color: red">*</span> :</span>
        </div>
    </div>
    <div class="row" style="padding-right:10px">
        <div class="col-sm-3" style="width: 365px">
            <select class="form-select form-control" id="platform">
                <option value="Zoom">Zoom</option>
                <option value="Google Meet">Google Meet</option>
            </select>
        </div>
        <div class="col-sm-3" style="width: 365px">
            <select class="form-select form-control" id="topic">
                <option value="Agile">Graphic Design</option>
                <option value="Artificial Intelligence">Artificial Intelligence</option>
                <option value="Business management">Business management</option>
                <option value="Digital Maketing">Digital Maketing</option>
                <option value="English Language">English Language</option>
                <option value="Information Assurance">Information Assurance</option>
                <option value="Japanese Language">Japanese Language</option>
                <option value="Multimedia">Multimedia</option>
                <option value="Photoshop">Photoshop</option>
                <option value="Soft Skills">Soft Skills</option>
                <option value="Software Engineering">Software Engineering</option>
            </select>
        </div>
    </div>

    <br/>

    <div class="row">
    </div>
    <div class="row">
    </div>

    <br/>

    <div class="row">
        <div class="col-sm-2" style="margin-left: 3px; color: #9b9a9a">
            <span style="font-weight: bold" style="padding-left: 10px"> Description<span style="color: red">*</span> :</span>
        </div>
    </div>

    <div class="row" style="padding-left:2px">
        <div class="col-sm-1" style="width: 100px !important;">
            <textarea id="mytextarea" style="width: 100px !important;">Hi students, I'm glad too see you at meeting...</textarea>
            <div>

                <hr/>
                <br/>

                <%--        <div id="mytextarea" class="col-sm-7">Hello, World!</div>--%>

                <div class="text-center row">
                    <div class="col-sm-9">
                        <button onclick="jsonCreate()" class="btn btn-dark"  style="background-color: #414E62; color: white; font-size: 20px; border-radius: 5px; margin-left: 10%">Update Meeting!</button>
                    </div>
                </div>
            </div>
        </div>

    </div>


<script>
    const url = "${Masa.SERVER_HOST}/api/meeting-management/meetings/host/"+window.location.href.slice(window.location.href.indexOf('&host=')).replace('&host=','');
    $.getJSON(url, function (data) {
        const arr = data["meetings"];
        const meetingId = window.location.href.slice(window.location.href.indexOf('?id='), window.location.href.indexOf('&host=')).replace('?id=','').replace('Z','');
        arr.forEach((element) => {
            if(element.id===meetingId){
                document.getElementById("title").value = element.title;
                if(element.platform.platform.includes("Z")){
                    document.getElementById("platform").value = "Zoom";
                }
                else{
                    document.getElementById("platform").value = "Google Meet";
                }
                document.getElementById("topic").value = element.topic.title;
                document.getElementById("mytextarea").value = element.description;
            }
        });
    });
</script>





</body>
</html>
