<%@ page import="ge.evgo.shop.model.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Electronix Store - Details</title>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1252" />
<link rel="stylesheet" type="text/css" href="css/style.css" />
<!--[if IE 6]>
<link rel="stylesheet" type="text/css" href="css/iecss.css" />
<![endif]-->
<script type="text/javascript" src="js/windowopen.js"></script>
<script type="text/javascript" src="js/boxOver.js"></script>
</head>
<body>

<%@include file="header.jsp"%>
    <!-- end of left content -->

    <% Product product = (Product)request.getSession().getAttribute("Product");
       if(product != null) {
    %>
    <div class="center_content">
      <div class="center_title_bar"><%= product.getModel() %></div>
      <div class="prod_box_big">
        <div class="top_prod_box_big"></div>
        <div class="center_prod_box_big">
          <div class="product_img_big"> <a href="javascript:popImage('images/big_pic.jpg','Some Title')" title="header=[Zoom] body=[&nbsp;] fade=[on]"><img src="images/laptop.gif" alt="" border="0" /></a>
          </div>
          <div class="details_big_box">
            <div class="product_title_big"><%=product.getTitle()%></div>
            <div class="specifications"> Disponibilitate: <span class="blue">In stoc <%=product.getQuantity()%> </span><br />

              Product Description :  <span class="blue"><%=product.getDescription()%></span><br />
              Product Type :  <span class="blue"><%=product.getProductType().getName()%></span><br />
            </div>
            <div class="prod_price_big">
              <span class="price"><%=product.getPrice()%></span></div>
              <a href="/onlineShop/buyProduct?id=<%=product.getId()%>" id="buyIt" class="addtocart"> Buy It </a></div>
        </div>
        <div class="bottom_prod_box_big"></div>
      </div>


    </div>

    <% } %>

</body>
</html>
