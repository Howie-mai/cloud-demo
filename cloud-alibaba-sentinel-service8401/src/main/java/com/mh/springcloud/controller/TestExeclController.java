package com.mh.springcloud.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.google.common.collect.Lists;
import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.entities.PaymentInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName：
 * Time：2020/11/6 9:48 上午
 * Description：
 *
 * @author mh
 */
@RestController
@Slf4j
public class TestExeclController {


    @GetMapping("/exportSheet")
    public void export(HttpServletResponse response){
        List<Payment> sheet1 = new ArrayList<>();
        List<Payment> sheet2 = new ArrayList<>();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码
        try {
            String fileName = URLEncoder.encode("template", "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
            //新建ExcelWriter
            ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
            //获取sheet0对象
            WriteSheet mainSheet = EasyExcel.writerSheet(0, "支付").head(Payment.class).build();
            //向sheet0写入数据 传入空list这样只导出表头
            excelWriter.write(Lists.newArrayList(),mainSheet);
            //获取sheet1对象
            WriteSheet detailSheet = EasyExcel.writerSheet(1, "支付信息").head(PaymentInfo.class).build();
            //向sheet1写入数据 传入空list这样只导出表头
            excelWriter.write(Lists.newArrayList(),detailSheet);
            //关闭流
            excelWriter.finish();
        } catch (IOException e) {
            log.error("导出异常{}", e.getMessage());
        }
//        ExcelUtil.
    }
}
