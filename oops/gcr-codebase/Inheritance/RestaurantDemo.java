interface Worker {

    void performDuties();
}

class Person {

    protected String name;
    protected int id;

    Person(String name, int id) {

        this.name = name;
        this.id = id;
    }

    void displayInfo() {

        System.out.println(
                "Name: " + name);

        System.out.println(
                "ID: " + id);
    }
}

class Chef extends Person
        implements Worker {

    Chef(String name, int id) {

        super(name, id);
    }

    @Override
    public void performDuties() {

        System.out.println(
                name + " is preparing food.");
    }
}

class Waiter extends Person
        implements Worker {

    Waiter(String name, int id) {

        super(name, id);
    }

    @Override
    public void performDuties() {

        System.out.println(
                name + " is serving customers.");
    }
}

public class RestaurantDemo {

    public static void main(String[] args) {

        Chef chef =
                new Chef("Rahul", 101);

        Waiter waiter =
                new Waiter("Aman", 102);

        chef.displayInfo();
        chef.performDuties();

        System.out.println();

        waiter.displayInfo();
        waiter.performDuties();
    }
}