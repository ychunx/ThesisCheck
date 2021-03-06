package Main;

import Utils.similarity;
import Utils.txtIO;

import org.junit.Test;

public class mainTest {

    @Test
    public void origToOrig(){
        String str0 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String str1 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String ansFileName = "C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/ansOrigToOrigTest.txt";

        double ans = similarity.getSimilarity(str0, str1);
        txtIO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origToAdd(){
        String str0 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String str1 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_add.txt");
        String ansFileName = "C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/ansOrigToAddTest.txt";

        double ans = similarity.getSimilarity(str0, str1);
        txtIO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origToDel(){
        String str0 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String str1 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_del.txt");
        String ansFileName = "C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/ansOrigToDelTest.txt";

        double ans = similarity.getSimilarity(str0, str1);
        txtIO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origToDis1(){
        String str0 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String str1 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_dis_1.txt");
        String ansFileName = "C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/ansOrigToDis1Test.txt";

        double ans = similarity.getSimilarity(str0, str1);
        txtIO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origToDis10(){
        String str0 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String str1 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_dis_10.txt");
        String ansFileName = "C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/ansOrigToDis10Test.txt";

        double ans = similarity.getSimilarity(str0, str1);
        txtIO.writeTxt(ans, ansFileName);
    }

    @Test
    public void origToDis15(){
        String str0 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String str1 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_dis_15.txt");
        String ansFileName = "C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/ansOrigToDis15Test.txt";

        double ans = similarity.getSimilarity(str0, str1);
        txtIO.writeTxt(ans,ansFileName);
    }

    @Test
    public void origToAll(){
        String[] str = new String[6];
        str[0] = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        str[1] = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_add.txt");
        str[2] = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_del.txt");
        str[3] = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_dis_1.txt");
        str[4] = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_dis_10.txt");
        str[5] = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_dis_15.txt");
        String ansFileName = "C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/ansOrigToAll.txt";

        for(int i = 0; i <= 5; i++){
            double ans = similarity.getSimilarity(str[0], str[i]);
            txtIO.writeTxt(ans, ansFileName);
        }
    }
}
