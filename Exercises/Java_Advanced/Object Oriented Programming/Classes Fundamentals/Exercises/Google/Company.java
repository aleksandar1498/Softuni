class Company{
    String name;
    String department;
    double salary;
    public Company(String name,String department,double salary){
        this.name=name;
        this.department=department;
        this.salary=salary;
    }
    @Override
    public String toString(){
        
        return String.format("%n%s %s %.2f%n",this.name,this.department,this.salary);
    }
    
}