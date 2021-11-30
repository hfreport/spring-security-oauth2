package com.example.security.controller;

import com.example.security.bo.OauthClientInfoBO;
import com.example.security.service.ManagerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author hf
 * date   2021/11/30 14:15
 * description
 */
@Controller
public class ManagerController {

    @Resource
    private ManagerService managerService;

    @GetMapping("/index")
    public String index(Model model) {
        List<OauthClientInfoBO> appList = managerService.queryClientInfoList();
        model.addAttribute("appList", appList);
        model.addAttribute("view", "app/appList");
        return "fragment/layout";
    }

    @GetMapping("/index1")
    public String index1(Model model) {
        model.addAttribute("view", "app/index");
        return "fragment2/layout";
    }

    @GetMapping("/app/detail/{client_id}")
    public String appDetail(@PathVariable("client_id")String clientId,  Model model) {
        OauthClientInfoBO app = managerService.queryClientInfoByClientId(clientId);
        model.addAttribute("app", app);
        model.addAttribute("view", "app/appDetail");
        return "fragment2/layout";
    }


}
