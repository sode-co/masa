<%@ page import="com.devlogs.masa_backend.common.Masa"%>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Document</title>
    <link rel="stylesheet" href="../styles.css" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" />
    <link href="https://unpkg.com/tailwindcss@%5E2/dist/tailwind.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css" />
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
    <script>
        function follow(){
            const json = {
                userId: document.getElementById("currentSessionNewMeeting").textContent,
                meetingId: location.search.replace("?id=",""),
            };
            console.log(json);
            const options = {
                method: "POST",
                body: JSON.stringify(json),
                headers: {
                    "Content-Type": "application/json",
                },
            };
            fetch("${Masa.SERVER_HOST}/api/appointment-management/create", options)
                .then((res) => res.json())
                .then((res) => {
                        alert("Follow meeting success!");
                        parent.onFollowedMeetingChanged();
                    }
                )
                .catch((err) => alert("Oops Sorry, there seems little error..."));
        }
        function unfollow(){
            const json = {
                userId: document.getElementById("currentSessionNewMeeting").textContent,
                meetingId: location.search.slice(location.search.indexOf("followed=")).replace("followed=",""),
            };
            console.log(json);
            const options = {
                method: "POST",
                body: JSON.stringify(json),
                headers: {
                    "Content-Type": "application/json",
                },
            };
            fetch("${Masa.SERVER_HOST}/api/appointment-management/remove", options)
                .then((res) => res.json())
                .then((res) => {
                        alert("Unfollow meeting success!");
                        parent.onFollowedMeetingChanged();
                    }
                )
                .catch((err) => alert("Oops Sorry, there seems little error..."));
        }
    </script>
</head>

<body>
<h1 id="currentSessionNewMeeting" style="display: none">${sessionScope.CURRENT_USER.id}</h1>

<div>
    <div class="font-sans" role="document">
        <div class="rounded-3xl" style="width: 680px;">
            <div>
                <button type="button" class="mr-16 close mt-9" aria-label="Close"
                        onclick="parent.autoclick()"
                >
                    <span class="text-4xl" aria-hidden="true"
                    >&times;</span>
                </button>
                <h4 class="text-2xl font-bold text-black mt-16 ml-14">Meeting Information</h4>
                <div>
                    <h1 class="relative inline-block mb-1 text-5xl font-semibold text-gray-900 mt-9 ml-14 date" id="meetingtile">React for beginner</h1>
                    <a href="#" class="text-2xl font-semibold text-blue-800 ml-7" id="linkjoin" target="_blank">Join Google Meet</a><br />
                    <span class="relative inline-block pt-2 mb-1 text-2xl font-normal text-black ml-14 date"
                    >with mentor <span class="text-2xl font-normal text-blue-800" id="meetingmentor">Thieu Ngoc</span></span
                    >
                    <div class="flex ml-14 mt-7">
                                <span
                                        class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200  rounded-2xl date"
                                        id="meetingstarttime"
                                >10:10</span
                                >
                        <h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date p2">to:</h1>
                        <span
                                class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200  rounded-2xl date"
                                id="meetingendtime"
                        >20:20</span
                        >
                        <h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date p2">date:</h1>
                        <span
                                class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200  rounded-2xl date"
                                id="meetingdate"
                        >15/05/2021</span
                        >
                    </div>
                    <div class="flex mb-4 mt-14">
                        <p class="mr-5 font-normal text-gray-500 ml-14"
                           id="meetingdescription"
                        >
                            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Euismod ut sit lacus risus malesuada magna lectus.
                            Aliquet viverra volutpat orci lacus aliquam, amet duis viverra. Auctor tortor facilisis magna praesent nunc,
                            tristique felis amet, nibh. Lacinia mauris vulputate quis pretium sed. Arcu risus ac justo condimentum amet,
                            mauris tempor. Posuere viverra pellentesque tempus euismod est aliquam sit enim massa. Potenti volutpat, sed
                            turpis tempor arcu elementum.
                        </p>
                    </div>
                </div>
                <div class="flex justify-center w-full mt-20 space-x-20 mb-7">
                    <button onclick="follow()"
                            class="p-4 text-2xl font-semibold text-black bg-transparent border-2 border-gray-200  pl-28 pr-28 rounded-2xl hover:text-blue-500 focus:border-4 focus:border-blue-300"
                            id="followbutton"
                    >
                        Follow
                    </button>

                    <a href="#" target="_blank" id="questionUrl">
                        <button
                                class="p-4 pl-20 pr-20 text-2xl font-semibold text-white bg-indigo-700 border-blue-300  rounded-2xl focus:border-4 hover:bg-indigo-900"
                        >
                            Leave question
                        </button>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
<h1 style="display: none">${sessionScope.CURRENT_USER.id}</h1>
<script>
    const urlFollowNewMeeting = "${Masa.SERVER_HOST}/api/appointment-management/create";
    let iDialogNewMeeting=0;
    const z = "z";
    const space = "";
    const postMethodNewMeeting = "POST";
    const appJsonNewMeeting = "application/json";
    const userId = document.getElementById("currentSessionNewMeeting").innerText;
    let followNotiNewMeeting = "Follow meeting success";
    let url = "${Masa.SERVER_HOST}/api/meeting-management/meeting/"+location.search.slice(location.search.indexOf("?id=")).replace("?id=","");
    if(location.search.includes("followed")){
        url = "${Masa.SERVER_HOST}/api/meeting-management/meeting/"+location.search.slice(location.search.indexOf("followed=")).replace("followed=","");
    }
    $.getJSON(url, function (element) {
        iDialogNewMeeting++;
        const meetingId = "z"+element.id;
        const idDialog = "myModalNewMeeting"+iDialogNewMeeting;
        var startConvertNewMeeting = new Date(element.startTime); // create Date object
        var startConvertNewMeetingTime = startConvertNewMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
        var endConvertConvertNewMeeting = new Date(element.endTime); // create Date object
        const startDayNewMeeting = ("0"+startConvertNewMeeting.getDate()).slice(("0"+startConvertNewMeeting.getDate()).length-2, ("0"+startConvertNewMeeting.getDate()).length);
        const month = startConvertNewMeeting.getMonth() + 1;
        const startMonthNewMeeting = ("0"+month).slice(("0"+month).length-2, ("0"+month).length);
        var endConvertConvertNewMeetingTime = endConvertConvertNewMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');

        document.getElementById('linkjoin').href = element.platform.url;

        if(element.platform.platform === 'ZOOM'){
            document.getElementById('linkjoin').innerText = "Join Zoom";
            document.getElementById("meetingtile").innerText = element.title;
            document.getElementById("meetingdescription").innerHTML = element.description;
            document.getElementById("meetingmentor").innerText = element.mentor.fullName;
            document.getElementById("meetingdate").innerText = startDayNewMeeting+'/'+startMonthNewMeeting+'/'+startConvertNewMeeting.getFullYear();
            document.getElementById("meetingendtime").innerText = endConvertConvertNewMeetingTime.slice(16,21);
            document.getElementById("meetingstarttime").innerText =startConvertNewMeetingTime.slice(16,21).toString();
            document.getElementById("questionUrl").href ="${Masa.SERVER_HOST}/member/question.jsp?id="+location.search.replace("?id=","")+"&page=0";
        }else{
            document.getElementById('linkjoin').innerText = "Join Google Meet";
            document.getElementById("meetingtile").innerText = element.title;
            document.getElementById("meetingdescription").innerHTML = element.description;
            document.getElementById("meetingmentor").innerText = element.mentor.fullName;
            document.getElementById("meetingdate").innerText = startDayNewMeeting+'/'+startMonthNewMeeting+'/'+startConvertNewMeeting.getFullYear();
            document.getElementById("meetingendtime").innerText = endConvertConvertNewMeetingTime.slice(16,21);
            document.getElementById("meetingstarttime").innerText =startConvertNewMeetingTime.slice(16,21).toString();
            document.getElementById("questionUrl").href ="${Masa.SERVER_HOST}/member/question.jsp?id="+location.search.replace("?id=","")+"&page=0";
        }
        if(location.search.includes("followed")){
            document.getElementById("followbutton").innerText = "Unfollow";
            document.getElementById("followbutton").onclick = unfollow;
        }
    })
</script>
</body>
</html>