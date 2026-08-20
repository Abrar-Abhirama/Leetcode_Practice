class StockSolution{
    public int maxProfit(int[] prices) {
        int result = 0;
        int cheapest = prices[0];
        for (int i = 0; i < prices.length ; i++){
            cheapest = Math.min(cheapest, prices[i]);
            result = Math.max((prices[i] - cheapest), result);
        }

        return result;
    }
}

public class LeetCode121 {
    public static void main(String[] args){
        StockSolution solution = new StockSolution();
        int[] prices = {7,1,5,3,6,4};
        int result = solution.maxProfit(prices);
        System.out.println(result);
    }
}

