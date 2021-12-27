public abstract class Parent {

    public int age;

    public Parent() {
        System.out.println("实例化 Parent");
    }


    public abstract void say();

    public void work(){
        System.out.println("parent work");
    }

    static  {
        System.out.println("Parent static code block");
    }


    {
        System.out.println("Parent code block");
    }
}
