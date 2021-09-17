package Utils;

import org.junit.Test;

@SuppressWarnings("ALL")
public class txtIOTest {

    @Test   // 正常读取
    public void readTest() {
        String str = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String[] strings = str.split(" ");
        for (String s : strings) {
            System.out.println(s);
        }
    }

    @Test   // 正常写入
    public void writeTest() {
        double[] elem = {0.11, 0.33, 0.55, 0.77, 0.99};
        for (double v : elem) {
            txtIO.writeTxt(v, "C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/ans.txt");
        }
    }

    @Test   // 路径错误，读取失败
    public void readFail() {
        String str = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/none.txt");
    }

    @Test   // 路径错误，写入失败
    public void writeFail() {
        double[] elem = {0.11, 0.33, 0.55, 0.77, 0.99};
        for (double v : elem) {
            txtIO.writeTxt(v, "C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/ans.txt");
        }
    }
}
