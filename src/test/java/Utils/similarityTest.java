package Utils;

import org.junit.Test;

@SuppressWarnings("ALL")
public class similarityTest {

    @Test
    public void getHashTest(){
        String[] strings = {"美国", "51区", "雇员", "称", "内部", "有", "9架", "飞碟"};

        for (String s : strings) {
            System.out.println(similarity.getHash(s) + "\r\n");
        }
    }

    @Test
    public void getSimHashTest(){
        String str = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");

        System.out.println(similarity.getSimHash(str));
    }

    @Test
    public void getHammingDistanceTest() {
        String str0 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String str1 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_add.txt");

        int distance = similarity.getHammingDistance(similarity.getSimHash(str0), similarity.getSimHash(str1));

        System.out.println("海明距离：" + distance);
    }

    @Test
    public void getSimilarityTest() {
        String str0 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig.txt");
        String str1 = txtIO.readTxt("C:/Users/ychun/Desktop/电脑文件/大三上/软件工程/ThesisCheck/testDocumentation/orig_0.8_add.txt");

        int distance = similarity.getHammingDistance(similarity.getSimHash(str0), similarity.getSimHash(str1));
        double Similarity = similarity.getSimilarity(str0, str1);

        System.out.println("str0和str1的汉明距离: " + distance);
        System.out.println("str0和str1的相似度:" + Similarity);
    }

    @Test   // 测试 str0.length()!=str1.length() 的情况
    public void getHammingDistanceFailTest() {
        String str0 = "10001101011";
        String str1 = "1000010001";

        System.out.println(similarity.getHammingDistance(str0, str1));
    }
}
