class Solution:
    def maxSubArray(self, nums: list[int]) -> int:

        l, r = 0, 0
        n = len(nums)

        suma = nums[0]
        maxi = nums[0]

        for i in range(1, n):

            if suma < 0:
                suma = nums[i]
                l = i
            else:
                suma = suma + nums[i]

            maxi = max(maxi, suma)

        return maxi