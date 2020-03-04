package com.asgard.controller;

import com.asgard.pojo.User;
import com.asgard.service.IUserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class UserController {

    //test修改

    @Autowired
    private IUserService service;

    @RequestMapping("goShow")
    public String goShow(){
        return "show";
    }

    @RequestMapping("page")
    @ResponseBody
    public PageInfo page2(@RequestParam(value="page",defaultValue="1") int currentPage,
                          @RequestParam(value="rows",defaultValue="2")int pageSize,String key){
        //1
        PageHelper.startPage(currentPage, pageSize);


        List<User> list = null;
        //2
        if(key==null){
            list = service.selectAllUser();

        }else{
            list = service.selectUserByName(key);
        }

        //3
        PageInfo<User> pageInfo = new PageInfo<User>(list);

		/*Page page = new Page();
		page.setTotal(pageInfo.getTotal());
		page.setRows(pageInfo.getList());*/

        return pageInfo;
    }

    @RequestMapping("goAdd")
    public String goAdd(){
        System.out.println("--goadd--");
        return "add";
    }

    @RequestMapping("insertUser")
    @ResponseBody
    public String insertUser(@RequestBody User user){
        System.out.println(user);
        service.insertUser(user);
        return "true";
    }

    @RequestMapping("goUpdate")
    @ResponseBody
    public User goUpdate(int id){
        User user = service.doUpdate(id);
        return user;
    }

    @RequestMapping("update")
    @ResponseBody
    public String update(@RequestBody User user){
        System.out.println(user);
        service.updateUser(user);
        return "true";
    }

    @RequestMapping("delete")
    @ResponseBody
    public String delete(int[] ids){
        System.out.println(Arrays.toString(ids));
        for (int i = 0; i < ids.length; i++) {
            service.deleteUser(ids[i]);
        }
        return "delete";
    }
}
