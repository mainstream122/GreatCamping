package com.ktds.camp.menu.web;

import com.ktds.camp.menu.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {

    private MenuService menuService;

    public void setMenuService(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping("/menu/all")
    public ModelAndView viewAllMenu() {
        ModelAndView view = new ModelAndView();
        view.setViewName("common/header/menu");
        view.addObject("menuList", menuService.getVisibleMenu());
        return view;
    }
    @RequestMapping("/map/CampingVideo")
    public String videoMenu() {

    	return "camp/map/CampingVideo";
    }

}
