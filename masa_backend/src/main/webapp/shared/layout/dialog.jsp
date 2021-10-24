<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>DialogTest</title>
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <style>
        [x-cloak] {
            display: none;
        }

        .duration-300 {
            transition-duration: 300ms;
        }

        .ease-in {
            transition-timing-function: cubic-bezier(0.4, 0, 1, 1);
        }

        .ease-out {
            transition-timing-function: cubic-bezier(0, 0, 0.2, 1);
        }

        .scale-90 {
            transform: scale(0.9);
        }

        .scale-100 {
            transform: scale(1);
        }
    </style>
</head>

<body
        class="flex items-center justify-center w-full h-screen mx-auto bg-gray-100"
        x-data="{ 'showModal': false }"
        @keydown.escape="showModal = false"
        x-cloak
>
<div id="new_meeting_dialog">
</div>
<h1 id="currentSessionNewMeeting">${sessionScope.CURRENT_USER.id}</h1>
<script>
                    const urlFollowNewMeeting = "/masa/api/appointment-management/create";
                    let iDialogNewMeeting=0;
                    const z = "z";
                    const space = "";
                    const postMethodNewMeeting = "POST";
                    const appJsonNewMeeting = "application/json";
                    const userId = document.getElementById("currentSessionNewMeeting").innerText;
                    let followNotiNewMeeting = "Follow meeting success";
                    const url = "/masa/api/meeting-management/meeting/"+location.search.replace("?id=","");
                    $.getJSON(url, function (data) {
                        let htmlDialogsNewMeeting = "";
                        const element = data["meeting"];
                        console.log(JSON.stringify(element));
                            iDialogNewMeeting++;
                            const meetingId = "z"+element.id;
                            const idDialog = "myModalNewMeeting"+iDialogNewMeeting;
                            var startConvertNewMeeting = new Date(element.startTime); // create Date object
                            var startConvertNewMeetingTime = startConvertNewMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
                            var endConvertConvertNewMeeting = new Date(element.endTime); // create Date object
                            const startDayNewMeeting = ("0"+startConvertNewMeeting.getDay()).slice(("0"+startConvertNewMeeting.getDay()).length-2, ("0"+startConvertNewMeeting.getDay()).length);
                            const startMonthNewMeeting = ("0"+startConvertNewMeeting.getMonth()).slice(("0"+startConvertNewMeeting.getMonth()).length-2, ("0"+startConvertNewMeeting.getMonth()).length);
                            var endConvertConvertNewMeetingTime = endConvertConvertNewMeeting.toString().replace("GMT+0700 (Indochina Time)",'').replace("GMT+0800 (Indochina Time)",'');
                            if(element.platform.platform === 'ZOOM'){
                                htmlDialogsNewMeeting +=
                                    '<div class="modal fade" id='+idDialog+' tabindex="-1" role="dialog" aria-labelledby="myModalLabel">'
                                    +'<div class="font-sans modal-dialog" role="document">'
                                    +'<div class="rounded-3xl modal-content" style="width: 680px;">'
                                    +'<div class="modal-body">'
                                    +'<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
                                    +'<span aria-hidden="true">&times;</span>'
                                    +'</button>'
                                    +'<h4 class="text-2xl font-bold text-black mt-11 ml-14 modal-title" id="myModalLabel">Meeting Information</h4>'
                                    +'<div>'
                                    +'<h1 class="relative inline-block mb-1 text-5xl font-semibold text-gray-900 mt-11 ml-14 date modal-title"'
                                    +'>'+element.title+'</h1'
                                    +'><a href="'+element.platform.url+'" class="text-2xl font-semibold text-blue-800 ml-7">Join Zoom</a><br>'
                                    // +'<span class="relative inline-block pt-2 text-2xl font-normal text-black ml-14 date modal-title"'
                                    // +'>with mentor <span class="text-2xl font-normal text-blue-800">'+element.mentor.fullName+'</span></span'
                                    // +'>'
                                    +'<div class="flex ml-7 modal-body">'
                                    +'<span class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200 rounded-2xl date modal-title"'
                                    +'>'+startConvertNewMeetingTime.slice(16,21)+'</span>'
                                    +'<h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date modal-title p2"'
                                    +'>to:</h1'
                                    +'>'
                                    +'<span class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200 rounded-2xl date modal-title"'
                                    +'>'+endConvertConvertNewMeetingTime.slice(16,21)+'</span>'
                                    +'<h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date modal-title p2"'
                                    +'>date:</h1'
                                    +'>'
                                    +'<span class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200 rounded-2xl date modal-title"'
                                    +'>'+startDayNewMeeting+'/'+startMonthNewMeeting+'/'+startConvertNewMeeting.getFullYear()+'</span>'
                                    +'</div>'
                                    +'<div class="flex mb-4 modal-body">'
                                    +'<p class="mr-5 font-normal text-gray-500 ml-9">'+element.description+'</p>'
                                    +'</div>'
                                    +'</div>'
                                    +'<div class="flex justify-center w-full space-x-16 mt-9 mb-14">'
                                    +'<a href="" onClick="(function(){'
                                    +"const varToString = varObj => Object.keys(varObj)[0];"
                                    +"const " + meetingId +"=z;"
                                    +"const x = varToString({"
                                    +meetingId
                                    +"});"
                                    +"console.log(x);"
                                    +"const json = {"
                                    +"userId: userId,"
                                    +"meetingId: x.replace(z,space),"
                                    +"};"
                                    +"console.log(json);"
                                    +"const options = {"
                                    +"method: postMethodNewMeeting,"
                                    +"body: JSON.stringify(json),"
                                    +"headers: {"
                                    +"contentType: appJsonNewMeeting,"
                                    +"},"
                                    +"};"
                                    +"console.log(options);"
                                    +"console.log(urlFollowNewMeeting);"
                                    +"fetch(urlFollowNewMeeting, options)"
                                    +".then((res) => res.json())"
                                    +".then((res) => alert(followNotiNewMeeting))"
                                    +".catch((err) => alert(err));"
                                    +'})();return false;">'
                                    +'<button'
                                    +' class="p-4 text-2xl font-semibold text-black bg-transparent border-2 border-gray-200 pl-28 pr-28 rounded-2xl hover:text-blue-500 focus:border-4 focus:border-blue-300"'
                                    +'>'
                                    +'Follow'
                                    +'</button>'
                                    +'</a>'
                                    +'<button'
                                    +' class="p-4 pl-20 pr-20 text-2xl font-semibold text-white bg-indigo-700 border-blue-300 rounded-2xl focus:border-4 hover:bg-indigo-900"'
                                    +'>'
                                    +'Leave question'
                                    +'</button>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                            }else{
                                htmlDialogsNewMeeting +=
                                    '<div class="modal fade" id='+idDialog+' tabindex="-1" role="dialog" aria-labelledby="myModalLabel">'
                                    +'<div class="font-sans modal-dialog" role="document">'
                                    +'<div class="rounded-3xl modal-content" style="width: 680px;">'
                                    +'<div class="modal-body">'
                                    +'<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
                                    +'<span aria-hidden="true">&times;</span>'
                                    +'</button>'
                                    +'<h4 class="text-2xl font-bold text-black mt-11 ml-14 modal-title" id="myModalLabel">Meeting Information</h4>'
                                    +'<div>'
                                    +'<h1 class="relative inline-block mb-1 text-5xl font-semibold text-gray-900 mt-11 ml-14 date modal-title"'
                                    +'>'+element.title+'</h1'
                                    +'><a href="'+element.platform.url+'" class="text-2xl font-semibold text-blue-800 ml-7">Join Google Meet</a><br>'
                                    +'<span class="relative inline-block pt-2 text-2xl font-normal text-black ml-14 date modal-title"'
                                    +'>with mentor <span class="text-2xl font-normal text-blue-800">'+element.mentor.fullName+'</span></span'
                                    +'>'
                                    +'<div class="flex ml-7 modal-body">'
                                    +'<span class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200 rounded-2xl date modal-title"'
                                    +'>'+startConvertNewMeetingTime.slice(16,21)+'</span>'
                                    +'<h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date modal-title p2"'
                                    +'>to:</h1'
                                    +'>'
                                    +'<span class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200 rounded-2xl date modal-title"'
                                    +'>'+endConvertConvertNewMeetingTime.slice(16,21)+'</span>'
                                    +'<h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date modal-title p2"'
                                    +'>date:</h1'
                                    +'>'
                                    +'<span class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200 rounded-2xl date modal-title"'
                                    +'>'+startDayNewMeeting+'/'+startMonthNewMeeting+'/'+startConvertNewMeeting.getFullYear()+'</span>'
                                    +'</div>'
                                    +'<div class="flex mb-4 modal-body">'
                                    +'<p class="mr-5 font-normal text-gray-500 ml-9">'+element.description+'</p>'
                                    +'</div>'
                                    +'</div>'
                                    +'<div class="flex justify-center w-full space-x-16 mt-9 mb-14">'
                                    +'<a href="" onClick="(function(){'
                                    +"const varToString = varObj => Object.keys(varObj)[0];"
                                    +"const " + meetingId +"=z;"
                                    +"const x = varToString({"
                                    +meetingId
                                    +"});"
                                    +"console.log(x);"
                                    +"const json = {"
                                    +"userId: userId,"
                                    +"meetingId: x.replace(z,space),"
                                    +"};"
                                    +"console.log(json);"
                                    +"const options = {"
                                    +"method: postMethodNewMeeting,"
                                    +"body: JSON.stringify(json),"
                                    +"headers: {"
                                    +"contentType: appJsonNewMeeting,"
                                    +"},"
                                    +"};"
                                    +"console.log(options);"
                                    +"console.log(urlFollowNewMeeting);"
                                    +"fetch(urlFollowNewMeeting, options)"
                                    +".then((res) => res.json())"
                                    +".then((res) => alert(followNotiNewMeeting))"
                                    +".catch((err) => alert(err));"
                                    +'})();return false;">'
                                    +'<button'
                                    +' class="p-4 text-2xl font-semibold text-black bg-transparent border-2 border-gray-200 pl-28 pr-28 rounded-2xl hover:text-blue-500 focus:border-4 focus:border-blue-300"'
                                    +'>'
                                    +'Follow'
                                    +'</button>'
                                    +'</a>'
                                    +'<button'
                                    +' class="p-4 pl-20 pr-20 text-2xl font-semibold text-white bg-indigo-700 border-blue-300 rounded-2xl focus:border-4 hover:bg-indigo-900"'
                                    +'>'
                                    +'Leave question'
                                    +'</button>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                                    +'</div>'
                            }

                        let new_meeting_dialog = document.getElementById("new_meeting_dialog");
                        new_meeting_dialog.innerHTML = htmlDialogsNewMeeting;
                    });
</script>
</body>
</html>
