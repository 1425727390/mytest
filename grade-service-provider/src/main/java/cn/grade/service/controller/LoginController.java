package cn.grade.service.controller;

import cn.grade.service.entity.R;
import org.springframework.web.bind.annotation.*;

/**
 * @program: pig
 * @description:
 * @author: Mr.mo
 * @create: 2020-06-30 20:07
 **/


@RestController
@RequestMapping("/user")
@CrossOrigin
public class LoginController {

	@PostMapping("login")
	public R login() {
		System.out.println("登录成功");
		return R.ok().data("token","admin");
	}

	@GetMapping("info")
	public R info() {
		System.out.println("成功信息");
		return R.ok().data("roles","[管理员]").data("name","莫德文").data("avatar","https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1592987322042&di=4591813a30be138872598aa4e73feabf&imgtype=0&src=http%3A%2F%2Fp2.so.qhimgs1.com%2Ft01dfcbc38578dac4c2.jpg");
	}


}
