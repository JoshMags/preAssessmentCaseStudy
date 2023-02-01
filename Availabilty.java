class Availabilty {
    private String recID;
    private String empID;
    private int iD;
Availabilty(String recID,String empId, int iD){
    this.recID=recID;
    this.empID=empId;
    this.iD=iD;
}
Availabilty(){

}

public void setRecID(String recID){
    this.recID = recID;
}

public String getRecID(){
    return recID;
}

public void setEmpID(String empID){
    this.empID = empID;
}
public String getEmpID(){
    return empID;
}

public void setID(int iD){
    this.iD = iD;
}
public int getID(){
    return iD;
}

}
