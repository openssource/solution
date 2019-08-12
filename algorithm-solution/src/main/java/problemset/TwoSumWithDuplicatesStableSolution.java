/*
Problem : TwoSum
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
Example:
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]
*/

class TwoSumWithDuplicatesStableSolution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> pos = new HashMap<>();
        
        for(int i = 0; i<nums.length; i++) {
            List<Integer> posL = pos.get(nums[i]);
            if( posL == null) {
                posL = new ArrayList<>();
                pos.put(nums[i], posL);
            } 
            posL.add(i);
        }
        
        
        Integer pairPos = null;
        for(int i = 0; i<nums.length; i++) {
            List<Integer> tPosL = pos.get(target-nums[i]);
            if(tPosL != null) {
                for(Integer tpos : tPosL) {
                    if(tpos != i) {
                        pairPos = tpos;
                        break;
                    }    
                }
            }
            
            if(pairPos != null) {
                return new int[]{i, (int)pairPos};
            }
        }
        return null;
    }
        
}
