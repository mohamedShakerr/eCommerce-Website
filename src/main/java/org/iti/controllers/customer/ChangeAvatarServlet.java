package org.iti.controllers.customer;
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.iti.dao.impl.CustomerDaoImpl;
import org.iti.dao.interfaces.CustomerDao;
import org.iti.dtos.CustomerDto;
import org.iti.utils.S3UploadManager;
/* The Java file upload Servlet example */

@WebServlet(name = "ChangeAvatarServlet", urlPatterns = { "/ChangeAvatarServlet" })
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
        maxFileSize = 1024 * 1024 * 10,      // 10 MB
        maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ChangeAvatarServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /* Receive file uploaded to the Servlet from the HTML5 form */
        Part filePart = request.getPart("file");
        byte[] img=filePart.getInputStream().readAllBytes();
        S3UploadManager s3UploadManager=new S3UploadManager();
        String url=s3UploadManager.uploadImage(img);
        HttpSession session=request.getSession();
        CustomerDto customerDto=(CustomerDto)session.getAttribute("customerDto");
        customerDto.setUrl(url);
        CustomerDao customerDao=new CustomerDaoImpl();
        /*********Hard Code***************/
        customerDao.updateCustomerAvatar(1,url);

        response.getWriter().print("{\"message\":\""+url+"\"}");
    }

}
