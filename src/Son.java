public class Son extends Parent{


    public Son() {
//        super();
        System.out.println("实例化 Son");
        System.out.println(super.hashCode());
        System.out.println(this.hashCode());
        System.out.println(super.equals(this));
    }


    @Override
    public void say() {
        System.out.println("son say");
    }

    public void work(){
        System.out.println("Son work");
    }

    public static void main(String[] args) {
        Son son = new Son();
        son.say();
        son.work();
        int age = son.age;
    }


    static  {
        System.out.println("Son static code block");
    }


    {
        System.out.println("Son code block");
    }
}
