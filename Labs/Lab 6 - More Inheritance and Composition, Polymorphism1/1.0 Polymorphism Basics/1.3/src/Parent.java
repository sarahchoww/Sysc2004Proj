public class Parent {

    private final String name;
    public Parent(String name) {
        this.name = name;
    }

    public void aMethod() {
        System.out.println("I am: " + this.name);
    }

    public String getName() {
        return name;
    }
}
