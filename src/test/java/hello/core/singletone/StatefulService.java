package hello.core.singletone;

public class StatefulService {

    //private int price;

    public int order(String name, int price){
        System.out.println("name = " + name + "price = " + price);
        //this.price = price; // 이거 하면 망하는것
        return price;
    }

    //public int getPrice(){
    //    return price;
    //}

}
