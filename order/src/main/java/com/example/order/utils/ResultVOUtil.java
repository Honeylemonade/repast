package com.example.order.utils;

import com.example.order.vo.ResultVO;

/**
 * ResultVOUtil:
 *
 * @Author XvYanpeng
 * @Date 2020/3/7 20:15
 */
public class ResultVOUtil {

    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        resultVO.setData(object);
        return resultVO;
    }
}
