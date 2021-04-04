public class Child extends Parent {

    private final String favouriteActivity;

    public Child(String name, String activity) {
        super(name);
        favouriteActivity = activity;
    }

    public void aMethod() {
        super.aMethod();
        System.out.println("/I like to: " + favouriteActivity);
    }
}
