import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Solution {
  public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    int equationsSize = equations.size();
    UnionFind unionFind = new UnionFind(2 * equationsSize);

    // 1. 创建一个并查集，通过查询获得结果
    Map<String, Integer> hashMap = new HashMap<>(2 * equationsSize);
    int k = 0;
    for (int i = 0; i < equationsSize; i++) {
      List<String> equation = equations.get(i);
      String var1 = equation.get(0);
      String var2 = equation.get(1);
      if (!hashMap.containsKey(var1)) {
        hashMap.put(var1, k);
        k++;
      }
      if (!hashMap.containsKey(var2)) {
        hashMap.put(var2, k);
        k++;
      }
      unionFind.union(hashMap.get(var1), hashMap.get(var2), values[i]);
    }

    // 2. 查询
    double[] queriesValue = new double[queries.size()];
    for (int i = 0; i < queries.size(); i++) {
      String qvar1 = queries.get(i).get(0);
      String qvar2 = queries.get(i).get(1);
      if (!hashMap.containsKey(qvar1) || !hashMap.containsKey(qvar2)) {
        queriesValue[i] = -1d;
      } else {
        queriesValue[i] = unionFind.isConnected(hashMap.get(qvar1), hashMap.get(qvar2));
      }
    }
    return queriesValue;
  }
}
