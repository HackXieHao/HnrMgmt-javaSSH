package com.hackerxiehao.hnrmgmt.handler;

import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.hackerxiehao.hnrmgmt.entities.ApiResult;
import com.hackerxiehao.hnrmgmt.entities.Award;
import com.hackerxiehao.hnrmgmt.entities.ReturnData;
import com.hackerxiehao.hnrmgmt.service.AwardService;
import com.hackerxiehao.hnrmgmt.util.ApiResultUtils;

@RequestMapping("/award/")
@Controller
public class AwardHandler {

	private AwardService awardService = new AwardService();

	@ResponseBody
	@RequestMapping(value = "modify", method = RequestMethod.POST)
	public ApiResult testModifyAward(@RequestBody Award award) {
		// System.out.println(award);
		Award awardModel = awardService.get(award.getAwdID());
		if (awardModel != null) {
			try {
				awardService.modify(award);
				return ApiResultUtils.success("修改成功");
			} catch (Exception e) {
				return ApiResultUtils.error("修改失败，请检查参数是否正确");
			}
		} else {
			return ApiResultUtils.error("数据库中不存在此条记录");
		}
	}

	@ResponseBody
	@RequestMapping("delete")
	public ApiResult testDeleteAward(@RequestParam(value = "awdID") String awdID) {
		// System.out.println(awdID);
		// 参数验证
		if (awdID == null || awdID == "") {
			Map<String, String> fieldErrors = new HashMap<String, String>();
			fieldErrors.put("awdID", "awdID");
			return ApiResultUtils.error("参数格式错误", fieldErrors);
		}
		Award awardModel = awardService.get(awdID);
		if (awardModel == null) {
			return ApiResultUtils.error("数据库中没有此条记录，删除失败");
		} else {
			try {
				awardService.delete(awdID);
				return ApiResultUtils.success("删除成功");
			} catch (Exception e) {
				return ApiResultUtils.error("出现异常，删除失败");
			}
		}

	}

	/**
	 * 增加一条记录，记录为从前台传入的json数据
	 * 
	 * @param award
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ApiResult testAddAward(@RequestBody Award award) {
		// System.out.println(award);
		// System.out.println(award.getName());

		Award awardModel = awardService.get(award.getAwdID());
		System.out.println(awardModel);
		if (awardModel != null) {
			return ApiResultUtils.error("该条记录已存在");
		} else {
			try {
				// System.out.println(award);
				awardService.save(award);
				return ApiResultUtils.success("添加成功");
			} catch (Exception e) {
				return ApiResultUtils.error("添加失败，请检查参数是否正确");
			}
		}
	}

	/**
	 * 获取所有记录，并封装后返回json对象
	 * 
	 * @return
	 */
	@ResponseBody
	@RequestMapping("get")
	public ApiResult testGetAward() {
		ApiResult apiResult = new ApiResult();
		// Award award = awardService.get(id);
		List<Award> list = awardService.getAll();
		ReturnData<Award> returnData = new ReturnData<Award>();
		if (list != null) {
			returnData.setCount(list.size());
			returnData.setList(list);
			// apiResult.setData(returnData);
			return ApiResultUtils.success("获取数据成功", returnData);
		}
		return apiResult;
	}

}
