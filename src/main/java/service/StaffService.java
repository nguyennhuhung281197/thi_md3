package service;

import model.Department;
import model.Staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffService {

    private static String jdbcURl = "jdbc:mysql://localhost:3306/thi_md3";
    private static String jdbcUserName = "root";
    private static String jdbcPassword = "C0223g1@";

    private static final String INSERT_STAFF = "INSERT INTO staff_id, staff_name, staff_email, staff_address, phone_number, salary, department_id) VALUES (?, ?, ?, ?, ? ,?, ?)";
    private static final String SELECT_ALL = "select * from staff";
    private static final String DELETE_STAFF_SQL = "delete from staff where staff_id = ?";
    private static final String SELECT_BY_ID = "select staff_name,staff_email,staff_address,phone_number,salary,department_id from users where staff_id = ?";
    private static final String UPDATE_STAFF_SQL = "update users set staff_name = ?,staff_email = ?,staff_address = ?,phone_number = ? ,salary = ?,department_id = ? where staff_id = ?";

    private static final String SELECT_USER_BY_COUNTRY = "SELECT * FROM users WHERE country = ?";
    public StaffService() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURl, jdbcUserName, jdbcPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertStaff(Staff staff) {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(INSERT_STAFF)) {
            statement.setInt(1, staff.getStaffId());
            statement.setString(2, staff.getStaffName());
            statement.setString(3, staff.getStaffEmail());
            statement.setString(4, staff.getStaffAddress());
            statement.setString(5, staff.getPhoneNumber());
            statement.setDouble(6, staff.getSalary());
            statement.setString(7, staff.getDepartment());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Staff selectById(int id) {
        Staff staff = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String staffName = rs.getString("staff_name");
                String staffEmail = rs.getString("staff_email");
                String staffAddress = rs.getString("staff_address");
                String phoneNumber = rs.getString("phone_number");
                double salary = rs.getDouble("salary");
                String departmentId = rs.getString("department_id");

                staff = new Staff(id,staffName,staffEmail,staffAddress,phoneNumber,salary,departmentId);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staff;
    }

    public List<Staff> selectAll() {

        List<Staff> staffList = new ArrayList<>();

        try (Connection connection = getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL)) {
            System.out.println(preparedStatement);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                int staffId = rs.getInt("staff_id");
                String staffName = rs.getString("staff_name");
                String staffEmail = rs.getString("staff_email");
                String staffAddress = rs.getString("staff_address");
                String phoneNumber = rs.getString("phone_number");
                double salary = rs.getDouble("salary");
                String departmentId = rs.getString("department_id");

                staffList.add(new Staff(staffId,staffName,staffEmail,staffAddress,phoneNumber,salary,departmentId));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staffList;
    }

    public boolean deleteStaff(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_STAFF_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean update(Staff staff) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_STAFF_SQL);) {
            statement.setString(1, staff.getStaffName());
            statement.setString(2, staff.getStaffEmail());
            statement.setString(3, staff.getStaffAddress());
            statement.setString(4,staff.getPhoneNumber());
            statement.setDouble(5,staff.getSalary());
            statement.setString(6,staff.getDepartment());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
