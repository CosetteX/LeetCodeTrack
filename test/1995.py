from collections import defaultdict

def countQuadruplets(nums):
    n = len(nums)
    res = 0
    d = defaultdict(int)
    d[nums[0] + nums[1]] = 1
    for i in range(2, n -1):
        print('loop:', i)
        for j in range(i):
            d[nums[i] + nums[j]] += 1

        for j in range(i + 2, n):
            res += d[nums[j] - nums[i+1]]
            print('   d[nums[j]-nums[i]]', d[nums[j] - nums[i+1]])
            print('   j,i,nums[j],nums[i]', j,i,nums[j] , nums[i])

        print('   my dict:', d)
        print('   my res:', res)
    return res

def countQuadrupletsExpected( nums):

    n = len(nums)
    res = 0
    d = defaultdict(int)
    d[nums[0] + nums[1]] = 1
    for i in range(2, n - 1):
        print('loop:', i)
        for j in range(i + 1, n):
            res += d[nums[j] - nums[i]]

            print('   d[nums[j]-nums[i]]', d[nums[j] - nums[i]])
            print('   j,i,nums[j],nums[i]', j, i, nums[j], nums[i])
        for j in range(i):
            d[nums[i] + nums[j]] += 1


        print('   expected dict:', d)
        print('   expected res:', res)
    return res

if __name__=='__main__':
    input=[1,1,1,3,5]
    res=countQuadruplets(input)
    exp_res=countQuadrupletsExpected(input)
    print('expected:',exp_res)
    print('my:',res)
