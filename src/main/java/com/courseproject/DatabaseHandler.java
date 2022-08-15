package com.courseproject;

import  java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnect()
            throws ClassNotFoundException, SQLException {

        String url = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;

        Class.forName("com.mysql.jdbc.Driver");

        dbConnection = DriverManager.getConnection(url, dbUser, dbPass);

        return dbConnection;
    }

    public Integer getLastUserId() {
        int lastid = 0;
        try {
            Statement st = getDbConnect().createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX("+Const.USERS_ID+") AS id FROM "+Const.TIMES_TABLE);
            rs.next();
            lastid = rs.getInt("id");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return lastid;
    }
    public void signUpUser(String name, String login, String password, String role, int salary, String pos,
                           String moSt, String moFn, String tuSt, String tuFn,
                           String weSt, String weFn, String thSt, String thFn,
                           String frSt, String frFn ) {

        String insert = "INSERT INTO " + Const.USER_TABLE + "(" + Const.USERS_LOGIN
                + ", " + Const.USERS_NAME + ", " + Const.USERS_PASS + ", " +
                Const.USERS_ROLE + ", " + Const.USERS_SALARY + ", " + Const.USERS_POS + ", "  + Const.USERS_BONUS + ")" +
                "VALUES(?,?,?,?,?,?,?)";

        try {
            PreparedStatement prSt = getDbConnect().prepareStatement(insert);
            prSt.setString(1, login);
            prSt.setString(2, name);
            prSt.setString(3, password);
            prSt.setString(4, role);
            prSt.setInt(5, salary);
            prSt.setString(6, pos);
            prSt.setInt(7, 0);

            prSt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Govno");
        int lastiduser = getLastUserId();
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Govno1");

        String insertTime = "INSERT INTO " + Const.TIMES_TABLE + "(" + Const.TIME_ID
                + ", " + Const.TIME_ENTRY + ", " + Const.TIME_MOST + ", " +
                Const.TIME_MOFN + ", " + Const.TIME_TUST + ", " + Const.TIME_TUFN + ", " + Const.TIME_WEST
                + ", " + Const.TIME_WEFN + ", " + Const.TIME_THST + ", " + Const.TIME_THFN + ", " + Const.TIME_FRST + ", " + Const.TIME_FRFN + ")" +
                "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {
            Statement stmt = getDbConnect().createStatement();
            stmt.execute("SET FOREIGN_KEY_CHECKS=0");
            stmt.close();
            System.out.println("Govno3");

            PreparedStatement prSt = getDbConnect().prepareStatement(insertTime);
            prSt.setInt(1, lastiduser);
            prSt.setString(2, formatter.format(date).toString());
            prSt.setString(3, moSt);
            prSt.setString(4, moFn);
            prSt.setString(5, tuSt);
            prSt.setString(6, tuFn);
            prSt.setString(7, weSt);
            prSt.setString(8, weFn);
            prSt.setString(9, thSt);
            prSt.setString(10, thFn);
            prSt.setString(11, frSt);
            prSt.setString(12, frFn);

            prSt.executeUpdate();

            stmt = getDbConnect().createStatement();
            stmt.execute("SET FOREIGN_KEY_CHECKS=1");
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Integer getUserId(User user) {
        ResultSet rerSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_LOGIN + "=? AND " + Const.USERS_PASS + "=?";
        try {
            PreparedStatement prSt = getDbConnect().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            rerSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        int id = 0;
        try {
            while(rerSet.next()){
                id = rerSet.getInt("id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }

    public ResultSet getAllUser() {
        ResultSet res = null;

        String select = "SELECT * FROM " + Const.USER_TABLE;

        try {
            PreparedStatement prSt = getDbConnect().prepareStatement(select);
            res = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return res;
    }

    public ResultSet getUser(User user) {
        ResultSet rerSet = null;

        String select = "SELECT * FROM " + Const.USER_TABLE + " WHERE " +
                Const.USERS_LOGIN + "=? AND " + Const.USERS_PASS + "=?";
        try {
            PreparedStatement prSt = getDbConnect().prepareStatement(select);
            prSt.setString(1, user.getLogin());
            prSt.setString(2, user.getPassword());

            rerSet = prSt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return rerSet;
    }

}
