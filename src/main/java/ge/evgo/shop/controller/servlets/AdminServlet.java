package ge.evgo.shop.controller.servlets;

import ge.evgo.shop.ejb.ProductTypeBeanDao;
import ge.evgo.shop.ejb.ProductBeanDao;
import ge.evgo.shop.model.Image;
import ge.evgo.shop.model.Product;
import ge.evgo.shop.model.ProductType;


import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root_pc on 4/23/2016.
 */
@WebServlet(name = "AdminServlet")
@MultipartConfig
public class AdminServlet extends HttpServlet {


    @EJB
    ProductBeanDao productBeanDao;

    @EJB
    ProductTypeBeanDao productTypeBeanDao;

    public AdminServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String title = request.getParameter("title");
        String price = request.getParameter("price");
        String model = request.getParameter("model");
        String quantity = request.getParameter("quantity");
        String description = request.getParameter("description");
        String productType = request.getParameter("protype");

        ProductType productT =  productTypeBeanDao.saveProductType(productType);

        Product product = new Product();
        product.setModel(model);
        product.setPrice(Double.parseDouble(price));
        product.setQuantity(Integer.parseInt(quantity));
        product.setTitle(title);
        product.setDescription(description);
        product.setProductType(productT);


        Part filePart1 = request.getPart("photo1");
        Part filePart2 = request.getPart("photo2");
        Part filePart3 = request.getPart("photo3");

        String savePath = "d:\\shop";
        System.out.println(savePath);
        checkDirectory(savePath);
        String fileName1 = getFileName(filePart1);
        String fileName2 = getFileName(filePart2);
        String fileName3 = getFileName(filePart3);

        saveFileInDisk(savePath,fileName1,filePart1);
        saveFileInDisk(savePath, fileName2, filePart2);
        saveFileInDisk(savePath, fileName3, filePart3);

        List<Image> imagess = new ArrayList<Image>();

        Image image1 = new Image();
        image1.setImageName(fileName1);
     /*   image1.setProduct(product);*/

        Image image2 = new Image();
        image2.setImageName(fileName2);
      //  image2.setProduct(product);

        Image image3 = new Image();
        image3.setImageName(fileName3);
       // image3.setProduct(product);

       /* imageBeanDao.saveImage(image1);
        imageBeanDao.saveImage(image2);
        imageBeanDao.saveImage(image3);*/

        imagess.add(image1);
        imagess.add(image2);
        imagess.add(image3);

        product.setImages(imagess);
        productBeanDao.saveProduct(product);
        productT.getProduct().add(product);
        productTypeBeanDao.updateProductType(productT);
    }


    private void saveFileInDisk(String savePath,String fileName,Part part){
        OutputStream out = null;
        InputStream filecontent = null;
        try {
            out = new FileOutputStream(new File(savePath + File.separator + fileName));
            filecontent = part.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = filecontent.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            out.close();
            filecontent.close();
        }catch (Exception ex){

        }

    }

    private void checkDirectory(String path){
        File fileSaveDir = new File(path);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }
    }


    private String getFileName(Part part){
        String fileName = "";
        String strContent = part.getHeader("content-disposition");
        String[] tokens = strContent.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
                fileName = (token.substring(token.indexOf("=") + 2, token.length()-1));
            }
        }
        return fileName;
    }


    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }

}
