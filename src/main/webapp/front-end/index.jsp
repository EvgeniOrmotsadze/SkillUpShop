<%@ page import="javax.ejb.EJB" %>
<%@ page import="ge.evgo.shop.ejb.UserBeanDao" %>
<%@ page import="ge.evgo.shop.ejb.ProductBeanDao" %>
<%@ page import="java.util.List" %>
<%@ page import="ge.evgo.shop.model.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="ge.evgo.shop.model.ProductType" %>

<%@include file="header.jsp"%>




  <div class="top_divider"><img src="images/header_divider.png" alt="" width="1" height="64" /></div>
    <!-- end of menu tab -->
    <div class="left_content">
      <div class="title_box">Categories</div>
      <ul class="left_menu">
        <%
          List<ProductType> productTypes = (List<ProductType>)request.getSession().getAttribute("productTypes");
          if(productTypes != null) {
            for (ProductType type : productTypes){
        %>
          <li class="odd"><a href="/onlineShop/searchServlet?type=<%=type.getId()%>"><%=type.getName()%></a></li>
        <%
            }
          }
        %>

      </ul>
     <!-- <div class="title_box">Special Products</div>
      <div class="border_box">
        <div class="product_title"><a href="details.jsp">Motorola 156 MX-VL</a></div>
        <div class="product_img"><a href="details.jsp"><img src="images/laptop.png" alt="" border="0" /></a></div>
        <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
      </div>-->


    </div>
    <!-- end of left content -->
    <div class="center_content">
      <%
        @SuppressWarnings("unchecked")
        List<Product> productList = (List<Product>)request.getSession().getAttribute("products");
      %>
      <div class="center_title_bar"> Product </div>
      <%
        if(productList != null){
         for(int i = 0; i < productList.size(); i++){
      %>

      <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
          <div class="product_title"><a><%=productList.get(i).getTitle() %></a></div>
          <div class="product_img"><a><img src="images/laptop.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="price"><%= productList.get(i).getPrice()%></span></div>
        </div>
        <div class="bottom_prod_box"></div>
        <div class="prod_details_tab"> <a href="/onlineShop/productDetail?id=<%=productList.get(i).getId()%>" class="prod_details">details</a> </div>
      </div>

      <%
          }
        }
      %>
    <%--  <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
          <div class="product_title"><a href="details.jsp">Iphone Apple</a></div>
          <div class="product_img"><a href="details.jsp"><img src="images/p4.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="price">270$</span></div>
        </div>
        <div class="bottom_prod_box"></div>
        <div class="prod_details_tab"> <img src="images/favorites.gif" alt="" border="0" class="left_bt" /></a> <a href="details.jsp" class="prod_details">details</a> </div>
      </div>
      <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
          <div class="product_title"><a href="front-end/details.html">Samsung Webcam</a></div>
          <div class="product_img"><a href="details.jsp"><img src="images/p5.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
        </div>
        <div class="bottom_prod_box"></div>
        <div class="prod_details_tab"> <a href="http://all-free-download.com/free-website-templates/" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="images/favs.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="images/favorites.gif" alt="" border="0" class="left_bt" /></a> <a href="details.jsp" class="prod_details">details</a> </div>
      </div>
      <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
          <div class="product_title"><a href="details.jsp">Motorola 156 MX-VL</a></div>
          <div class="product_img"><a href="details.jsp"><img src="images/laptop.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
        </div>
        <div class="bottom_prod_box"></div>
        <div class="prod_details_tab"> <a href="http://all-free-download.com/free-website-templates/" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="images/favs.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="images/favorites.gif" alt="" border="0" class="left_bt" /></a> <a href="details.jsp" class="prod_details">details</a> </div>
      </div>
      <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
          <div class="product_title"><a href="details.jsp">Iphone Apple</a></div>
          <div class="product_img"><a href="details.jsp"><img src="images/p4.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="price">270$</span></div>
        </div>
        <div class="bottom_prod_box"></div>
        <div class="prod_details_tab"> <a href="http://all-free-download.com/free-website-templates/" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="images/favs.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="images/favorites.gif" alt="" border="0" class="left_bt" /></a> <a href="details.jsp" class="prod_details">details</a> </div>
      </div>
      <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
          <div class="product_title"><a href="details.jsp">Samsung Webcam</a></div>
          <div class="product_img"><a href="details.jsp"><img src="images/p5.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
        </div>
        <div class="bottom_prod_box"></div>
        <div class="prod_details_tab"> <a href="http://all-free-download.com/free-website-templates/" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="images/favs.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="images/favorites.gif" alt="" border="0" class="left_bt" /></a> <a href="details.jsp" class="prod_details">details</a> </div>
      </div>
      <div class="center_title_bar">Recommended Products</div>
      <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
          <div class="product_title"><a href="details.jsp">Motorola 156 MX-VL</a></div>
          <div class="product_img"><a href="details.jsp"><img src="images/laptop.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
        </div>
        <div class="bottom_prod_box"></div>
        <div class="prod_details_tab"> <a href="http://all-free-download.com/free-website-templates/" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="images/favs.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="images/favorites.gif" alt="" border="0" class="left_bt" /></a> <a href="details.jsp" class="prod_details">details</a> </div>
      </div>
      <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
          <div class="product_title"><a href="details.jsp">Iphone Apple</a></div>
          <div class="product_img"><a href="details.jsp"><img src="images/p4.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="price">270$</span></div>
        </div>
        <div class="bottom_prod_box"></div>
        <div class="prod_details_tab"> <a href="http://all-free-download.com/free-website-templates/" title="header=[Add to cart] body=[&nbsp;] fade=[on]"><img src="images/cart.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Specials] body=[&nbsp;] fade=[on]"><img src="images/favs.gif" alt="" border="0" class="left_bt" /></a> <a href="http://all-free-download.com/free-website-templates/" title="header=[Gifts] body=[&nbsp;] fade=[on]"><img src="images/favorites.gif" alt="" border="0" class="left_bt" /></a> <a href="details.jsp" class="prod_details">details</a> </div>
      </div>
      <div class="prod_box">
        <div class="top_prod_box"></div>
        <div class="center_prod_box">
          <div class="product_title"><a href="details.jsp">Samsung Webcam</a></div>
          <div class="product_img"><a href="details.jsp"><img src="images/p5.gif" alt="" border="0" /></a></div>
          <div class="prod_price"><span class="reduce">350$</span> <span class="price">270$</span></div>
        </div>
        <div class="bottom_prod_box"></div>
      </div>
    </div>--%>
    <!-- end of center content -->


  </div>
  <!-- end of main content -->
  <%--<div class="footer">
    <div class="left_footer"> <img src="images/footer_logo.png" alt="" width="170" height="49"/> </div>
    <div class="center_footer"> Template name. All Rights Reserved 2008<br />
      <a href="http://csscreme.com"><img src="images/csscreme.jpg" alt="csscreme" border="0" /></a><br />
      <img src="images/payment.gif" alt="" /> </div>
  </div>--%>
</div>
<!-- end of main_container -->
</div>
</body>
</html>
