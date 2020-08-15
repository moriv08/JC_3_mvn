package lessons.les7.testCat;

public class Cat {

    public String name;
    private int age;
    protected String color;

    public Cat(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }

    public void info(){
        System.out.println("public info: " + name + " age " + age + " color " + color);
    }

    private void info2(){
        System.out.println("Info_2 private modifier " + name + " its age " + age + " its color " + color);
    }

    public int getAge(){
        return age;
    }

    public void itsColor(String s){
        System.out.println("This cat color is " + color);
    }
}
