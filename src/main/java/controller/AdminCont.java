package controller;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import Dao.AdminDao;
import Model.AdminModel;
import Model.standard;
import Model.student;

/**
 * Servlet implementation class AdminCont
 */
@WebServlet("/AdminCont")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 512, maxFileSize = 1024 * 1024 * 512, maxRequestSize = 1024 * 1024* 512)

public class AdminCont extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public AdminCont() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	private String extractfilename(Part file) {
		String cd = file.getHeader("content-disposition");
		System.out.println(cd);
		String[] items = cd.split(";");
		for (String string : items) {
			if (string.trim().startsWith("filename")) {
				return string.substring(string.indexOf("=") + 2, string.length() - 1);
			}
		}
		return "";
	}
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String action = request.getParameter("action");
		System.out.println(action);

		if (action.equalsIgnoreCase("adminSignIn")) {
			AdminModel a = new AdminModel();
			a.setEmail(request.getParameter("email"));
			a.setPassword(request.getParameter("password"));
			String email = request.getParameter("email");
			boolean flag = AdminDao.checkEmail(email);
			
			if(flag == true)
			{
				AdminModel a1 = AdminDao.adminSignIn(a);
				if(a1 == null)
				{
					request.setAttribute("msg", "Wrong Password!!");
					request.getRequestDispatcher("login.jsp").forward(request, response);
					
				}
				else
				{
					HttpSession session  = request.getSession();
					session.setAttribute("adminData", a1);
					request.getRequestDispatcher("home.jsp").forward(request, response);
					
				}
			}
			else
			{
				request.setAttribute("msg1", "Email is not registered !!");
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
		}
		else if(action.equalsIgnoreCase("addstandard"))
		{
			standard s = new standard();
			s.setName(request.getParameter("name"));
			s.setStatus(request.getParameter("status"));
			
			AdminDao.addstandard(s);
			response.sendRedirect("standardlist.jsp");
		}
		
		else if(action.equalsIgnoreCase("register"))
		{
			student s1 = new student();
			
			 String savePath = "D:\\JAVA P\\StudentRegciright\\src\\main\\webapp\\image";
			 File fileSaveDir = new File(savePath);
			  
			  if(!fileSaveDir.exists()) { fileSaveDir.mkdir(); }
			  
			  Part file1 = request.getPart("img");
			  
			  String fileName = extractfilename(file1); file1.write(savePath +
			  File.separator + fileName); String filePath = savePath + File.separator +
			  fileName;
			  
			  String savePath2 = "D:\\JAVA P\\StudentRegciright\\src\\main\\webapp\\image";
			  File imgSaveDir = new File(savePath2);
			  
			  if(!imgSaveDir.exists()) { imgSaveDir.mkdir(); }
			 
			
			
			s1.setFname(request.getParameter("fname"));
			s1.setLname(request.getParameter("lname"));
			
			int sid = Integer.parseInt(request.getParameter("standard"));
			String sname = AdminDao.getStandardById(sid);
			s1.setStandard(sname);
			s1.setDob(request.getParameter("dob"));
			
			 s1.setImg(fileName); 
			 String date = LocalDate.now().toString();
			 System.out.println(date); 
			 s1.setCd(date); 
			 
			 String status = AdminDao.getStandardStatusById(sid); 
			 s1.setStatus(status);
			 
			AdminDao.regStudent(s1);
			response.sendRedirect("index.jsp");
		}
	}

	
}
