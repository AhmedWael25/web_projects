package com.playground;

import jakarta.jws.WebService;
import jakarta.servlet.*;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name="UploadServlet", urlPatterns = {"/fileUpload"})
@MultipartConfig
public class UploadServlet extends HttpServlet{
	

	public void init(ServletConfig config) throws ServletException {
		
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
            
//            String path = request.getParameter("destination");
            String path = "C:\\webdev\\web_projects\\Servlets&JSP\\uploadedFiles\\";
            Part filePart = request.getPart("fileName");
            String fileName = getFileName(filePart);
            PrintWriter out = response.getWriter();
            
            
            try {
                filePart.write(path+fileName); 
                out.println("New file " + fileName + " created at " + path);
            } catch (FileNotFoundException fne) {
                out.println("Error While Uploading Your File");
            }

	}
	private String getFileName(final Part part) {
            for (String content : part.getHeader("content-disposition").split(";")) {
                if (content.trim().startsWith("filename")) {
                    return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
                }
            }
            return null;
        }

}


/*



            
            String savedFiles = "C:\\webdev\\web_projects\\Servlets&JSP\\uploadedFiles";
            
            String fileName  = "";
            
            ServletInputStream sis = req.getInputStream();
            byte[] line = new byte[128];
            int i = sis.readLine(line, 0, 128);
            int boundaryLength = i -2;
            
            String boundary = new String(line, 0, boundaryLength);
            
            
            while(i != 1){
                
                String newLine = new String(line, 0, i);
                if(newLine.startsWith("Content-Disposition: form-data; name=\"")){
                    
                    String str = new String(line, 0, i-2);
                    int pos = str.indexOf("filename=\"");
                    if(pos != -1){
                        String filePath =   str.substring(pos+10, str.length()-1);
                        pos = filePath.lastIndexOf("\\");
                        
                        if (pos != -1)
                            fileName = filePath.substring(pos + 1);
                        else
                            fileName = filePath;
                    }
                    
                    
                    i = sis.readLine(line, 0, 128);
                    i = sis.readLine(line, 0, 128);
                    
                    i = sis.readLine(line, 0, 128);
                     
                    
                    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                    newLine = new String(line, 0, i);
                    
                    while(i != -1 && !newLine.startsWith(boundary)){
                        buffer.write(line, 0, i);
                        i = sis.readLine(line, 0, 128);
                        newLine = new String(line, 0, i);
                        
                        try{
                             
                            RandomAccessFile f = new RandomAccessFile(savedFiles + fileName, "rw");
                            byte[] bytes = buffer.toByteArray();
                            f.write(bytes, 0, bytes.length -2 );
                            f.close();
                            
                        }catch(Exception e){
                          
                        }
                        i = sis.readLine(line,0,128);
                        
                    }
                    
                    
                }
            }
            
            

*/
	