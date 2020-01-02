package io.github.tanghuibo.mybatisformerbugcore.dao;

import io.github.tanghuibo.mybatisformerbugcore.bean.TestParam;

import java.util.List;
import java.util.Map;

/**
 * @author tanghuibo
 * @date 2020/1/3上午12:15
 */
public interface TestMapper {


    List<Map> batchSelectTest1(TestParam param);
}
