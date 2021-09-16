package Utils;

import org.junit.Test;

public class ruleOutShortTest {

    @Test   // 测试文章过短的情况
    public void RuleOutShortTest(){
        System.out.println(similarity.getSimHash("曾看见灰色外星人"));
    }
}
