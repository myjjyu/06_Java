public class 싱글톤패턴 {
    private static  싱글톤패턴 current;

    public static  싱글톤패턴 getInstance() {
        if (current == null) {
            current = new  싱글톤패턴();
        }

        return current;
    }

    private  싱글톤패턴() {
        super();
    }

    
}
