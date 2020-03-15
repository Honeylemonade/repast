package com.example.product.utils;

import com.example.product.vo.ResultVO;

/**
 * ResultVOUtil:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 17:29
 */
public class ResultVOUtil {
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return resultVO;
    }
}
