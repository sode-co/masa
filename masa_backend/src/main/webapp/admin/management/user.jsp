<%@ page import="com.devlogs.masa_backend.common.Masa"%>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <%@include file="../../shared/gg_analytics/_analytics_script"%>

    <title>Administrator Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    <!-- Custom fonts for this template -->
<!--    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">-->
    <link
            href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
            rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/sb-admin-2.min.css" rel="stylesheet">
    <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

    <!-- Custom styles for this page -->
<!--    <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">-->
    <style>
        #tableUser{
            visibility: hidden;
        }
    </style>

    <script>
        let page = 0;
        if(window.location.href==="${Masa.SERVER_HOST}/admin/management/user.jsp"){
            setTimeout(function() {
                $('#splash').fadeOut('fast');
            }, 300);

            setTimeout(function () {
                document.getElementById("tableUser").style.visibility = "visible";
            }, 500);
        }else{
            setTimeout(function() {
                $('#splash').fadeOut('fast');
            }, -1);

            setTimeout(function () {
                document.getElementById("tableUser").style.visibility = "visible";
            }, 0);
        }

        function toleft(){
            if(page>0) --page;
            else page = 0;
            window.location.replace("${Masa.SERVER_HOST}/admin/management/user.jsp"+"?page="+page);
            console.log(page);
        }
        function toright(){
            ++page;
            window.location.replace("${Masa.SERVER_HOST}/admin/management/user.jsp"+"?page="+page);
            console.log(page);
        }
    </script>

</head>

<body id="page-top">

<!-- Page Wrapper -->
<div id="wrapper">

    <!-- Sidebar -->
    <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

        <!-- Sidebar - Brand -->
        <a class="sidebar-brand d-flex align-items-center justify-content-center" href="index.jsp">
            <div class="sidebar-brand-icon rotate-n-15">
                <i class="fas fa-laugh-wink"></i>
            </div>
            <div class="sidebar-brand-text mx-3">MASA</div>
        </a>

        <!-- Divider -->
        <hr class="sidebar-divider my-0">

        <!-- Nav Item - Dashboard -->
        <li class="nav-item active">
            <a class="nav-link" href="index.jsp">
                <i class="fas fa-fw fa-tachometer-alt"></i>
                <span>Dashboard</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            User Management
        </div>
        <li class="nav-item">
            <a class="nav-link" href="user.jsp">
                <i class="fas fa-fw fa-users"></i>
                <span>All User</span>
            </a>
        </li>

        <!-- Nav Item - Pages Collapse Menu -->
        <li class="nav-item">
            <a class="nav-link" href="mentor.jsp">
                <i class="fas fa-fw fa-chalkboard-teacher"></i>
                <span>Mentors</span>
            </a>
        </li>

        <li class="nav-item">
            <a class="nav-link" href="student.jsp">
                <i class="fas fa-fw fa-user-graduate"></i>
                <span>Students</span>
            </a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="member.jsp">
                <i class="fas fa-fw fa-user"></i>
                <span>Other</span>
                <p style="font-size: 10px; font-style: italic">can become mentor</p>
            </a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider">

        <!-- Heading -->
        <div class="sidebar-heading">
            Meeting Management
        </div>


        <!-- Nav Item - Meetings -->
        <li class="nav-item">
            <a class="nav-link" href="meeting.jsp">
                <i class="fas fa-fw fa-calendar"></i>
                <span>Meetings</span></a>
        </li>
        <div class="sidebar-heading">
            Request Management
        </div>

        <!-- Nav Item - Tables -->
        <li class="nav-item">
            <a class="nav-link" href="request.jsp">
                <i class="fas fa-fw fa-question"></i>
                <span>Requests</span></a>
        </li>

        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block">

        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>


    </ul>
    <!-- End of Sidebar -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">

        <!-- Main Content -->
        <div id="content">

            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                <!-- Sidebar Toggle (Topbar) -->
                <form class="form-inline">
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>
                </form>
                <script>
                    function search(){
                        window.location.replace('${Masa.SERVER_HOST}/admin/management/user.jsp'+'?name='+document.getElementById("inputsearchname").value)
                    }
                </script>
                <!-- Topbar Search -->
                <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                    <div class="input-group">
                        <input type="text" class="form-control bg-light border-0 small" placeholder="Search user by name..."
                               aria-label="Search" aria-describedby="basic-addon2" id="inputsearchname">
                        <div class="input-group-append">
                            <button class="btn btn-primary" type="button" onclick="search()">
                                <i class="fas fa-search fa-sm"></i>
                            </button>
                        </div>
                    </div>
                </form>

                <ul class="navbar-nav ml-auto">

                    <li class="nav-item dropdown no-arrow d-sm-none">
                        <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <i class="fas fa-search fa-fw"></i>
                        </a>
                        <!-- Dropdown - Messages -->
                        <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                             aria-labelledby="searchDropdown">
                            <form class="form-inline mr-auto w-100 navbar-search">
                                <div class="input-group">
                                    <input type="text" class="form-control bg-light border-0 small"
                                           placeholder="Search for..." aria-label="Search"
                                           aria-describedby="basic-addon2">
                                    <div class="input-group-append">
                                        <button class="btn btn-primary" type="button">
                                            <i class="fas fa-search fa-sm"></i>
                                        </button>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </li>

                    <a href="${Masa.SERVER_HOST}/auth-management/signout" style="color: #9b9a9a; margin-top: 17px;text-decoration: none; border-color: red">
                        <button class="btn btn-outline-dark">
                            <span style="font-size: 14px; font-weight: 600">Log Out</span>
                            &nbsp;
                            <svg style="margin-bottom: 3px" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-right" viewBox="0 0 16 16">
                                <path fill-rule="evenodd" d="M10 12.5a.5.5 0 0 1-.5.5h-8a.5.5 0 0 1-.5-.5v-9a.5.5 0 0 1 .5-.5h8a.5.5 0 0 1 .5.5v2a.5.5 0 0 0 1 0v-2A1.5 1.5 0 0 0 9.5 2h-8A1.5 1.5 0 0 0 0 3.5v9A1.5 1.5 0 0 0 1.5 14h8a1.5 1.5 0 0 0 1.5-1.5v-2a.5.5 0 0 0-1 0v2z"/>
                                <path fill-rule="evenodd" d="M15.854 8.354a.5.5 0 0 0 0-.708l-3-3a.5.5 0 0 0-.708.708L14.293 7.5H5.5a.5.5 0 0 0 0 1h8.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3z"/>
                            </svg>
                        </button>
                    </a>

                    <div class="topbar-divider d-none d-sm-block"></div>

                    <!-- Nav Item - User Information -->
                    <li class="nav-item dropdown no-arrow">
                        <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                           data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.CURRENT_USER.fullName}</span>
                            <img class="img-profile rounded-circle"
                                 src="img/undraw_profile.svg">
                        </a>
                        <!-- Dropdown - User Information -->
                        <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                             aria-labelledby="userDropdown">
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                Profile
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                Settings
                            </a>
                            <a class="dropdown-item" href="#">
                                <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                                Activity Log
                            </a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                Logout
                            </a>
                        </div>
                    </li>

                </ul>

            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->

                <!-- Page Heading -->
                <div id="splash">
                    <iframe src="https://embed.lottiefiles.com/animation/9844" style="width: 1000px; height: 600px; border: transparent"></iframe>
                </div>
            <div class="container-fluid" id="tableUser">

                <!-- DataTales Example -->
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">All User</h6>
                    </div>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                <thead>
                                <tr>
                                    <th style="width: 30px">Index</th>
                                    <th style="width: 210px">Full Name</th>
                                    <th>Email</th>
                                    <th></th>
                                </tr>
                                </thead>
                                <script>
                                    const container = document.getElementById("container");
                                    let i = 0;
                                    const urlStatus="${Masa.SERVER_HOST}/api/user-management/update-status/";
                                    const urlRole="${Masa.SERVER_HOST}/api/user-management/update-role/";
                                    let idsession = 0;
                                    let space = '';
                                    let z = 'z';
                                    let bugreload = '#';
                                    const statusAlert = "UPDATE STATUS SUCCESS";
                                    const roleAlert = "UPDATE ROLE SUCCESS";
                                    let paramName;
                                    if(location.search.replace('?name=','')==='' || location.search.includes('page')){
                                        urlTable = "${Masa.SERVER_HOST}/api/user-management/all";
                                    }else{
                                        urlTable = "${Masa.SERVER_HOST}/api/user-management/get-user-by-name/"+location.search.replace('?name=','').replace('%20',' ');
                                    }
                                    function displayData() {
                                        $.getJSON(
                                            urlTable,
                                            function (data) {
                                                let htmlElements = "";
                                                let currentPage;
                                                if(window.location.href.indexOf("page")>0){
                                                    currentPage = window.location.href.slice(window.location.href.indexOf("page=")).replaceAll("page=",'');
                                                }else{
                                                    currentPage = 0;
                                                }
                                                const arr = data["users"].slice(10*currentPage, 10*currentPage+11);
                                                arr.forEach((element) => {
                                                    i++;
                                                    idsession = 'z'+ element.id;
                                                    if(element.status.status === 'ACTIVE'){
                                                        htmlElements +=
                                                            '<tr>'
                                                            +'<td>'+i+'</td>'
                                                            +'<td>'+element.fullName+'</td>'
                                                            +'<td>'+element.email+'</td>'
                                                            //    +'<td>'+element.status.status+'</td>'
                                                            +'<td>'
                                                            +'<div style="background-color: #f57640; width: 110px; height: 30px; border-radius: 25px; padding-top: 2px; padding-left: 22px; font-weight: 300">'
                                                            +'<a href="" onClick="(function(){'
                                                            +'const varToString = varObj => Object.keys(varObj)[0];'
                                                            +'const '+idsession+'=i;'
                                                            +'const x = varToString({'+idsession+'});'
                                                            +'const url = urlStatus + x.replace(z, space);'
                                                            +'console.log(url);'
                                                            +'$.getJSON(url, function(data) {'
                                                            +'console.log(data);'
                                                            +'});'
                                                            +'alert(statusAlert);'
                                                            +'window.location.replace(window.location.href);'
                                                            // +'window.location.replace(window.location.href);'
                                                            +'})();return false;">'
                                                            +'<button style="background-color: transparent; margin-bottom: 30px; border: none">BLOCK</button>'
                                                            +'</a>'
                                                            +'</div>'
                                                            +'</td>'
                                                            +'</tr>'
                                                    }else if(element.status.status === 'BLOCKED'){
                                                        htmlElements +=
                                                            '<tr>'
                                                            +'<td>'+i+'</td>'
                                                            +'<td>'+element.fullName+'</td>'
                                                            +'<td>'+element.email+'</td>'
                                                            //    +'<td>'+element.status.status+'</td>'
                                                            +'<td>'
                                                            +'<div style="background-color: #5bcb7d; width: 115px; height: 30px; border-radius: 25px; padding-top: 2px; padding-left: 12px; font-weight: 300">'
                                                            +'<a href="" onClick="(function(){'
                                                            +'const varToString = varObj => Object.keys(varObj)[0];'
                                                            +'const '+idsession+'=i;'
                                                            +'const x = varToString({'+idsession+'});'
                                                            +'const url = urlStatus + x.replace(z, space);'
                                                            +'console.log(url);'
                                                            +'$.getJSON(url, function(data) {'
                                                            +'console.log(data);'
                                                            +'});'
                                                            +'alert(statusAlert);'
                                                            +'window.location.replace(window.location.href);'
                                                            // +'window.location.replace(window.location.href);'
                                                            +'})();return false;">'
                                                            +'<button style="background-color: transparent; margin-bottom: 30px; border: none">UNBLOCK</button>'
                                                            +'</a>'
                                                            +'</div>'
                                                            +'</td>'
                                                            +'</tr>'
                                                    }
                                                    let container = document.getElementById("container");
                                                    container.innerHTML = htmlElements;
                                                });
                                            }
                                        );
                                            }
                                    setTimeout(function(){
                                        displayData();
                                    }, 1000);
                                </script>
                                <tbody id="container">

                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- End of Main Content -->
        <div style="margin-left: 550px">
            <button style="background-color: transparent; border: none" onclick="toleft()">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-left-circle" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-4.5-.5a.5.5 0 0 1 0 1H5.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L5.707 7.5H11.5z"/>
                </svg>
            </button>
            <button style="background-color: transparent; border: none" onclick="toright()">
                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-right-circle" viewBox="0 0 16 16">
                    <path fill-rule="evenodd" d="M1 8a7 7 0 1 0 14 0A7 7 0 0 0 1 8zm15 0A8 8 0 1 1 0 8a8 8 0 0 1 16 0zM4.5 7.5a.5.5 0 0 0 0 1h5.793l-2.147 2.146a.5.5 0 0 0 .708.708l3-3a.5.5 0 0 0 0-.708l-3-3a.5.5 0 1 0-.708.708L10.293 7.5H4.5z"/>
                </svg>
            </button>
        </div>

        <!-- Footer -->
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; slimair.cool MASA 2021</span>
                </div>
            </div>
        </footer>
        <!-- End of Footer -->

    </div>
    <!-- End of Content Wrapper -->

</div>
<!-- End of Page Wrapper -->

<!-- Scroll to Top Button-->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>

<!-- Logout Modal-->
<div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                <a class="btn btn-primary" href="com.devlogs.masa_backend.login.html">Logout</a>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap core JavaScript-->
<!--<script src="vendor/jquery/jquery.min.js"></script>-->
<!--<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>-->

<!-- Core plugin JavaScript-->
<!--<script src="vendor/jquery-easing/jquery.easing.min.js"></script>-->

<!-- Custom scripts for all pages-->
<script src="js/sb-admin-2.min.js"></script>

<!-- Page level plugins -->
<!--<script src="vendor/datatables/jquery.dataTables.min.js"></script>-->
<!--<script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>-->

<!-- Page level custom scripts -->
<script src="js/demo/datatables-demo.js"></script>

</body>

</html>