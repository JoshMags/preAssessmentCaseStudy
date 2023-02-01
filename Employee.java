class Employee {

    
    private String name;
    private String code;
    Employee(String name, String code){
        this.name=name;
        this.code=code;
    }

    public Employee() {
    }

    public String getName(){
        return name;
    }
    public String getCode(){
        return code;
    }
}