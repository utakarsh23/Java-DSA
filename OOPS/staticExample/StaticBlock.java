package staticExample;

//to show initialisation of static variables
public class StaticBlock {
    static int a = 4;
    static int b;

    /// It'll only run once when the object is created: i.e: wjen teh class is loaded for the first time(run while the Main class is being loaded)
    static {
        System.out.println("This is a static block");
        b = a * 5;
    }

    public static void main(String[] args) {
        //will execute after the static is executed(cause it runs while the Main class is being loaded and then the Main class)
        System.out.println("hehehhe");
        StaticBlock obj = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        StaticBlock.b += 3;

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + " " + StaticBlock.b);

        /*
        -->Output
        This is a static block
        hehehhe
        4 20
        4 23
        */
    }

}
