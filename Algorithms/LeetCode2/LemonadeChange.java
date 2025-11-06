package LeetCode2;

public class LemonadeChange {
    public static void main(String[] args) {
        System.out.println(lemonadeChange(new int[] {5,5,5,5,20,10,10,20}));
        /*
            5 5 5 10 10 20 20
            gives = 20
            ra = 15

            15 10 0
            10 10 0
             5 20 0
             5 20 20  | ra = 15
             j = 2;;;
             j = 1 :
                money[j:1] % bills[i] = 20 & 20; mon = 0;
             j = 0 :
                money[j:0] % bills[i] = 5 & 20; mon = 0;

            0 10 20

            5 20 10
            25 ra = 15;

            sum


        */
    }

    static public boolean lemonadeChange1(int[] bills) {
        int five = 0, ten = 0;
        int i = 0;
        int len = bills.length-1;
        for (int x : bills) {
            if(x == 5) {
                five++;
            } else if (x == 10) {
                if(five == 0) return false;
                five--;
                ten++;
            } else {
                if(ten > 0 && five > 3) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -=  3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

//    static public boolean lemonadeChange(int[] bills) {
//        int[] money = new int[3];
//        int i = 0;
//        int len = bills.length;
//        int sum = 0;
//        while(i < len) {
//            money[0] = bills[i] == 5 ? money[0] + 5 : money[0];
//            money[1] = bills[i] == 10 ? money[1] + 10 : money[1];
//            money[2] = bills[i] == 20 ? money[2] + 20 : money[2];
//            int ra = bills[i]-5;
//            sum += bills[i];
//            if(ra >= sum) {
//                return false;
//            }
//            for(int j = 1; j >= 0 && ra != 0; j--) {
//                int mon = money[j] % bills[i];
//                if(money[j] > ra && mon > 0) {
//                    int t = money[j]-mon;
//                    money[j] = t; //20, 10, 5
//                }
//            }
//            sum -= ra;
//            i++;
//        }
//        return true;
//    }
}
