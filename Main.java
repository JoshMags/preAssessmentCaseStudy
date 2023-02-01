
import java.time.Year;
import java.util.*;


public class Main {

   static ArrayList<Record> listOfRec = new ArrayList<>();
   static Record rec = new Record();

   static ArrayList<Employee> emp = new ArrayList<>();
   static Employee empData = new Employee();

   static ArrayList<Availabilty> assignItems = new ArrayList<>();
   static Availabilty avail = new Availabilty();
   
    public static void main (String []args){
       Scanner in = new Scanner(System.in);
       boolean menu = true;

        while(menu == true ){
            try{
            System.out.print("\n1. All record \n2. View Record \n3. Edit Record \n4. " +
                                "Delete Record \n5.Report \n6. Exit \nEnter: ");
            int choose = in.nextInt();
            String press = in.nextLine();
            
                switch(choose) {
                    
                    
                    case 1: 
                            System.out.print("\na. Add peripheral \nb. Add employee \nc. Assign peripheral to employee \nEnter: "); 
                                press = in.nextLine();
                                switch(press){

                                    case "a": 
                                             System.out.print("\n1. input device \n2. output device" + 
                                                             "\n3. input/output device: \nEnter: ");
                                                int enter = in.nextInt();
                                                
                                                Year curYear = Year.now();
                                               String empCode = curYear + "-" + genHarCode();
                                               if(enter == 1){
                                                System.out.print("Enter Device Name: ");
                                                press = in.next();
                                                
                                                listOfRec.add(new Record(press,1,empCode));
                                    
                                               }else if (enter == 2){
                                                System.out.print("Enter Device: ");
                                                press = in.next();    
                                                listOfRec.add(new Record((press),2,(empCode)));
                                               }else{
                                                System.out.print("Enter Device: ");
                                                press = in.next();
                                                listOfRec.add(new Record((press),3,(empCode)));
                                               }

                                               
                                              


                                            System.out.print("-----Peripheral added successfully-----\n" +press+" : "+ empCode);
                                            
                                            break;
                                             
                                    case "b":
                                               Year thisYear = Year.now();
                                               String emploCode = thisYear + "-" + genEmpCode();
                                               System.out.print("Enter Name: ");
                                               press = in.next();
                                               emp.add(new Employee(press,emploCode));


                                               System.out.println(emploCode);
                                               break;
                                    case "c":   

                                            
                                              if(emp.isEmpty() || listOfRec.isEmpty()){
                                               System.out.println("please fill in the employee and peripheral records");
                                              }else {
                                                
                                                System.out.print("\nFind Name: ");
                                                press = in.next();
                                                System.out.print("\nFind Item: ");
                                                String item = in.next();

                                                //find name
                                                for(int x = 0; x < emp.size();x++){
                                                    if(press.equals(emp.get(x).getName())){
                                                        press = emp.get(x).getName();
                                                        System.out.println("assd");
                                                        break;
                                                    }
                                                    if(x == emp.size()-1){
                                                       press = "";
                                                       break;
                                                    }
                                                 
                                                }
                                                //find peripheral
                                                for(int x = 0; x < listOfRec.size();x++){
                                                    if(item.equals(listOfRec.get(x).getCode())){
                                                        item = listOfRec.get(x).getCode();
                                                        break;
                                                    }
                                                    if(x == listOfRec.size()-1){
                                                        item = "";
                                                        break;
                                                     }
                                                  

                                              
                                                }
                                               
                                                System.out.println(item.isEmpty() ? " item not found" : "item found");
                                                System.out.println(press.isEmpty() ? " name not found" : "name found");
                                               
                                              

                                                //fill in stock if it is empty
                                                if(assignItems.isEmpty() && (!item.isEmpty()&& !press.isEmpty())){
                                                  System.out.println(press +" : asdasd");
                                                  assignItems.add(new Availabilty(item,press,assignItems.size()+1));
                                                  break;
                                                }
                                                //find item and name inside the stock
                                                if(!item.isEmpty() && !press.isEmpty()){

                                                    for(int x = 0; x < assignItems.size(); x++){
                                                        if(item.equals(assignItems.get(x).getRecID())){
                                                           System.out.println("item already assigned");
                                                           item = "";
                                                           break;
                                                        }
                                                        if( press.equals(assignItems.get(x).getEmpID())  ){
                                                            System.out.println("person has assigned item");
                                                            press = "";
                                                           break;
                                                        }
                                                    }
                                                    
                                                    if(!item.isEmpty() && !press.isEmpty()){
                                                        assignItems.add(new Availabilty(item, press, assignItems.size()+1));
                                                    }
                                                    
                                                }

                                               


                                              }


                                             

                                               break;
                                    case "d":
                                        for(int i = 0; i < assignItems.size(); i++){
                                            System.out.println(assignItems.get(i).getRecID());
                                            System.out.println(assignItems.get(i).getEmpID());
                                        }
                                        break;
                                          
                                    case "e":
                                        for(int i = 0; i < emp.size(); i++){
                                            System.out.println(emp.get(i).getName());
                                        }
                                        for(int i = 0; i < listOfRec.size(); i++){
                                            System.out.println(listOfRec.get(i).getCode());

                                        }
                                        break;
                                    default:
                                               System.out.println("Enter valid input ");

                                                
                                }
                               
                                break;

                    case 2: 
                            System.out.print("\na. View peripherals \nb. View available peripherals" +
                                            "\nc. View not available peripherals \nd. View all designation of devices"
                                            + "\ne. View all employee \nEnter: ");
                                            press = in.next();
                                switch(press){
                                    
                                    case "a":
                                                viewPer();
                                                break;
                                    case "b":
                                                if(listOfRec.isEmpty() && assignItems.isEmpty()){
                                                    System.out.println("---No peripheral records yet---");
                                                
                                                }else if(!listOfRec.isEmpty() && assignItems.isEmpty()){
                                                    System.out.print("Available Devices: " );
                                                    for(int z = 0; z < listOfRec.size(); z++){
                                                        System.out.print(listOfRec.get(z).getCode()+" , ");
                                                    }

                                                }
                                                else {  
                                                            System.out.println("Available Device: ");
                                                            for(int z = 0; z < assignItems.size(); z++){
                                                                
                                                                for(int y = 0; y < listOfRec.size(); y++){
                                                                    if(listOfRec.get(y).getCode().equals(assignItems.get(z).getRecID())){
                                                                        
                                                                    }else{
                                                                        System.out.print( listOfRec.get(y).getCode());
                                                                    }
                                                                }
                                                                
                                                            }
                                                }
                                                
                                                break;
                                    case "c":
                                                notAvail();
                                                break;
                                    case "d":
                                                designationOfDev("d");
                                                break;
                                    case "e":
                                                if(emp.isEmpty()){
                                                    System.out.println("---No Employee Yet---");
                                                }else{
                                                        System.out.println("-----View All Employees-----" );
                                                        for (int y = 0; y < emp.size(); y++){
                                                            System.out.println(emp.get(y).getName() + " : " +
                                                            emp.get(y).getCode());
                                                        }
                                                }
                                   

                                    default:    
                                                System.out.println("---Please enter a valid input---");
                                                

                                }
                                break;
                            
                    case 3:
                                System.out.println("This choice is down, Please wait for few days as I am fixing \nthis bug. "+
                                                 "I am deeply sorry for the inconvinience... Have a nice day \n-JEM");
                            break;
                    case 4:     
                                System.out.println("Enter the peripheral code of the item you want to delete  \nEnter: ");
                                String enter = in.next();
                                for (int x =0; x<listOfRec.size();x++){
                                if(listOfRec.isEmpty()){
                                    System.out.println("There are no peripheral available");
                                }else if(enter.equals(listOfRec.get(x).getCode())){
                                    listOfRec.remove(x).getCode();
                                    System.out.println("---Successfully Deleted---");
                                }else{
                                   
                                }
                                System.out.println("---Could not find peripheral code---");
                                }
                            break;
                    case 5:
                            System.out.print("\na. # of available peripherals \nb. # of assigned peripherals" +
                                            "\nc. # of devices " +
                                            "\ne. # of employees with peripherals assiged \nEnter: " );
                                            press = in.next();
                                switch(press){

                                    case "a":
                                            if(listOfRec.isEmpty() && assignItems.isEmpty()){
                                                System.out.println("---No peripheral records yet---");
                                            
                                            }else if(!listOfRec.isEmpty() && assignItems.isEmpty()){
                                                System.out.println("# of available device : " + listOfRec.size());
                                                

                                            }
                                            else {
                                                    int count = 0;
                                                        for(int z = 0; z < assignItems.size(); z++){
                                                            
                                                            for(int y = 0; y < listOfRec.size(); y++){
                                                                if(listOfRec.get(y).getCode().equals(assignItems.get(z).getRecID())){
                                                                    break;
                                                                }else if(y == listOfRec.size()-1 && !listOfRec.get(y).getCode().equals(assignItems.get(z).getRecID())){
                                                                    count++;
                                                                    break;
                                                                }
                                                                    
                                                               
                                                            }
                                                            
                                                        }
                                                        System.out.println("# available devices: " + count);
                                            }
                                            break;
                                    case "b":
                                            if(assignItems.isEmpty()){
                                                System.out.println(" ---All items are available---");
                                            }else if(assignItems.isEmpty() && listOfRec.isEmpty()){
                                                System.out.println("---No peripherals record---");
                                            }
                                            else{   
                                                    System.out.println("# of available devices: ");
                                                    for (int x =0; x < assignItems.size(); x++){
                                                        System.out.print(assignItems.size() );
                                                    }
                                                }
                                
                                

                                    case "c":
                                    
                                                designationOfDev("c");

                                    case "d":
                                                if(assignItems.isEmpty()){
                                                    System.out.print("No assigned employee");
                                                } else{
                                                        System.out.println("# of employess with assigned peripheral: ");
                                                            for(int g = 0; g < assignItems.size(); g++){
                                                                System.out.print(assignItems.size());
                                                            }

                                                }
                                    
                                    default:
                                            System.out.println("---Please enter a valid input---");

                                }       
                    case 6:
                                System.out.println("Thank you for using the program!!!");
                                System.exit(0);
                                in.close();
                    default:
                          System.out.println("---Please enter a valid input---");

            }
            
        }catch(Exception e){
            System.out.println("Please Enter Valid Input: ");
            in.nextLine();
            
            
    }
        

    }
}
   public static int num,numb;
   public static String genHarCode(){
    String genCode = String.format("%04d",numb++);
    return genCode;
   }
   public static String genEmpCode(){
    String genCode = String.format("%04d",num++);
    return genCode;
   }
   public static void getPer(){
    for(num =0; num < emp.size(); num++){
        if(emp.get(num).getCode().contains(avail.getRecID())){

        }
    }
   }
   
   //show available
   
   public static void viewPer(){
    if(listOfRec.isEmpty()){
        System.out.println("----No Peripheral available----");
    }else{
        System.out.print("---All Devices--- ");
        for (num = 0; num<listOfRec.size();num++){
        System.out.println(listOfRec.get(num).getDevName() + " : " + listOfRec.get(num).getCode());}
    }
   }


   

   public static void notAvail() {
    if(assignItems.isEmpty()){
        System.out.println(" ---All items are available---");
    }else if(assignItems.isEmpty() && listOfRec.isEmpty()){
        System.out.println("---No peripherals record---");
    }
    else{   
            for (int x =0; x < assignItems.size(); x++){
                System.out.print("Not available peripherals :" + assignItems.get(x).getRecID() );
            }
        }

    }



   public static void designationOfDev(String ch){
       

        if(listOfRec.isEmpty()){
            System.out.println("---No peripheral record yet---");
        }else{
            String inputDev = "";
            String outputDev = "";
            String inOutDev = "";
            int cntIn=0;
            int cntOut=0;
            int cntInOut=0;

                for(int x = 0; x < listOfRec.size(); x++){
                    if(listOfRec.get(x).getDevDesignation()== 1){
                    inputDev +=  "Input device: " + listOfRec.get(x).getDevName()+ " : " + listOfRec.get(x).getCode()+"\n"  ;
                    cntIn++;
                    }
                    if(listOfRec.get(x).getDevDesignation()== 2){
                    outputDev += "Output device: " + listOfRec.get(x).getDevName()+ " : " + listOfRec.get(x).getCode()+"\n";
                    cntOut++;
                    }
                    if(listOfRec.get(x).getDevDesignation()== 3){
                    inOutDev += "Input/Output device: " + listOfRec.get(x).getDevName()+ " : " + listOfRec.get(x).getCode()+ "\n";
                    cntInOut++;
                    }
                }
            
            if(ch.equals("d")){

                System.out.println(inputDev);
                System.out.println(outputDev);
                System.out.println(inOutDev);
            }else{
                System.out.println("# input devices: " + cntIn);
                System.out.println("# output devices: " + cntOut);
                System.out.println("# input/output devices: " + cntInOut);
            }
            
        }
   }
  



   
}

