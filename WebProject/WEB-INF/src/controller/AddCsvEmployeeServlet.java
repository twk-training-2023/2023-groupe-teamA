package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.EmployeeBean;
import model.EmployeeDAO;
import model.EmployeeDTO;
import model.LoginInfo;

/**
 * Servlet implementation class AddEmployeeServletM
 */
@WebServlet("/AddCsvEmployeeServlet")
@MultipartConfig
public class AddCsvEmployeeServlet extends HttpServlet {
	protected static final String UPLOAD_PATH = "\\src\\main\\webapp\\data\\";
	private static final long serialVersionUID = 1L;
    private static final ZoneId HERE = ZoneId.of("Asia/Tokyo");

    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH-mm-ss-SSS");

    private static final String FILE = "csvFile";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCsvEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html; charset=UTF-8");
 		
		HttpSession session = request.getSession();
		LoginInfo loginInfo = (LoginInfo) session.getAttribute("loginInfo");
		String url = "";
		if (loginInfo == null) {
			request.setAttribute("errorMsg", "セッションが切れました。再ログインをしてください。");
			url = "view/login.jsp";
		} else {
 		
	 		String projectPath = getServletContext().getRealPath("/");
			ZonedDateTime now = ZonedDateTime.now(HERE);
	        String fileName = now.format(PATTERN);
	        Part file = request.getPart(FILE);
	        String uploadFileName = String.valueOf(file.getSubmittedFileName());
	        String extension = Optional.of(file.getSubmittedFileName())
	                .filter(s -> s.length() > 0)
	                .filter(s -> s.contains("."))
	                .map(s -> s.substring(s.lastIndexOf(".")))
	                .orElse("");
	        if (extension.equals(".csv")) {
	        	String filePath = projectPath + UPLOAD_PATH +  fileName + uploadFileName;
	            file.write(filePath);
	            EmployeeDTO edto = new EmployeeDTO();
	            BufferedReader br = null;
	            try {
	            	FileInputStream fis = new FileInputStream(filePath);
	            	InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
	            	br = new BufferedReader(isr);
	            	String line;
	            	while((line=br.readLine()) != null) {
	            		if (line.startsWith("メールアドレス")) {
	            			continue;
	            		}
	            		
	            		String[] data = line.split(",", -1);
	            		EmployeeBean eb = new EmployeeBean();
	            		eb.setMailaddress(data[0]);
	            		eb.setPassword(data[1]);
	            		eb.setName(data[2]);
	            		eb.setPermissionLevel(Integer.valueOf(data[3]));
	            		edto.add(eb);
	            	}
	            }catch (Exception e) {
					e.printStackTrace();
				}finally {
					if (br != null) {
						try {
							br.close();
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
	            EmployeeDAO edao = new EmployeeDAO();
	            try {
					boolean result = edao.insertEmployee(edto, loginInfo);
					if (result) {
						request.setAttribute("successMsg", "社員を" + edto.size() + "人を追加しました。");
						url = "view/addEmployee.jsp";
					}else {
						request.setAttribute("errorMsg", "追加に失敗しました。");
						url = "view/addEmployee.jsp";
					}
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
	        }else {
	        	//CSV以外のファイルの場合
				request.setAttribute("errorMsg", "CSVファイルを送信してください。");
				url = "view/addEmployee.jsp";
	        }
		}
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}
	
}
