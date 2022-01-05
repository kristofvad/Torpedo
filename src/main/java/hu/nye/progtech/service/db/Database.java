package hu.nye.progtech.service.db;

import static hu.nye.progtech.game.Game.player2Name;
import static hu.nye.progtech.game.Game.playerName;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.springframework.stereotype.Service;

/**
 * Create database for game.
 */
@Service
public class Database {

    /**
     * Record the wins of player into database.
     */
    public static void playerWin() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/battleship", "root", "");

            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO player(Name,Win,Lose)" + "VALUES (?, ?, ?)");
            preparedStmt.setString(1, playerName);
            preparedStmt.setInt(2, 1);
            preparedStmt.setInt(3, 0);
            preparedStmt.executeUpdate();
            } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Record the wins of player2 into database.
     */

    public static void player2Win() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/battleship", "root", "");

            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO player(Name,Win,Lose)" + "VALUES (?, ?, ?)");
            preparedStmt.setString(1, player2Name);
            preparedStmt.setInt(2, 1);
            preparedStmt.setInt(3, 0);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Record the losses of the player into database.
     */

    public static void playerLose() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/battleship", "root", "");

            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO player(Name,Win,Lose)" + "VALUES (?, ?, ?)");
            preparedStmt.setString(1, playerName);
            preparedStmt.setInt(2, 0);
            preparedStmt.setInt(3, 1);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Record the losses of the player into database.
     */

    public static void player2Lose() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/battleship", "root", "");

            PreparedStatement preparedStmt = con.prepareStatement("INSERT INTO player(Name,Win,Lose)" + "VALUES (?, ?, ?)");
            preparedStmt.setString(1, player2Name);
            preparedStmt.setInt(2, 0);
            preparedStmt.setInt(3, 1);
            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * Record the highscore of the player into database.
     */

    public static void highscore() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost/battleship", "root", "");
            String highscore = "SELECT *" +
                    "FROM player";
            PreparedStatement preparedStmt = con.prepareStatement(highscore);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getString(1));
                System.out.print(": ");
                System.out.print(rs.getInt(2));
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
