/*
 *      Copyright (c) 2018-2028, Chill Zhuang All rights reserved.
 *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice,
 *  this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright
 *  notice, this list of conditions and the following disclaimer in the
 *  documentation and/or other materials provided with the distribution.
 *  Neither the name of the dreamlu.net developer nor the names of its
 *  contributors may be used to endorse or promote products derived from
 *  this software without specific prior written permission.
 *  Author: Chill 庄骞 (smallchill@163.com)
 */
package com.mh.springcloud.excel;

import com.mh.springcloud.entities.Payment;
import com.mh.springcloud.util.support.ExcelImporter;
import lombok.RequiredArgsConstructor;

import java.util.List;

/**
 * 用户数据导入类
 *
 * @author Chill
 */
@RequiredArgsConstructor
public class UserImporter implements ExcelImporter<Payment> {

//	private final IUserService service;
	private final Boolean isCovered;

	@Override
	public void save(List<Payment> data) {
		/**
		 * 批量插入数据的方法
		 */
//		service.importUser(data);
	}
}
