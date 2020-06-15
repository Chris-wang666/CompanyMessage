/*此项目使用了Mybatis框架实现MVC模式访问数据，使用了jstl显示查询结果。*/
package cn.edu.ccut.Controller;

import cn.edu.ccut.Mapper.CIMapper;
import cn.edu.ccut.PO.Company;
import cn.edu.ccut.util.InitialSqlSession;
import org.apache.ibatis.session.SqlSession;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CIServlet", value = "/ciservlet")
public class CI_Servlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        /*解决中文乱码*/
        request.setCharacterEncoding("utf-8");
        SqlSession sqlSession = InitialSqlSession.getSqlSession();
        CIMapper mapper = sqlSession.getMapper(CIMapper.class);
        String flag = request.getParameter("flag");
        if("1".equals(flag)){//增
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            Company c = new Company();
            c.setName(name);
            c.setAddress(address);
            c.setPhone(phone);
            int count = mapper.insertCompany(c);
            if(count > 0){
                response.sendRedirect("success.jsp");
            }else{
                response.sendRedirect("failure.jsp");
            }
            sqlSession.commit();
            sqlSession.close();
        }else if("2".equals(flag)){//删
            int id = Integer.parseInt(request.getParameter("id"));
            int count = mapper.deleteById(id);
            if(count > 0){
                response.sendRedirect("success.jsp");
            }else{
                response.sendRedirect("failure.jsp");
            }
            sqlSession.commit();
            sqlSession.close();
        }else if("3".equals(flag)){//改
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String address = request.getParameter("address");
            String phone = request.getParameter("phone");
            Company c = new Company();
            c.setId(id);
            c.setName(name);
            c.setAddress(address);
            c.setPhone(phone);
            int count = mapper.updateLoginById(c);
            if(count > 0){
                response.sendRedirect("success.jsp");
            }else{
                response.sendRedirect("failure.jsp");
            }
            sqlSession.commit();
            sqlSession.close();
        }else if("4".equals(flag)){//查
            List<Company> li = mapper.selectAllCompany();
            HttpSession session = request.getSession(false);
            if (session == null) {
                session = request.getSession(true);
            }
            session.setAttribute("list",li);
            response.sendRedirect("result.jsp");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        this.doPost(request,response);
    }
}
