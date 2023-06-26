package controller;

import java.io.IOException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddEmployeeServletM
 */
@WebServlet("/AddEmployeeServletM")
@MultipartConfig
public class AddCsvEmployeeServlet extends HttpServlet {
	protected static final String UPLOAD_PATH = "C:\\Users\\kanat\\Documents\\eclipse_workspace\\WebProject\\src\\main\\webapp\\upload\\";
	private static final long serialVersionUID = 1L;
    private static final ZoneId HERE = ZoneId.of("Asia/Tokyo");

    private static final DateTimeFormatter PATTERN = DateTimeFormatter.ofPattern("uuuu-MM-dd-HH-mm-ss-SSS");

    private static final String FILE = "file1";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCsvEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
 		response.setContentType("text/html; charset=UTF-8");
 		
		ZonedDateTime now = ZonedDateTime.now(HERE);
        String fileName = now.format(PATTERN);
        Part file = request.getPart(FILE);
        String uploadFileName = String.valueOf(file.getSubmittedFileName());
        int filenameLen = uploadFileName.length();
        String extension = Optional.of(file.getSubmittedFileName())
                .filter(s -> s.length() > 0)
                .filter(s -> s.contains("."))
                .map(s -> s.substring(s.lastIndexOf(".")))
                .orElse("");
        String filePath = UPLOAD_PATH +  fileName + uploadFileName;
        file.write(filePath);
        
	}

}
