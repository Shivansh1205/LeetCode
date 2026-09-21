class Solution:
    def maxProfit(self, prices: list[int]) -> int:
        ini = prices[0]
        profit =0
        for p in prices[1:]:
            if(ini>p):
                ini = p
            profit = max(profit, p-ini)
        return profit
        