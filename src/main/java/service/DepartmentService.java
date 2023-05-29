package service;

import model.Department;
import model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static service.StaffService.getConnection;

public class DepartmentService {
    private static String SQL_SELECT_ADDRESS_BY_ID = "SELECT * FROM department WHERE department_id = ?";

    private static final String DELETE_DEPARTMENT_SQL = "delete from department where department_id = ?";

    private static final String UPDATE_DEPARTMENT_SQL = "update users set department_name = ? where department_id  = ?";
    public DepartmentService() {
    }


    public boolean deleteDepartment(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_DEPARTMENT_SQL)) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }
    public static Department getDepartment(int id) {
        Connection connection = getConnection();
        Department department;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_ADDRESS_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
           int department_id = Integer.parseInt("");
            String department_name  = "";

            while (resultSet.next()) {
               department_id = resultSet.getInt("department_id");
               department_name = resultSet.getString("department_name");
            }

            department = new Department(department_id,department_name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return department;
    }


    public boolean updateUser(Department department) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_DEPARTMENT_SQL)) {
            statement.setString(1, department.getDepartment_name());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

}
