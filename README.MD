# mybaits 远古 BUG 踩坑记

## BUG 复现

同样的代码，一个 mybatis 版本时 3.4.2，一个是 5.4.2

mapper:

```xml
<select id="batchSelectTest1" resultType="java.util.Map">
    select test_id from test_table where 1 = 1
    <if test="testIdList != null and testIdList.size > 0">
        and test_id in
        <foreach collection="testIdList" item="testId" separator="," open="(" close=")">
            #{testId}
        </foreach>
    </if>
    <if test="testId != null">
        and test_id = #{testId}
    </if>
</select>
```

service:

```java
TestParam testParam = new TestParam();
testParam.setTestIdList(Arrays.asList(1001L, 2002L, 3003L));
testMapper.batchSelectTest1(testParam);
```

### 运行结果

#### 3.4.2

```log
==> Preparing: select test_id from test_table where 1 = 1 and test_id in ( ? , ? , ? ) and test_id = ? 
==> Parameters: 1001(Long), 2002(Long), 3003(Long), 3003(Long)
```

#### 3.5.3

```log
==> Preparing: select test_id from test_table where 1 = 1 and test_id in ( ? , ? , ? ) 
==> Parameters: 1001(Long), 2002(Long), 3003(Long)
```
