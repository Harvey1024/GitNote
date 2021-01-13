import java.util.List;
import java.util.ArrayList;

class SummaryRanges {
  public static void main(String[] args) {
    int[] nums = {};
    List<String> result = summaryRanges2(nums);
    System.out.println(result);
  }

  public static List<String> summaryRanges(int[] nums) {
    int k = 0;
    List<String> out = new ArrayList<>();
    out.add("" + nums[0]);
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] - nums[i - 1] == 1 && i != nums.length - 1) {
        continue;
      } else {
        String temp = "" + nums[i - 1];
        if (!out.get(k).toString().equals(temp)) {
          out.set(k, out.get(k) + "->" + nums[i - 1]);
        }
        if (i == nums.length - 1 && nums[i] - nums[i - 1] == 1) {
          out.set(k, out.get(k) + "->" + nums[i]);
        } else {
          out.add("" + nums[i]);
          k++;
        }
      }
    }
    return out;
  }

  public static List<String> summaryRanges2(int[] nums) {
    int n = nums.length;
    List<String> ret = new ArrayList<>();
    int i = 0;
    while (i < n) {
      int low = i;
      i++;
      while (i < n && nums[i] - nums[i - 1] == 1) {
        i++;
      }
      int high = i - 1;
      StringBuffer temp = new StringBuffer(Integer.toString(nums[low]));
      if (low < high) {
        temp.append("->");
        temp.append(Integer.toString(nums[high]));
      }
      ret.add(temp.toString());
    }
    return ret;
  }
}