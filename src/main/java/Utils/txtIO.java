package Utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class txtIO {

    public static String readTxt(String txtPath) {
        String str = "";
        String strALine;    // 按行读取
        File file = new File(txtPath);  // 读取文件
        try {
            // 获取输入字节流
            FileInputStream bs = new FileInputStream(file);
            // 将字节流解码为字符流
            InputStreamReader cs = new InputStreamReader(bs, StandardCharsets.UTF_8);
            // 缓冲区，提高字符流读写的效率
            BufferedReader bf = new BufferedReader(cs);
            // 拼接字符串
            while ((strALine = bf.readLine()) != null) {
                //noinspection StringConcatenationInLoop
                str += strALine;
            }
            // 关闭资源
            bs.close();
            cs.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static void writeTxt(double txtElem,String txtPath){
        String str = Double.toString(txtElem);
        File file = new File(txtPath);  // 写入 txtPath 路径文件
        try {
            FileWriter fw = new FileWriter(file, true);     // true 为追加
            // 如果结果大于三个字符则打印四个字符，如果不超过三个字符则全部打印
            // 即只打印到小数点两位
            fw.write("相似度为：" + str.substring(0 , (str.length() > 3 ? 4 : str.length())) + "\r\n");
            // 关闭资源
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

