import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here

        System.out.println(memoizedFib(1));
        System.out.println(memoizedFib(2));
        System.out.println(memoizedFib(3));
        System.out.println(memoizedFib(4));
        System.out.println(memoizedFib(5));
        System.out.println(memoizedFib(6));
        System.out.println(memoizedFib(7));
        System.out.println(memoizedFib(8));
        System.out.println(memoizedFib(9));
    }

    public static HashMap<Integer, Integer> fibMap = new HashMap<Integer, Integer>();
    public static int memoizedFib(int n){
        Integer mapValue = fibMap.get(n);
        if(mapValue != null){
            return mapValue.intValue();
        }
        else{
            if(n == 1 || n == 2){
                fibMap.put(n,1);
            } else{
                int result = memoizedFib(n-1) + memoizedFib(n -2);
                fibMap.put(n,result);
            }
        }
        return memoizedFib(n);
    }
}
