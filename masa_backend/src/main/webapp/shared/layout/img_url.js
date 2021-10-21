${'.card-meeting'}.load(function{
    //b them cai class="card-meeting" vao cai div dau tien sau the li
    // hoac edit cai dk nhan dang category trong nay
    var temp = content.find(o => o.id == this.id);
    if (temp=="se"){
        $('.object-cover').append("<img src='" + "https://image.freepik.com/free-vector/programming-concept-illustration_114360-1213.jpg" + "'>");
    }

    else if (temp=="gd"){
        $('.object-cover').append("<img src='" + "https://image.freepik.com/free-vector/designer-girl-concept-illustration_114360-4455.jpg" + "'>");
    }

    else if (temp=="bm"){
        $('.object-cover').append("<img src='" + "https://image.freepik.com/free-vector/remote-business-management-concept-with-businessman-holding-tablet-showing-analytics-graphs-connected_1284-44658.jpg" + "'>");
    }

    else if (temp=="dm"){
        $('.object-cover').append("<img src='" + "https://image.freepik.com/free-vector/hand-drawn-illustration-people-with-smartphone-marketing_52683-66658.jpg" + "'>");
    }

    else if (temp=="jl"){
        $('.object-cover').append("<img src='" + "https://png.pngtree.com/element_our/20190531/ourlarge/pngtree-vector-cartoon-free-buckle-japan-image_1321521.jpg" + "'>");
    }

    else if (temp=="el"){
        $('.object-cover').append("<img src='" + "https://image.freepik.com/free-vector/famous-showplaces-united-kingdom_126523-12.jpg" + "'>");
    }

    else if (temp=="ia"){
        $('.object-cover').append("<img src='" + "https://image.freepik.com/free-vector/global-data-security-personal-data-security-cyber-data-security-online-concept-illustration-internet-security-information-privacy-protection_1150-37336.jpg" + "'>");
    }

    else if (temp=="ai"){
        $('.object-cover').append("<img src='" + "https://image.freepik.com/free-vector/cloud-robotics-abstract-concept-illustration_335657-3801.jpg" + "'>");
    }

    else if (temp=="ss"){
        $('.object-cover').append("<img src='" + "https://image.freepik.com/free-vector/scrum-board-concept-illustration_114360-2981.jpg" + "'>");
    }

    else if (temp=="mm"){
        $('.object-cover').append("<img src='" + "https://image.freepik.com/free-vector/company-employees-use-web-search-find-ideas-doing-business-company_1150-43196.jpg" + "'>");
    }

});