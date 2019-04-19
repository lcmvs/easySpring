public class Main {

    public static void main(String[] args) {
        System.out.println(Main.class.getClassLoader().getResource(""));
        System.out.println(Main.class.getClassLoader().getResource("/"));
        System.out.println(Main.class.getResource(""));
        System.out.println(Main.class.getResource("/"));
    }

}
