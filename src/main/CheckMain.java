package main;

import utils.Hamming;
import utils.SimHash;
import utils.TxtIO;

public class CheckMain {

    public static void main(String[] args) {

        // 将文件内容转化为字符串
        String str0 = TxtIO.readTxt(args[0]);
        String str1 = TxtIO.readTxt(args[1]);

        // 求出 simHash 值
        String simHash0 = SimHash.getSimHash(str0);
        String simHash1 = SimHash.getSimHash(str1);

        // 求出相似度
        double similarity = Hamming.getSimilarity(simHash0, simHash1);

        // 写入结果
        String ans = args[2];   // 获取文件路径及名称
        TxtIO.writeTxt(similarity, ans);

        System.exit(0);
    }
}
