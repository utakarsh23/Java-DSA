package staticExample;

class nonStaticFirst {
    String name;

    public nonStaticFirst(String name) {
        this.name = name;
    }
}
// static public class InnerClasses.... /// outside classes cannot be static
/// it's not dependent on any other class
public class InnerClasses {

    //but inner can and can not
    static class innerStatic {
        String name;

        public innerStatic(String name) {
            this.name = name;
        }

    }
    //not static
    class notStatic {
        String name;

        public notStatic(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        innerStatic obj1 = new innerStatic("Utkarsh");
        /// can be assess through, because it is a static inner class as the Main classes, static and the Main class is static too

//        notStatic obj2 = new notStatic("Shresth");
        /// cannot be assessed because it's not a static class so it shows an error of "cannot be reference from a static context" as the Main classes is static

        nonStaticFirst obj3 = new nonStaticFirst("Utakarsh");
        /// here it can be accessed because it is a non-static class and it is also not reference by any non-static class

    }
}
