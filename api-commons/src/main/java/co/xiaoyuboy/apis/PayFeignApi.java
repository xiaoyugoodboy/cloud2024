package co.xiaoyuboy.apis;

import co.xiaoyuboy.entities.PayDTO;
import co.xiaoyuboy.resp.ResultData;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "provider-payment")
public interface PayFeignApi {
    /**
     * 新增支付流水方法,json串做参数
     * @param pay
     * @return
     */
    @PostMapping(value = "/pay/add")
    public ResultData<String> addPay(@RequestBody PayDTO pay);

    /**
     * 根据id查询支付流
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/get/{id}")
    public ResultData getPay(@PathVariable("id") Integer id);


    /**
     * 删除支付流水方法
     * @param id
     * @return
     */
    @DeleteMapping(value = "/pay/del/{id}")
    public ResultData<Integer> deletePay(@PathVariable("id") Integer id);

    /**
     * 查询全部的流水
     * @return
     */
    @Operation(summary = "查询流水",description = "查询全部的流水")
    @GetMapping(value = "/pay/get/all")
    public ResultData<List> getAllPay();

    /**
     * 修改支付流水
     * @param payDTO
     * @return
     */
    @PutMapping(value = "/pay/update")
    @Operation(summary = "修改",description = "修改支付流水")
    public ResultData<String> updatePay(@RequestBody PayDTO payDTO);

    /**
     * 测试负载均衡的方法
     * @return
     */
    @GetMapping("/pay/info")
    public ResultData<String> getInfo();
}
