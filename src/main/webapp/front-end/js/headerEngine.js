

//click initializer
$( document ).ready(function(){
    var data = {};
    $("#Register").click(function(){
        data.name = document.getElementById("rname").value;
        data.password = document.getElementById("rpassword").value;
        data.email = document.getElementById("remail").value;
        data.phone = document.getElementById("rphone").value;

        callAjax("/onlineShop/registerServlet",data);
    });
   /* $("#products").click(function(){
        data.page = "product";
        callAjax("/onlineShop/dispatcherServlet",data);
    });
     $("#myAcount").click(function(){
        data.page = "myaccount";
        callAjax("/onlineShop/dispatcherServlet",data);
    });
    $("#SingUp").click(function(){
        data.page = "singup";
        callAjax("/onlineShop/dispatcherServlet",data);
    });
*/
});




function  callAjax(url,data){
    $.ajax({
        type: 'GET',
        contentType: 'application/x-www-form-urlencoded; charset=utf-8',
        dataType: 'json',
        mimeType: 'application/json',
        async: true,
        url: url,
        data: data,
        success: function (result) {
            console.log(result);
            alert(result.finish);
            initQueue(url,result);
        }
    });
}


function initQueue(url,data){
    if(data.finish === "success"){
        window.location.href = "/onlineShop/dispatcherServlet?page=singin";
    }
}