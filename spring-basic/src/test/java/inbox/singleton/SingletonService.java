package inbox.singleton;

public class SingletonService {
    public static final SingletonService instance = new SingletonService();

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService() {

    }

    public void login() {
        System.out.println("Print Singleton Object");
    }
}
