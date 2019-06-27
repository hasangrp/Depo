
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbConnection {
     private Connection con;
      private Statement st = null;

public void connect() {
   
   try{
          Class.forName("org.sqlite.JDBC");
          String url =("jdbc:sqlite:db0.db");
          con=DriverManager.getConnection(url);
          System.out.println("başarılı");
}
   catch(Exception e){ 
       System.out.println("bağlatı başarısız..");
   }
  
}
    
    /*public Statement getconnection(){
    Class.forName("org.sqllite")
   String url =("jdbc:sqlite:db0.db");
   Connection con = DrvierManager.getConnection(url);
    
    
    
}*/
    
    
public void listStudent()   {
        
        String sorgu = ("SELECT * from student");
         try {
                 st=con.createStatement();
                 ResultSet rs=st.executeQuery(sorgu);
               while (rs.next()) {
                  int ogrenci_no = rs.getInt("ogrenci_no");
                  String ad = rs.getString("ad");
              
                 System.out.println("Student No:" +ogrenci_no +"\tName:" +ad);   
              }
         } catch (SQLException ex) {
             Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
        
    
public void addStudent(){
  
         try {
                Scanner scanner = new Scanner(System.in);
                Scanner scan = new Scanner(System.in);           
                System.out.println("Student No:");
                int ogrenci_no = scanner.nextInt();
                System.out.println("Name:");
                String ad = scan.nextLine();
                 String sorgu ="INSERT INTO student"+"(ogrenci_no,ad)"+ " VALUES("+ogrenci_no +",'"+ ad +"')";
                 System.out.println(sorgu);
                 st=con.createStatement();
                 st.executeUpdate(sorgu);
         } catch (SQLException ex) {
             Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
    
}
public void deleteStudent(){
    
         try {
             st=con.createStatement();
             Scanner scanner = new Scanner(System.in);
             System.out.println("Delete this student No:");
             int ogrenci_no = scanner.nextInt();
             String sorgu ="Delete from student where ogrenci_no="+ogrenci_no;
             st.executeUpdate(sorgu);
         } catch (SQLException ex) {
             Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
    
    
}
public void updateStudent(){
    
         try {
             st=con.createStatement();
             Scanner scanner = new Scanner(System.in);
             Scanner scan = new Scanner(System.in);
             System.out.println("Update this student No:");
             int ogranci_no = scanner.nextInt();
             System.out.println("Student new name:");
             String ad = scan.nextLine();
             String sorgu ="UPDATE student Set ad='"+ad+"' where ogrenci_no="+ogranci_no;
             st.executeUpdate(sorgu);
             
         } catch (SQLException ex) {
             Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
    
}

public static void main(String[] args){ 
    
    DbConnection db =new DbConnection();
    db.connect();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Chose your oparation\n1-List\n2-Add\n3-Delete\n4-Update\n5-exit");
    int chose = scanner.nextInt();
    switch(chose){
        case 1:
            db.listStudent();
            break;
        case 2:
            db.addStudent();
            break;
        case 3:
            db.deleteStudent();
            break;
        case 4:
            db.updateStudent();
            break;
        case 5:
            break;
        
    }
}


}
