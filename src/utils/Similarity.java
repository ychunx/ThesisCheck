package utils;

import com.hankcs.hanlp.HanLP;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.List;

@SuppressWarnings("ALL")
public class Similarity {

    public static String getHash(String str){
        // 使用 MD5 获取 hash 值

        try{
            MessageDigest ms = MessageDigest.getInstance("MD5");    // 提供 MD5 算法
            // 重置 ms 为初始状态； 二进制
            return new BigInteger(1, ms.digest(str.getBytes(StandardCharsets.UTF_8))).toString(2);
        }catch(Exception e){
            e.printStackTrace();
            return str;
        }
    }

    public static String getSimHash(String str){

        try{
            if(str.length() < 200) throw new RuleOutShort("文本过短！"); // 如果文章太短会导致 HanLp 无法获取关键字
        }catch (RuleOutShort e){
            e.printStackTrace();    // 在命令行打印异常信息在程序中出错的位置及原因
            return null;
        }

        int[] v = new int[128]; // 取 128 位数组表示特征向量

        List<String> keywordList = HanLP.extractKeyword(str, str.length()); // 利用 hankcs 包提供的接口取出所有关键词

        int size = keywordList.size();
        int i = 0;

        for(String keyword : keywordList){

            String keywordHash = getHash(keyword);  // 获取 hash 值

            // 如果 hash 值少于 128 位，则在低位补 0
            if (keywordHash.length() < 128) {
                int num = 128 - keywordHash.length();
                for (int j = 0; j < num; j++) {
                    keywordHash += "0";
                }
            }

            for (int j = 0; j < v.length; j++) {
                if (keywordHash.charAt(j) == '1') {
                    // 权重分 10 级，由词频从高到低，取权重 10 ~ 0
                    // 在加权的同时完成合并，1 为正，0 为负
                    v[j] += (10 - (i / (size / 10)));
                } else {
                    v[j] -= (10 - (i / (size / 10)));
                }
            }
            i++;
        }

        // 形成最终的 simhash 签名；每一位如果小于 0 则记为 0，大于 0 则记为 1
        String simHash = "";
        for (int j : v) {
            if (j <= 0) {
                simHash += "0";
            } else {
                simHash += "1";
            }
        }
        return simHash;
    }

    public static int getHammingDistance(String simHash1, String simHash2) {

        int distance = 0;
        if (simHash1.length() != simHash2.length()) {
            distance = -1;  // 出错，返回-1
        } else {
            for (int i = 0; i < simHash1.length(); i++) {
                if (simHash1.charAt(i) != simHash2.charAt(i)) {     // 指定位符获取
                    distance++;     // 比较每一位，如果不同则距离加一
                }
            }
        }
        return distance;
    }

    public static double getSimilarity(String str0, String str1) {

        String simHash0 = getSimHash(str0);
        String simHash1 = getSimHash(str1);

        // 获取海明距离
        assert simHash0 != null;
        assert simHash1 != null;
        int distance = getHammingDistance(simHash0, simHash1);
        // 通过海明距离计算出相似度
        return 0.01 * (100 - distance * 100 / 128);
    }
}
