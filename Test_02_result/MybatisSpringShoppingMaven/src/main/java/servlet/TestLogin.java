package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestLogin extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // 获取用户输入
        String head = request.getParameter("head");
        String pass = request.getParameter("pass");

        // 调用业务方法进行验证
       boolean flag = head.equals("zhangsan") && pass.equals("123456");

        // 要转向的文件
        String forward;

// 如果验证成功，转向success.jsp，否则转向failure.jsp
        if(flag)
        {
//
//            forward = "goodslist.jsp";
            response.sendRedirect("getAllGoods");
        }
        else
        {

//            forward = "login.jsp";
            response.sendRedirect("login.jsp");
        }
//
//        // 获取Dispatcher对象
//        RequestDispatcher dispatcher = request.getRequestDispatcher(forward);
//
//        // 完成跳转
//        dispatcher.forward(request,response);

    }
    public void doPost(HttpServletRequest request,HttpServletResponse response)
            throws IOException,ServletException{
        doGet(request,response);
    }
}
