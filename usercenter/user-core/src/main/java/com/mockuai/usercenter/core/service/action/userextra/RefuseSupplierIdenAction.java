//package com.mockuai.usercenter.core.service.action.userextra;
//
//import javax.annotation.Resource;
//
//import org.springframework.stereotype.Service;
//
//import com.mockuai.usercenter.common.action.ActionEnum;
//import com.mockuai.usercenter.common.api.UserResponse;
//import com.mockuai.usercenter.core.exception.UserException;
//import com.mockuai.usercenter.core.employee.SupplierExtraInfoManager;
//import com.mockuai.usercenter.core.service.RequestContext;
//import com.mockuai.usercenter.core.service.UserRequest;
//import com.mockuai.usercenter.core.service.action.Action;
//
///**
// * 供应商的审核失败
// * */
//@Service
//public class RefuseSupplierIdenAction implements Action {
//
//	@Resource
//	private SupplierExtraInfoManager supplierExtraManager;
//
//	@Override
//	public UserResponse execute(RequestContext context) throws UserException {
//
//		UserRequest userRequest = context.getRequest();
//		Long userId = (Long) userRequest.getParam("userId");
//
//		supplierExtraManager.refuseSupplierIden(userId);
//
//		return new UserResponse(true);
//	}
//
//	@Override
//	public String getName() {
//		// TODO Auto-generated method stub
//		return ActionEnum.SUPPLIER_FAIL_IDENTIFIED_ACTION.getActionName();
//	}
//
//}
