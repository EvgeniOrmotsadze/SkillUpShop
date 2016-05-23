<%@include file="header.jsp" %>

<div class="center_content">
    <div class="center_title_bar">Contact Us</div>
    <div class="prod_box_big">
        <div class="top_prod_box_big"></div>
        <div class="center_prod_box_big">
            <form action="/onlineShop/loginServlet" method="post">
                <div class="contact_form">
                    <div class="form_row">
                        <label class="contact"><strong>Name:</strong></label>
                        <input type="text" name="name" class="contact_input"/>
                    </div>
                    <div class="form_row">
                        <label class="contact"><strong>Password:</strong></label>
                        <input type="password" name="password" class="contact_input"/>
                    </div>
                    <div class="form_row">
                        <button type="submit" id="Register" class="contact_input">LOG IN</button>
                    </div>
                </div>

            </form>
        </div>
        <div class="bottom_prod_box_big"></div>
    </div>
</div>

</body>
</hmtl>