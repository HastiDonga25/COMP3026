package com.va.assign1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class RegisterDao {

    // ✅ Windows Authentication connection string (NO username/password)
	private static final String JDBC_URL =
			  "jdbc:sqlserver://localhost:1433;databaseName=Assign1DB;encrypt=true;trustServerCertificate=true;user=assign1_user;password=Assign1@12345;";


    // ✅ Helper: get connection
    private Connection getConnection() throws Exception {
    	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        return DriverManager.getConnection(JDBC_URL);
    }

    // ✅ DB Validation: Check if User ID already exists
    public boolean userIdExists(String userId) throws Exception {
        String sql = "SELECT 1 FROM Register WHERE userid = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    // ✅ DB Validation: Check if Email already exists
    public boolean emailExists(String email) throws Exception {
        String sql = "SELECT 1 FROM Register WHERE email = ?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, email);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }

    // ✅ Insert user using PreparedStatement (SQL Injection Safe)
    public int registerUser(RegisterForm reg) throws Exception {
        String sql = "INSERT INTO Register " +
                     "(userid, password, name, address, country, zip, email, gender) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, reg.getUserId());
            ps.setString(2, reg.getPassword());
            ps.setString(3, reg.getName());
            ps.setString(4, reg.getAddress());
            ps.setString(5, reg.getCountry());
            ps.setString(6, reg.getZipCode());
            ps.setString(7, reg.getEmail());
            ps.setString(8, reg.getSex());

            return ps.executeUpdate(); // returns 1 if inserted
        }
    }
}
