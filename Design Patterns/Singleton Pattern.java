package singleton.pattern;
/*
 * @author Md Redwanuzzaman
 */
public class SingletonPattern {

    public static void main(String[] args) {
        Test t1 = Test.getInstance();
        Test t2 = Test.getInstance();
        Test t3 = Test.getInstance();
        
        System.out.println("Address of t1 = " + t1.hashCode()); // 366712642
        System.out.println("Address of t2 = " + t2.hashCode()); // 366712642
        System.out.println("Address of t3 = " + t3.hashCode()); // 366712642
    }
    
}

public class Test {
    private static Test tst = null;
    static{
        tst = new Test();
    }
    
    private Test(){     
    }
    
    public static Test getInstance(){
        return tst;
    }
}
