package deneme;

import java.util.Scanner;


public class Operatin {
  
    
       public static void main(String[] args){ 
    
    DbConnection db =new DbConnection();
    db.connect();
    Scanner scanner = new Scanner(System.in);
    System.out.println("Chose your oparation\n1-List\n2-Add\n3-Delete\n4-Update\n0-exit");
    int chose = scanner.nextInt();       
        
        do {          
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
            } 
             System.out.println("Chose your oparation\n1-List\n2-Add\n3-Delete\n4-Update\n0-exit");
             chose = scanner.nextInt();  
        }
        
            while (chose!=0);
        
    
}
}
