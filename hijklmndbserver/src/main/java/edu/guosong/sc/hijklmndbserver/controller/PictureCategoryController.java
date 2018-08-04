package edu.guosong.sc.hijklmndbserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.guosong.sc.hijklmncommon.dto.PictureCategoryDTO;
import edu.guosong.sc.hijklmncommon.dto.RequestResult;
import edu.guosong.sc.hijklmncommon.param.WebOption;
import edu.guosong.sc.hijklmncommon.po.PictureCategory;
import edu.guosong.sc.hijklmncommon.util.JSONUtil;
import edu.guosong.sc.hijklmndbserver.common.ControllerHandler;
import edu.guosong.sc.hijklmndbserver.service.IPictureCategoryService;

@RestController
@RequestMapping("/picture")
public class PictureCategoryController {

	@Autowired
	private IPictureCategoryService pictureCategoryService;

	@RequestMapping(value = "/viewPictureCategory", method = RequestMethod.POST)
	public RequestResult viewPictureCategory(@RequestBody PictureCategoryDTO pictureCategoryDTO) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) {
				requestResult.put(WebOption.ITEMS,
						JSONUtil.bean2Str(pictureCategoryService.queryPictureCategoryList(pictureCategoryDTO)));
			}
		});
	}

	@RequestMapping(value = "/addPictureCategory", method = RequestMethod.POST)
	public RequestResult addPictureCategory(@RequestBody PictureCategory pictureCategory) {
		return ControllerProxy.handler(new ControllerHandler() {

			@Override
			public void assemble(RequestResult requestResult) {
				PictureCategoryDTO pictureCategoryDTO = new PictureCategoryDTO();
				pictureCategoryDTO.setCategoryName(pictureCategory.getCategoryName());
				List<PictureCategory> pictureCategorys = pictureCategoryService
						.queryPictureCategoryList(pictureCategoryDTO);
				if (pictureCategorys != null && pictureCategorys.size() > 0) {
					requestResult.put(WebOption.RESULT, 0);
					return;
				}
				requestResult.put(WebOption.RESULT, pictureCategoryService.addPictureCategory(pictureCategory));
			}
		});
	}

	@RequestMapping(value = "/deletePictureCategory", method = RequestMethod.POST)
	public RequestResult deletePictureCategory(@RequestParam("categoryId") Integer categoryId) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) {
				requestResult.put(WebOption.RESULT, pictureCategoryService.deletePictureCategory(categoryId));
			}
		});
	}

	@RequestMapping(value = "/updatePictureCategory", method = RequestMethod.POST)
	public RequestResult updatePictureCategory(@RequestBody PictureCategory pictureCategory) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) {
				requestResult.put(WebOption.RESULT, pictureCategoryService.updatePictureCategory(pictureCategory));
			}
		});
	}

	@RequestMapping(value = "/increasePictureCategoryPictureNumber", method = RequestMethod.POST)
	public RequestResult increasePictureCategoryPictureNumber(@RequestParam("categoryId") int categoryId,
			@RequestParam("pictureNumber") int pictureNumber) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) {
				PictureCategory pictureCategory = new PictureCategory();
				pictureCategory.setCategoryId(categoryId);
				if (pictureNumber < 1) {
					pictureCategory.setPictureNumber(1);
				} else {
					pictureCategory.setPictureNumber(pictureNumber);
				}
				requestResult.put(WebOption.RESULT,
						pictureCategoryService.increasePictureCategoryPictureNumber(pictureCategory));
			}
		});
	}

	@RequestMapping(value = "/discreasePictureCategoryPictureNumber", method = RequestMethod.POST)
	public RequestResult discreasePictureCategoryPictureNumber(@RequestParam("categoryId") int categoryId,
			@RequestParam("pictureNumber") int pictureNumber) {
		return ControllerProxy.handler(new ControllerHandler() {
			@Override
			public void assemble(RequestResult requestResult) {
				PictureCategory pictureCategory = new PictureCategory();
				pictureCategory.setCategoryId(categoryId);
				if (pictureNumber < 1) {
					pictureCategory.setPictureNumber(1);
				} else {
					pictureCategory.setPictureNumber(pictureNumber);
				}
				requestResult.put(WebOption.RESULT,
						pictureCategoryService.discreasePictureCategoryPictureNumber(pictureCategory));
			}
		});
	}

}
