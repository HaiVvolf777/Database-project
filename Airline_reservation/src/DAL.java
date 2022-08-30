import java.sql.Connection;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class DAL {
    private ConnectionManager objDBconnection=new ConnectionManager("DESKTOP-1H426SL\\SQLEXPRESS","Airline reservation","xylone","777777");
   
    

    public Responce addPayment(Payments pay) {
        Responce objResponce=new Responce();
        try
        {
            Connection objconnection=objDBconnection.getConnection();
            //For insertion of statement in the table
            Statement stmnt=objconnection.createStatement();
            
            String SQLInsertQuery="insert into Payment(Passenger ID,Payment Method,Condition) "
                    +"Values('"+pay.id+"','"+pay.method+"','"+pay.condition+"')";
                    int recordInserted =stmnt.executeUpdate(SQLInsertQuery);
                    //create a responce
                    
                    
        }catch(Exception e){
        e.printStackTrace();
        objResponce.AddErrorMessage("Faild to add information due to:"+e.getMessage());
        
       
        }
    return objResponce;
    }

   
}
