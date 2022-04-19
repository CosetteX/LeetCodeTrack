#
# @lc app=leetcode id=1995 lang=python
#
# [1995] Count Special Quadruplets
#

# @lc code=start
from collections import defaultdict



class Solution(object):
    def countQuadruplets(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        n=len(nums)
        res=0
        d=defaultdict(int)
        d[nums[0]+nums[1]]=1
        for i in range(2,n-1):
            for j in range(i):
                d[nums[i]+nums[j]]+=1
            for j in range(i+1,n):
                res+=d[nums[j]-nums[i]]
        return res
        
# @lc code=end

