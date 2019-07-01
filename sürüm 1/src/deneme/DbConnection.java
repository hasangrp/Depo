package deneme;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DbConnection {
      private Connection con=null;
      private Statement st = null;
      Scanner scanner = new Scanner(System.in);
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
   public Statement getSt(){
       
         try {
             st=con.createStatement();
         } catch (SQLException ex) {
             Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
             
      return st;
   }
   
   
   

    public void listStudent()   {
        
        String sorgu = ("SELECT * from student");
         try {
                 getSt();
                 ResultSet rs=st.executeQuery(sorgu);
               while (rs.next()) {
                  int ogrenci_no = rs.getInt("ogrenci_no");
                  String ad = rs.getString("ad");
                  int not = rs.getInt("not");
             System.out.println("Student No:" +ogrenci_no +"\t\tName:" +ad +"\t\tNot:"+not);   
              }
         } catch (SQLException ex) {
             Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
        
    
public void addStudent(){
    
    
    System.out.println("how many student add:");
    int i = scanner.nextInt();
    for (int a = 0; a < i; a++) {
        
          try {
                          
                System.out.println("Student No:");
                int ogrenci_no = scanner.nextInt();
                System.out.println("Name:");
                String ad = scanner.next();
                System.out.println("not:");
                int not = scanner.nextInt();
                 String sorgu ="INSERT INTO student"+"(ogrenci_no,ad,not)"+ " VALUES("+ogrenci_no +",'"+ ad +"',"+not+"";
                 System.out.println(sorgu);
                getSt();
                 st.executeUpdate(sorgu);
         } catch (SQLException ex) {
              System.out.println("This studnet no already exist...");
         }
        
    }
     
    
}
public void deleteStudent(){
    
    System.out.println("how many student delete:");
    int i = scanner.nextInt();
    for (int a = 0; a < i; a++) {
            try {
             System.out.println("Delete this student No:");
             int ogrenci_no = scanner.nextInt();
             String sorgu ="Delete from student where ogrenci_no="+ogrenci_no;
             System.out.println(sorgu);
             getSt();
             st.executeUpdate(sorgu);
                      
         } catch (SQLException ex) {
             Logger.getLogger(DbConnection.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    
}
public void updateStudent(){
    
    System.out.println("how many student update:");
    int i = scanner.nextInt();
    for (int a = 0; a < i; a++) {
           try {
             getSt();
             System.out.println("Update this student No:");
             int ogrenci_no = scanner.nextInt();
             System.out.println("Student new name:");
             String ad = scanner.next();
             String sorgu ="UPDATE student Set ad='"+ad+"' where ogrenci_no="+ogrenci_no;
             st.executeUpdate(sorgu);
             
         } catch (SQLException ex) {
             System.out.println("wrong student no..");
         }
    }

    
}

}
