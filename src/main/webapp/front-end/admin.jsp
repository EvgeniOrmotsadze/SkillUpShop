<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>Electronix Shop admin - Details</title>

    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/boxOver.js"></script>
    <script type="text/javascript" src="js/lib/jquery-1.10.2.js"></script>
    <script type="text/javascript" src="js/headerEngine.js"></script>
</head>

<body>

<form action="/onlineShop/adminServlet" enctype="multipart/form-data"  method="post">
    <div class="contact_form">
        <div class="form_row">
            <label class="contact"><strong>Title:</strong></label>
            <input type="text" name="title" class="contact_input"/>
        </div>
        <div class="form_row">
            <label class="contact"><strong>Price:</strong></label>
            <input type="text" name="price" class="contact_input"/>
        </div>
        <div class="form_row">
            <label class="contact"><strong>Model:</strong></label>
            <input type="text" name="model" class="contact_input"/>
        </div>

        <div class="form_row">
            <label class="contact"><strong>Quantity:</strong></label>
            <input type="text" name="quantity" class="contact_input"/>
        </div>

        <div class="form_row">
            <label class="contact"><strong>Description:</strong></label>
            <input type="text" name="description" class="contact_input"/>
        </div>

        <div class="form_row">
            <label class="contact"><strong>ProductType:</strong></label>
            <input type="text" name="protype" class="contact_input"/>
        </div>

        <div class="form_row">
            <label class="contact"><strong>Photo1:</strong></label>
            <input type="file" name="photo1" class="contact_input"/>
        </div>

        <div class="form_row">
            <label class="contact"><strong>Photo2:</strong></label>
            <input type="file" name="photo2" class="contact_input"/>
        </div>

        <div class="form_row">
            <label class="contact"><strong>Photo3:</strong></label>
            <input type="file" name="photo3" class="contact_input"/>
        </div>

        <div class="form_row">
            <button type="submit" id="Register" class="contact_input">Save Product</button>
        </div>
    </div>

</form>

</body>
</html>
