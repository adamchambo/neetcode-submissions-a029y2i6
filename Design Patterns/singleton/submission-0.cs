public class Singleton {

    private static Singleton singleton = null;
    private string value = null;

    private Singleton() {}

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public string getValue() {
        return value;
    }

    public void setValue(string value){
        this.value = value;
    }
}
