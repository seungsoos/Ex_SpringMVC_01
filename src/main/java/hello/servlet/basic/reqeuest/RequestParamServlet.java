package hello.servlet.basic.reqeuest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("--- 전체 조회 start ---");
        request.getParameterNames().asIterator()
                .forEachRemaining(pramName -> System.out.println(pramName + " = " + request.getParameter(pramName)));
        System.out.println("--- 전체 조회 end ---");
        System.out.println();

        System.out.println("--- 단일 조회 start ---");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("--- 단일 조회 end ---");
        System.out.println();

        System.out.println("--- 중복 이름 조회 start ---");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("name = " + name);
        }
        System.out.println("--- 중복 이름 조회 end ---");
    }

}
