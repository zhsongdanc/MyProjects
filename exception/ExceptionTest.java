package exception;

/*
 * @Author: demussong
 * @Description:
 * @Date: 2022/11/7 12:12
 */
public class ExceptionTest {

    public static void main(String[] args) throws Exception{
       test();
        System.out.println("fsz");
    }


    public static void test() throws Exception{
        try{
            int x = 4/0;
        }catch (Exception e){
            throw new RuntimeException("ewwe");
//            System.out.println("fwew");
        }
        System.out.println("hello");
    }
}
