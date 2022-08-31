package TestCases;

import Util.TestUtil;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(TestUtil.class)
public class RecruitmentPageTest extends TestBase{

    @Test(priority = 1)
    public void candidateNameTest() {
        startLoginPage()
                .navigateToPIMPage()
                .navigateToRecruitmentPage()
                .validateSearchByJobTitle("QA Lead")
                .validateCandidateName("Joe Root");
    }

    @Test(priority = 2)
    public void selectCandidateNameTest() {
        startLoginPage()
                .navigateToPIMPage()
                .navigateToRecruitmentPage()
                .validateSearchByJobTitle("QA Lead")
                .selectCandidateName("Joe");
    }
}