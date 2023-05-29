package controller;

import model.Department;
import model.Staff;
import service.DepartmentService;
import service.StaffService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/staff")
public class StaffServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StaffService staffService;

    public void init() {
        staffService = new StaffService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        try {
            switch (action) {
                case "create":
                   showCreateForm(request,response);
                    break;
                case "edit":
                    showEditForm(request,response);
                    break;
                case "delete":
                    delete(request,response);
                    break;
                default:
                    listUser(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insert(request, response);
                    break;
                case "edit":
                    update(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Staff> staffList = staffService.selectAll();
        request.setAttribute("staff", staffList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
        dispatcher.forward(request, response);
    }


    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);
    }

    private void insert(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("staff_name");
        String email = request.getParameter("staff_email");
        String address = request.getParameter("staff_address");
        String phoneNumber = request.getParameter("phone_number");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String departmentId = request.getParameter("department_id");
        Staff staff = new Staff(name, email, address, phoneNumber, salary, departmentId);
        staffService.insertStaff(staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("create.jsp");
        dispatcher.forward(request, response);


    }

    private void update(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("staff_name");
        String email = request.getParameter("staff_email");
        String address = request.getParameter("staff_address");
        String phoneNumber = request.getParameter("phone_number");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String departmentId = request.getParameter("department_id");

        Staff staff = new Staff(name, email, address, phoneNumber, salary, departmentId);
        staffService.update(staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("edit.jsp");
        dispatcher.forward(request, response);
    }


    private void delete(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        staffService.deleteStaff(id);
        List<Staff> staff = staffService.selectAll();
        request.setAttribute("staff", staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffService.selectById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("user/edit.jsp");
        request.setAttribute("staff", staff);
        dispatcher.forward(request, response);

    }


}
