package Protect;

public class ProtectClass {

    public ProtectClass(){

    }

    private Integer numberFive = 5;

    private Integer setNumber(Integer newValue){
        numberFive = newValue;
        return numberFive;
    }

    private ProtectClass(String str){
        System.out.println(str+" "+numberFive);
    }
}
