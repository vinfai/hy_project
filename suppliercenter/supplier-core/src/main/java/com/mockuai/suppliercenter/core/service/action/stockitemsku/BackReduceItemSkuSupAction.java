package com.mockuai.suppliercenter.core.service.action.stockitemsku;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.mockuai.suppliercenter.common.action.ActionEnum;
import com.mockuai.suppliercenter.common.api.SupplierResponse;
import com.mockuai.suppliercenter.common.constant.ResponseCode;
import com.mockuai.suppliercenter.common.dto.OrderStockDTO;
import com.mockuai.suppliercenter.core.exception.SupplierException;
import com.mockuai.suppliercenter.core.manager.SupplierOrderStockManager;
import com.mockuai.suppliercenter.core.service.RequestContext;
import com.mockuai.suppliercenter.core.service.SupplierRequest;
import com.mockuai.suppliercenter.core.service.action.TransAction;

/**
 * Created by csy on 2016/9/26
 * 
 * 退货退款实现反扣
 */

@Service
public class BackReduceItemSkuSupAction extends TransAction {
    private static final Logger log = LoggerFactory.getLogger(BackReduceItemSkuSupAction.class);

    @Resource
    private SupplierOrderStockManager supplierOrderStockManager;

    @SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
    protected SupplierResponse doTransaction(RequestContext context) throws SupplierException {
        SupplierRequest supplierRequest = context.getRequest();
        String bizCode = (String) supplierRequest.getParam("bizCode");
        OrderStockDTO orderStockDTO = (OrderStockDTO) supplierRequest.getObject("orderStockDTO");
        
        if (orderStockDTO == null) {
            return new SupplierResponse(ResponseCode.P_PARAM_NULL, "orderStockDTO is missing");
        }       

        log.info("退货退款实现反扣 BackReduceItemSkuSupAction orderStockDTO:{} ", JSON.toJSON(orderStockDTO));       
        
        try {
            orderStockDTO = supplierOrderStockManager.backReduceItemSkuSup(orderStockDTO,bizCode);

            return new SupplierResponse(orderStockDTO);
        }catch (SupplierException e) {
            log.error("do action:" + supplierRequest.getCommand()+"occur Exception:"+e.getMessage(), e);
            return new SupplierResponse(e.getResponseCode(), e.getMessage());

        }
    }

    @Override
    public String getName() {
        return ActionEnum.BACKREDUCE_ITEM_SKU_SUP.getActionName();
    }
}
