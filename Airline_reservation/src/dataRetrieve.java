import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

public class dataRetrieve {
    private ConnectionManager objDBconnection=new ConnectionManager("DESKTOP-1H426SL\\SQLEXPRESS","CITdb","hiba","786711");
    PreparedStatement p=null;
    
    
   public Responce getPassengers(){
       Responce res = new Responce();
       ResultSet ru=null;
       try{
            Connection  con = objDBconnection.getConnection();
             Statement stmt = con.createStatement();
             Passengers pass= new Passengers();
            
            String name="SELECT * FROM Passenger";
            boolean isPassengersRetrieved =stmt.execute(name);
            ru=stmt.executeQuery(name);
             
            if(ru.next()){
                pass.name= ru.getString("Name");
                pass.gender=ru.getString("Gender");
                pass.email=ru.getString("Email");
                pass.id=ru.getInt("id");
                pass.age=ru.getInt("Age");
                pass.address=ru.getString("Address");
                pass.contact=ru.getInt("Contact Number");
            }
            
             
            if(isPassengersRetrieved)
            {
              res.addInformationMessage("Record retrieved successfully.");
            }
            else
            {
                res.addInformationMessage("Failed to retrieve pass info from database.");
            }
            con.close();
           
       }catch (SQLException e) {
            e.printStackTrace();
            res.AddErrorMessage("Failed to retrieve pass info due to: "+e.getMessage());
        }
       return res;
   }
   
   public ArrayList<Passengers> getAllPassengers(){
       Responce res = new Responce();
       ResultSet ru=null;
       ArrayList<Passengers> passenger_array= new ArrayList<Passengers>();
       try{
            Connection  con = objDBconnection.getConnection();
             Statement stmt = con.createStatement();
             
             String db="SELECT * FROM Passenger";
             ru=stmt.executeQuery(db);
             
             //Retrieveing all 
             int j=0;
            while (ru.next()) {
            Passengers pass = new Passengers();
            pass.name= ru.getString("Name");
                pass.gender=ru.getString("Gender");
                pass.email=ru.getString("Email");
                pass.id=ru.getInt("id");
                pass.age=ru.getInt("Age");
                pass.address=ru.getString("Address");
                pass.contact=ru.getInt("Contact Number");
            j++;
            }
            }catch (SQLException e) {
            e.printStackTrace();
            res.AddErrorMessage("Failed to retrieve Passengers info due to: "+e.getMessage());
        }
       return passenger_array;
    }

    public Responce findPassengers(Passengers passenger) {
       Responce res = new Responce();
       ResultSet ru=null;
       try{
            Connection  con = objDBconnection.getConnection();
             Statement stmt = con.createStatement();
             boolean isPassengersdbRetrieved=false;
             
             ArrayList<Passengers> passenger_array= getAllPassengers();
            int i;
            for(i=0; i<passenger_array.size();i++){
                int id=passenger_array.get(i).id;
                int psid=passenger.id;
                if(id== psid){
                        isPassengersdbRetrieved=true;
                        break;
                    }
                    else{
                         res.AddErrorMessage("Wrong id Entered");
                         return res;
                    }    
                }
            
            
            if(isPassengersdbRetrieved){
                passenger.name= ru.getString("Name");
                passenger.gender=ru.getString("Gender");
                passenger.email=ru.getString("Email");
                passenger.id=ru.getInt("id");
                passenger.age=ru.getInt("Age");
                passenger.address=ru.getString("Address");
                passenger.contact=ru.getInt("Contact Number");
            }
            else{
                res.AddErrorMessage("Given id doesnt Exist");
            }
             
             }catch (SQLException e) {
            e.printStackTrace();
            res.AddErrorMessage("Failed to retrieve Passengers info due to: "+e.getMessage());
        }
       return res;
    }

}
