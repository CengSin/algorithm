package com.company.simple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 56. 合并区间
 */

class LeetCode_56_Solution1ms {
    public int[][] merge(int[][] intervals) {
        int max = 0;
        for(int i=0;i<intervals.length;i++){
            for(int j=0;j<intervals[0].length;j++){
                if(intervals[i][j]>max){
                    max = intervals[i][j];
                }
            }
        }
        int [] base = new int[max+1];
        for(int i=0;i<intervals.length;i++){
            int a=intervals[i][0];
            int b=intervals[i][1];
            for(int k=a;k<b;k++){
                base[k]=1;
            }
            if(base[b]!=1){
                base[b]=-1;
            }
        }
        List<int [] > ret = new ArrayList<>();
        boolean flag=false;
        int[] temp=new int[2];
        for(int i =0;i<base.length;i++){
            if((flag==false || i==0) && base[i]==1){
                flag=true;
                temp = new int[2];
                temp[0]=i;
            }
            if(  base[i]==-1){
                if(flag==true) {
                    temp[1] = i;
                    ret.add(temp);
                }
                else{
                    ret.add(new int[]{i,i});
                }
                flag = false;
            }
        }
        int [][] result = new int[ret.size()][];
        result = ret.toArray(result);
        return result;
    }
}

class LeetCode_56_Solution {

    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return  intervals;
        // 首先按照起点来排序
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[j][0] > intervals[i][0]) {
                    int[] interval = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = interval;
                }
            }
        }
        // 对比结尾有无相交
        int i = 0;
        int j = intervals.length;
        List<int[]> res = new ArrayList<>();
        while (i < j) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < j - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(intervals[i + 1][1], right);
                i++;
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[res.size()][2]);
    }

    /**
     * [0, 0][1, 4]case 过不了
     * @param intervals
     * @return
     */
    public int[][] mergeNotAc(int[][] intervals) {
        int max = 0;
        for (int i = 0; i < intervals.length; i++) {
            max = Math.max(max, intervals[i][0]);
            max = Math.max(max, intervals[i][1]);
        }

        boolean[] flags = new boolean[max + 2];
        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j <= intervals[i][1]; j++) {
                flags[j] = true;
            }
        }

        List<int[]> resList = new ArrayList<>();
        for (int i = 0; i < flags.length; ) {
            if (flags[i]) {
                int[] res = new int[2];
                res[0] = i;
                int j = i + 1;
                while (j < flags.length && flags[j]) {
                    j++;
                }
                if (j < flags.length && !flags[j]) {
                    res[1] = j - 1;
                    resList.add(res);
                    i = j;
                }
            } else {
                i++;
            }
        }

        if (resList.size() > 0) {
            int[][] res = new int[resList.size()][2];
            int k = 0;
            for (int[] ints : resList) {
                res[k++] = ints;
            }
            return res;
        }
        return new int[][]{};
    }

}

public class LeetCode_56_MergeIntervals {

    public static void main(String[] args) {
        LeetCode_56_Solution solut = new LeetCode_56_Solution();
        System.out.println(Arrays.deepToString(solut.merge(new int[][]
                {{1, 3}, {2, 6}, {8, 10}, {15, 18}}
        )));

        System.out.println(Arrays.deepToString(solut.merge(new int[][]
                {{1, 4}, {4, 5}}
        )));

        System.out.println(Arrays.deepToString(solut.merge(new int[][]
                {{1, 4}, {0, 0}}
        )));

        System.out.println(Arrays.deepToString(solut.merge(new int[][]
                {{1, 3}}
        )));

        // [[1,4],[0,2],[3,5]]

        System.out.println(Arrays.deepToString(solut.merge(new int[][]
                {{1, 4}, {0, 2}, {3, 5}}
        )));
    }

}
