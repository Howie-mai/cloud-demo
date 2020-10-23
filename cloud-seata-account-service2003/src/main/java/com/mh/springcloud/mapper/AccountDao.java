package com.mh.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * ClassName：
 * Time：20/10/20 下午3:42
 * Description：
 *
 * @author mh
 */
@Mapper
public interface AccountDao {
    /**
     * 扣减账户余额     * @param userId     * @param money
     */
    void decrease(@Param("userId") Long userId, @Param("money") BigDecimal money);
}
