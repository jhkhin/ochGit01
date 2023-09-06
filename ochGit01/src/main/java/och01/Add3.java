package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doGet 여기 왔네");
		// Parameter 받기 request는 add.html에서 (num, loc)받고 response는 실행후 화면으로 뿌려주는것 
		int num =Integer.parseInt(request.getParameter("num")) ;	// 숫자형을 바꿔줌
		String loc = request.getParameter("loc");
		// 실행결과 : Console 창에 나옴
		System.out.println("num->" + num);
		System.out.println("loc->" + loc);
		
		// 목표 : 1부터 num까지의 값의 누적
		int sum =0;
		for(int i=1; i<=num; i++) {
			sum +=i;
		}
		System.out.println("sum -> " + sum);
		
		// 브라우저 인코딩 적용, get방식은 request 인코딩방식 생략 가능
		//request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 공식 -> 사용자 브라우저에 보여주는 객체
		// out : 브라우저에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.printf("<h1>1부터 %d까지 get 합계</h1>", num);
		out.printf("<h4>LOC->%s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("doPost 여기 왔네");
		// 인코딩 시기 : request 파라메터 받기 전에 실행 -> 글자 깨지는거 방지
		request.setCharacterEncoding("utf-8");	
		// Parameter 받기 request는 add.html에서 (num, loc)받고 response는 실행후 화면으로 뿌려주는것 
				int num =Integer.parseInt(request.getParameter("num")) ;	// 숫자형을 바꿔줌
				String loc = request.getParameter("loc");
				
				// 실행결과 : Console 창에 나옴
				System.out.println("num->" + num);
				System.out.println("loc->" + loc);
				
				// 목표 : 1부터 num까지의 값의 누적
				int sum =0;
				for(int i=1; i<=num; i++) {
					sum +=i;
				}
				System.out.println("sum -> " + sum);
				
				// 인코딩 시기 -> response 객체를 사용전에 인코딩을 적용해야함
				response.setContentType("text/html;charset=utf-8");
				
				// 공식 -> 사용자 브라우저에 보여주는 객체
				// out : 브라우저에 보여주는 객체
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.printf("<h1>1부터 %d까지 Post 합계</h1>", num);
				out.printf("<h4>LOC->%s</h4>", loc);
				out.println(sum);
				out.println("</body></html>");
				out.close();
			
	}

}
