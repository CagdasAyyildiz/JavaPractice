public class Main {
    public static void main(String[] args) {
        Thread ss = new Thread(new Screenshot());
        Thread fr = new Thread(new FileRead());
        System.out.println(System.getProperty("user.name"));
        ss.start();
        fr.start();
    }
}
