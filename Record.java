class Record {

    private String hardCode;
    private String devName;
    private int devDesignation;
    
    Record (String devName,int devDesignation, String hardCode){
         this.devName = devName;
         this.devDesignation = devDesignation;
         this.hardCode = hardCode;
         


    }

    Record (){
        
    }
    public void setCode(String hardCode){
        this.hardCode = hardCode;

    }
    public String getCode(){
       
        return  hardCode ;
    }

  

    public void setDevNanme(String devName){
        this.devName = devName;
    }
    public String getDevName(){
        return devName;
    }

    public void setDesignatedDev(int devDesignation){
        this.devDesignation = devDesignation;
    }
 public int getDevDesignation (){
    return devDesignation;
   }
}

    

