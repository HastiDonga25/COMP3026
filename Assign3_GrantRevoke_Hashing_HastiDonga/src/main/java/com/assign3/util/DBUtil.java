package com.assign3.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	private static final String URL =
			 "jdbc:mysql://localhost:3306/assign3_security?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
    private static final String USER = "comp3026_w2026_HastiDonga";
    private static final String PASS = "StrongPass@123";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception e) {
            throw new RuntimeException("DB connection failed: " + e.getMessage(), e);
        }
    }
}
