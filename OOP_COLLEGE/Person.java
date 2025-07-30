class Person {
    String name;
    int age;

    private Person() {
        this.age = 20;
        this.name = "Shumbs";
    }

//    Person(String n, int a) {
//        this.name = n;
//        this.age = a;
//        System.out.println(n);
//        System.out.println(a);
//    }
//    int person(String n, int a) {
//        this.name = n;
//        this.age = a;
//        return 0;
//    }
    public static void main(String[] args) {
      Person person = new Person();
        System.out.println(person.name);
        System.out.println(person.age);
    }
}

class mainClass {
    /*public static void main(String[] args) {
        Person person1 = new Person("Ayush", 19);
        Person person = new Person();

        System.out.println(person1.person("Shresth", 20));
        System.out.println(person1.age);
        System.out.println(person1.name);
    }
    */
}
