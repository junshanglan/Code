package array;


public class Fib {

    public static void main(String[] args) {
        //1,1,2,3,5,8,13,21,34
        //30  832040
        int fib = fib(1);
        System.out.println(fib);
    }
    public static int fib(int N){
		/*if (N == 0) {
			return 0;
		}else if (N == 1) {
			return 1;
		}else{
			return fib(N -1) +fib(N - 2);
		}*/

		/*if (N == 0) {
			return 0;
		} else if(N == 1){
			return 1;
		}else{
			List<Integer> data = new ArrayList<Integer>(){{
				add(1);
				add(1);
			}};
			for (int i = 2; i < N; i++) {
				int temp = data.get(i - 1) + data.get(i - 2);
				data.add(temp);
			}
			return data.get(data.size()-1);
		}*/
		// 最优解
        if (N == 0){
            return 0;
        }else if (N == 1) {
            return 1;
        }

        int fib1 = 0,fib2 = 1,temp = 0;
        for (int i = 2; i <= N ; i++) {
            temp = fib1 + fib2;
            fib1 = fib2;
            fib2 = temp;
        }
        return temp;
    }
}
