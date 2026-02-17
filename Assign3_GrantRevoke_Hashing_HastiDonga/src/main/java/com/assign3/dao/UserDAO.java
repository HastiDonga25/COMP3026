package com.assign3.dao;

import com.assign3.model.User;
import com.assign3.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    
    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (username, password_hash, mobile, email) VALUES (?, ?, ?, ?)";

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPasswordHash());
            ps.setString(3, user.getMobile());
            ps.setString(4, user.getEmail());

            return ps.executeUpdate() == 1;
        } catch (SQLException e) {
            // Duplicate username etc.
            throw new RuntimeException("Insert failed: " + e.getMessage(), e);
        }
    }

    public List<User> selectUsers() {
        String sql = "SELECT id, username, password_hash, mobile, email FROM users ORDER BY id DESC";
        List<User> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                User u = new User();
                u.setId(rs.getInt("id"));
                u.setUsername(rs.getString("username"));
                u.setPasswordHash(rs.getString("password_hash"));
                u.setMobile(rs.getString("mobile"));
                u.setEmail(rs.getString("email"));
                list.add(u);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException("Select failed: " + e.getMessage(), e);
        }
    }

}
