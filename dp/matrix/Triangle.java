package dp.matrix;
import java.util.List;
/*
 * matrix dp������ͨ���Ż�ɨ��˳���С�ռ��ʹ��
 * 0. ��������, �����·��, matrix -> dp
 * 1. f[i] -> ÿһ���i���ڵ㵽�ײ������·��
 * 2. f[i] = min(f[i] + f[i - 1]) + x[i] -> ����ǰ����һ��ĵ�i���ڵ�͵�i + 1���ڵ���С���Ǹ���������ڵ��Լ���ֵ
 * 3. ����ײ�, f[i] = x[i] -> ��ʼ��Ϊ�����еײ�ڵ��ֵΪ���ڵ㱾���ֵ
 * 4. ��һ�㣬����f[0] -> ��Ϊ��һ���ʱ��Ψһһ���ڵ��ֵ
 * 
 * ֻ��O(n)�Ŀռ䣬һ�����鸴�ã���Ϊɨ���˳��f[i] = f[i] + f[i + 1], f[i + 1] = f[i + 1] + f[i + 2]
 * ÿ��ֻ���޸�ǰһ��λ�ã�����һ��λ��ɨ���ʱ��ֻ��Ҫ��һ��λ�õ�ֵ�����Բ����ͻ������ӵ����ϱȴ�������Ҫ��
 * ����õݹ�ķ���������Ҫ����O(n^2)�Ŀռ䣬��Ϊ��Ҫ��ÿһ��Ԫ�ض�����һ���ռ䣬�洢�����Ԫ�ص��ײ�����С·��
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] hash = new int[len];
        List<Integer> row;
        for (int i = len - 1; i >= 0; i--) {
            row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (i == len - 1) {
                    hash[j] = row.get(j);
                } else {
                    hash[j] = Math.min(hash[j], hash[j + 1]) + row.get(j);
                }
            }
        }
        return hash[0];
    }
}
