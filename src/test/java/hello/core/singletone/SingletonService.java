package hello.core.singletone;

public class SingletonService {

    private static final SingletonService instance = new SingletonService();
    // static 이란? -> 하나만 올라가게 된다.

    public static SingletonService getInstance(){
        return instance;
    }

    private SingletonService(){

    }

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }

}
