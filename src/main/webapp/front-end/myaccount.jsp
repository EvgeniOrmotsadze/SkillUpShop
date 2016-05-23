<%@ page import="java.util.List" %>
<%@ page import="ge.evgo.shop.model.Product" %>
<%@include file="header.jsp" %>


<%
    if (request.getSession().getAttribute("user") == null) {
        response.sendRedirect("/onlineShop/front-end/singin.jsp");
    } else {

        List<Product> products = ((Users)request.getSession().getAttribute("user")).getProducts();

%>
<div class="center_content">
    <div class="center_title_bar">My Products</div>
    <% for(Product product : products){  %>
    <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
            <div class="product_title"><a href="details.jsp"><%=product.getModel()%></a></div>
            <div class="product_img"><img src="images/laptop.gif" alt="" border="0"/></div>
            <span class="price"><%=product.getPrice()%> $</span></div>
    </div>
    <%} %>

</div>

<%
    }
%>

</body>
</html>
