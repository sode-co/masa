<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <meta http-equiv="X-UA-Compatible" content="ie=edge" />
    <title>DialogTest</title>
    <link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet" />
    <script src="https://cdn.jsdelivr.net/gh/alpinejs/alpine@v2.x.x/dist/alpine.min.js" defer></script>

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
<section class="flex flex-wrap items-center h-full p-4">
    <button
            type="button"
            class="px-4 py-2 font-bold text-gray-500 bg-transparent border border-gray-500 rounded-full  hover:border-indigo-500 hover:text-indigo-500"
            @click="showModal = true"
    >
        Show dialog
    </button>

    <!--Overlay-->
    <div
            class="overflow-auto"
            style="background-color: rgba(0, 0, 0, 0.5)"
            x-show="showModal"
            :class="{ 'absolute inset-0 z-10 flex items-center justify-center': showModal }"
    >
        <!--Dialog-->
        <div
                class="px-6 py-4 mx-auto text-left bg-white shadow-lg rounded-3xl"
                x-show="showModal"
                @click.away="showModal = false"
                style="width: 680px"
        >
            <!--Title-->
            <div class="flex items-center justify-between pb-3">
                <p class="text-lg font-bold mt-11 ml-14">Meeting Information</p>
                <div class="z-50 cursor-pointer" @click="showModal = false">
                    <svg class="text-black fill-current" xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 18 18">
                        <path
                                d="M14.53 4.53l-1.06-1.06L9 7.94 4.53 3.47 3.47 4.53 7.94 9l-4.47 4.47 1.06 1.06L9 10.06l4.47 4.47 1.06-1.06L10.06 9z"
                        ></path>
                    </svg>
                </div>
            </div>

            <!-- content -->
            <!-- <p>Modal content can go here</p>
            <p>...</p>
            <p>...</p>
            <p>...</p>
            <p>...</p> -->
            <!-- <button type="button" class="mr-16 close mt-9" data-dismiss="modal" aria-label="Close">
                <span class="text-4xl" aria-hidden="true">&times;</span>
            </button>
            <h4 class="text-2xl font-bold text-black mt-11 ml-14 modal-title" id="myModalLabel">Meeting Information</h4> -->
            <div>
                <h1 class="relative inline-block mb-1 text-5xl font-semibold text-gray-900 mt-11 ml-14 date modal-title">
                    React for beginner
                </h1>
                <a href="#" class="text-2xl font-semibold text-blue-800 ml-7">Join Zoom</a><br />
                <span class="relative inline-block pt-2 text-2xl font-normal text-black ml-14 date modal-title"
                >with mentor <span class="text-2xl font-normal text-blue-800">Thieu Ngoc</span></span
                >
                <div class="flex ml-7 modal-body">
                            <span
                                    class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200  rounded-2xl date modal-title"
                            >10:10</span
                            >
                    <h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date modal-title p2">to:</h1>
                    <span
                            class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200  rounded-2xl date modal-title"
                    >20:20</span
                    >
                    <h1 class="relative inline-block my-auto ml-2 mr-2 text-2xl font-semibold text-gray-900 date modal-title p2">date:</h1>
                    <span
                            class="relative inline-block p-2 pl-5 pr-5 text-3xl font-bold text-blue-800 bg-transparent border-2 border-gray-200  rounded-2xl date modal-title"
                    >15/05/2021</span
                    >
                </div>
                <div class="flex mb-4 modal-body">
                    <p class="mr-5 font-normal text-gray-500 ml-9">
                        Lorem ipsum dolor sit amet, consectetur adipiscing elit. Euismod ut sit lacus risus malesuada magna lectus. Aliquet
                        viverra volutpat orci lacus aliquam, amet duis viverra. Auctor tortor facilisis magna praesent nunc, tristique felis
                        amet, nibh. Lacinia mauris vulputate quis pretium sed. Arcu risus ac justo condimentum amet, mauris tempor. Posuere
                        viverra pellentesque tempus euismod est aliquam sit enim massa. Potenti volutpat, sed turpis tempor arcu elementum.
                    </p>
                </div>
            </div>
            <div class="flex justify-center w-full space-x-16 mt-9 mb-14">
                <button
                        class="p-4 text-2xl font-semibold text-black bg-transparent border-2 border-gray-200  pl-28 pr-28 rounded-2xl hover:text-blue-500 focus:border-4 focus:border-blue-300"
                >
                    Follow
                </button>

                <button
                        class="p-4 pl-20 pr-20 text-2xl font-semibold text-white bg-indigo-700 border-blue-300  rounded-2xl focus:border-4 hover:bg-indigo-900"
                >
                    Leave question
                </button>
            </div>

            <!--Footer-->
            <!-- <div class="flex justify-end pt-2">
                <button
                    class="p-3 px-4 mr-2 text-indigo-500 bg-transparent rounded-lg hover:bg-gray-100 hover:text-indigo-400"
                    @click="alert('Additional Action');"
                >
                    Action
                </button>
                <button class="p-3 px-4 text-white bg-indigo-500 rounded-lg modal-close hover:bg-indigo-400" @click="showModal = false">
                    Close
                </button>
            </div> -->
        </div>
        <!--/Dialog -->
    </div>
    <!-- /Overlay -->
</section>
</body>
</html>