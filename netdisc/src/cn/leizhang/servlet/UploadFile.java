package cn.leizhang.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import cn.leizhang.domain.FileInfo;
import cn.leizhang.service.FileService;


public class UploadFile extends HttpServlet {


	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		DiskFileItemFactory factory=new DiskFileItemFactory();
		ServletFileUpload upload=new ServletFileUpload(factory);
		List<FileItem> items =null;
		FileInfo fi=new FileInfo();
		try {
			items=upload.parseRequest(request);
			for(FileItem item:items)
			{
					try {
						InputStream is=item.getInputStream();

						if(!item.isFormField())
						{
						String fname=item.getName();
						String fname2=fname.substring(fname.lastIndexOf("/")+1);
						fi.setFilename(fname2);
						fi.setRealpath("/upload/"+fname2);
						//System.out.println(fname2);
						OutputStream os=new FileOutputStream(request.getSession().getServletContext().getRealPath("/")+"/upload/"+fname2);
						byte [] b=new byte[1024];
						int len=-1;
						while((len=is.read(b))!=-1)
						{
							os.write(b,0,len);
							
						}
						os.close();
						is.close();
						}
						else
						{	
							
							fi.setDescription(item.getString());
													
						}
						
						
						//request.getRequestDispatcher("/success.jsp").forward(request, response);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					
				}
				System.out.println(fi.getFilename());
			FileService fs=new FileService();
			try {
				fs.Save(fi);
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
			
		} catch (FileUploadException e)
		{
			e.printStackTrace();
		}
		
		
			
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request,response);
		
	}

}
