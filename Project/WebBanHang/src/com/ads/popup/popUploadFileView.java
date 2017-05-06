package com.ads.popup;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.ConnectionPool;
import com.ads.images.ImagesControl;
import com.library.Utilities;
import com.object.ImagesObject;

/**
 * Servlet implementation class popUploadFileView
 */
@WebServlet("/pop/uploadfile/view")
public class popUploadFileView extends HttpServlet {
	private static final String CONTENT_TYPE = "text/html; charset=utf-8";
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "upload/productimg";
 
    // upload settings
    private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB
    /**
     * @see HttpServlet#HttpServlet()
     */
    public popUploadFileView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);
		request.setCharacterEncoding("UTF-8");
		// Tao doi tuong thuc thi xuat cau truc HTML
		PrintWriter out = response.getWriter();
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
        	out.println("Error: Form must has enctype=multipart/form-data.");
        	out.flush();
            return;
        }
 
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk 
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
 
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
 
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
 
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("")
                + File.separator + UPLOAD_DIRECTORY;
 
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
 
        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
 
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = new File(item.getName()).getName();
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);
 
                        // saves the file on disk
                        item.write(storeFile);
                        request.setAttribute("message",UPLOAD_DIRECTORY + "/" + fileName);
                        ServletContext application = getServletConfig().getServletContext();
                		ConnectionPool cp = (ConnectionPool) application.getAttribute("cpool");
                		ImagesControl ic = new ImagesControl(cp);
                		if (cp == null) {
                			application.setAttribute("cpool", ic.getConnectionPool());
                		}
                		ImagesObject io = new ImagesObject();
                		io.setImages_src("/WebBanHang/"+UPLOAD_DIRECTORY + "/" + fileName);
                		io.setImages_name(fileName);
                		boolean result = ic.addImages(io);
                		String url = "/WebBanHang/"+UPLOAD_DIRECTORY + "/" + fileName;
                		ic.releaseConnection();
                		if(result){
                			request.setAttribute("status", true);
                			out.print(Utilities.getMessageRedict("Upload thành công","/WebBanHang/product/ae?product_image_url="+url));
                		}
                    }
                }
            }
        } catch (Exception ex) {
        	out.print(Utilities.getMessageRedict("Upload thất bại","/WebBanHang/product/ae"));
        }
        // redirects client to message page
	}

}
