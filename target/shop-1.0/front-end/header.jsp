<%@ page import="ge.evgo.shop.model.Users" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Electronix Store</title>
    <!--<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />-->

    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/boxOver.js"></script>
    <script type="text/javascript" src="js/lib/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/headerEngine.js"></script>

</head>
<body>
<div id="main_container">
    <div class="top_bar">
        <div class="top_search" id="saerch_t">
            <!--<div class="search_text">Advanced Search</a></div>-->
            <input type="text" class="search_input" name="search" />
            <input type="image" src="images/search.gif" class="search_bt"/>
        </div>
        <div class="languages">
            <img src="images/en.gif" alt="" border="0"/> </div>
    </div>
    <div id="header">
        <div id="logo"> <img src="images/skill-up-trans.png" alt="" border="0" width="237" height="140" /></a> </div>
        <div class="oferte_content">
            <div class="top_divider"><img src="images/header_divider.png" alt="" width="1" height="164" /></div>
            <div class="oferta">
                <div class="top_divider"><img src="images/header_divider.png" alt="" width="1" height="164" /></div>
            </div>
            <!-- end of oferte_content-->
        </div>
        <div id="main_content">
            <div id="menu_tab">
                <div class="left_menu_corner"></div>
                <ul class="menu">
                    <li><a href="/onlineShop/dispatcherServlet?page=home" id="home" class="nav1"> Home</a></li>
                    <li class="divider"></li>
                    <li><a href="/onlineShop/dispatcherServlet?page=product" id="products" class="nav2">Products</a></li>
                    <li class="divider"></li>
                    <li><a href="/onlineShop/dispatcherServlet?page=myaccount" id="myAcount" class="nav4">My account</a></li>
                    <li class="divider"></li>
                    <li><a href="/onlineShop/dispatcherServlet?page=contact" class="nav6">Contact Us</a></li>
                    <li class="divider"></li>
                    <%
                        if (request.getSession().getAttribute("user") == null) {
                    %>
                    <li><a  href="/onlineShop/dispatcherServlet?page=singup" id="SingUp" class="nav4">Sign Up</a></li>
                    <li class="divider"></li>
                    <li><a  href="/onlineShop/dispatcherServlet?page=singin" id="SingIN" class="nav4">Log In</a></li>
                    <li class="divider"></li>
                    <%
                        } else {
                            Users user = (Users) request.getSession().getAttribute("user");
                            String name = user.getName();
                    %>
                    <li><a   id="userName" class="nav4">Welcome <%=name%> </a></li>
                    <li class="divider"></li>
                    <li><a  href="/onlineShop/logout" id="SingOUT" class="nav4">Log Out</a></li>
                    <li class="divider"></li>
                    <li><a  id="cash" class="nav4"><%=user.getCash()%> $ </a></li>
                    <li class="divider"></li>
                    <%
                        }
                    %>
                </ul>
            </div>
            </div>
        </div>
    </div>

