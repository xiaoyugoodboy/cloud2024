package co.xiaoyuboy.controller;
import co.xiaoyuboy.entities.Pay;
import co.xiaoyuboy.entities.PayDTO;
import co.xiaoyuboy.resp.ResultData;
import co.xiaoyuboy.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
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
    public ResultData<String> addPay(@RequestBody Pay pay)
    {
       log.info(pay.toString());
        int i = payService.add(pay);
        return ResultData.success("成功插入记录，返回值: " + i);
    }
    @GetMapping(value = "/pay/get/{id}")
    @Operation(summary = "查询",description = "根据id查询支付流水")
    public ResultData<Pay> getPay(@PathVariable("id") Integer id)
    {
        if (id==-1){throw new RuntimeException("id不能是-1");}
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }

    @DeleteMapping(value = "/pay/del/{id}")
    @Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id)
    {
        return ResultData.success(payService.delete(id)) ;
    }

    @Operation(summary = "查询流水",description = "查询全部的流水")
   @GetMapping(value = "/pay/get/all")
    public ResultData<List<Pay>> getAllPay(){

        return ResultData.success(payService.getAll());
    }
    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO){
        Pay pay = new Pay();
        BeanUtils.copyProperties(payDTO,pay);
        int i = payService.update(pay);
        return ResultData.success("成功修改记录，返回值是:"+i);
    }


}
