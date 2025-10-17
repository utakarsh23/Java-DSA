package LeetCode.Greedy;

import java.util.Arrays;

class BuyTwoChocolates {
    public int buyChoco(int[] prices, int money) {
        Arrays.sort(prices);
        int left = money - (prices[0] + prices[1]);
        return left >= 0 ? left : money;
    }
}