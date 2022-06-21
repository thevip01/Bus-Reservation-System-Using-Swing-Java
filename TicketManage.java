/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bus.reservation.system;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author thevi
 */
public class TicketManage
{
    public Connection conn;

    public TicketManage(){
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/Demo_Bus","root","");
        }
        catch(Exception e)
        {
            System.out.print(e);
        }
    
    }
    public boolean addTicket()
    {
        try{
            String sql = "INSERT INTO booked_seat SELECT SeatNo,BusNo,Date,SeatTag FROM temp_detail";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            String sql2 = "DELETE FROM `temp_detail`;";//SeatNo(Varchar)(uniq),BusNo(Varchar),Date (Varchar), DateTag(Varchar)   
            PreparedStatement stm2 = conn.prepareStatement(sql2);
            stm2.executeUpdate();
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
}