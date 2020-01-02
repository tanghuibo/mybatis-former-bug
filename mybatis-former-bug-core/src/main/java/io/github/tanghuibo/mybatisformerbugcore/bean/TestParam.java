package io.github.tanghuibo.mybatisformerbugcore.bean;

import java.util.List;

/**
 * @author tanghuibo
 * @date 2020/1/3上午12:32
 */
public class TestParam {

    private Long testId;

    private List<Long> testIdList;

    public Long getTestId() {
        return testId;
    }

    public void setTestId(Long testId) {
        this.testId = testId;
    }

    public List<Long> getTestIdList() {
        return testIdList;
    }

    public void setTestIdList(List<Long> testIdList) {
        this.testIdList = testIdList;
    }
}
