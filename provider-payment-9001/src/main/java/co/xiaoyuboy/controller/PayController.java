package co.xiaoyuboy.controller;


import co.xiaoyuboy.entities.Pay;
import co.xiaoyuboy.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @auther Smile
 * @create 2024-05-24 17:34
 */
@RestController
@Slf4j
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController
{
    @Resource
    private PayService payService;

    @PostMapping(value = "/pay/add")
    @Operation(summary = "新增",description = "新增支付流水方法,json串做参数")
    public String addPay(@RequestBody Pay pay)
    {
       log.info(pay.toString());
        int i = payService.add(pay);
        return "成功插入记录，返回值: " + i;
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public Integer deletePay(@PathVariable("id") Integer id)
    {
        return payService.delete(id);
    }

    @Operation(summary = "查询流水",description = "查询全部的流水")
   @GetMapping(value = "/pay/get/all")
    public List<Pay> getAllPay(){
        return payService.getAll();
    }


}
