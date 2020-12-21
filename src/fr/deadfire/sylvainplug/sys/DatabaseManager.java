package fr.deadfire.sylvainplug.sys;

import java.sql.SQLException;

import org.bukkit.Bukkit;

public class DatabaseManager {
    private DbConnection bdd;

    public DatabaseManager() {
    	this.bdd = new DbConnection(new DbCredentials("localhost", 3306, "sylvainplug", "WxpgyXKhHB17VGqs", "sylvainplug"));
    }


    public DbConnection getConnexion() {
        return bdd;
    }

    public void close() {
        try {
            this.bdd.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
