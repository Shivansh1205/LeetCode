class Solution:
    def twoSum(self, nums: list[int], target: int) -> list[int]:
        Map = {}
        n = len(nums)
        for i in range(n):
            comp = target-nums[i]
            if comp in Map:
                return [Map[comp],i]
            Map[nums[i]] = i
        return []
        
        