package Main;

import Utils.similarity;
import Utils.txtIO;

public class mainCheck {

    public static void main(String[] args) {

        // 将文件内容转化为字符串
        String str0 = txtIO.readTxt(args[0]);
        String str1 = txtIO.readTxt(args[1]);

        // 求出相似度
        double Similarity = similarity.getSimilarity(str0, str1);

        // 写入结果
        String ans = args[2];   // 获取文件路径及名称
        txtIO.writeTxt(Similarity, ans);

        System.exit(0);
    }
}

