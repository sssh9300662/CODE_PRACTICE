package designpattern;

public class Singleton {

    private static class SingletonHolder {
        public static final Singleton INSTANCE = new Singleton(); // 靜態(保證JVM只有一個), final 保證初始化和不被修改
    }

    private Singleton() {} //Required 私有建構子, 避免任何人都能初始化

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }

    public static void main(String[] args){
        System.out.println(Singleton.getInstance());
        System.out.println(Singleton.getInstance());
    }
}
