package trangchuadmin.donghohanquoc.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import trangchuadmin.donghohanquoc.Common.PageConstant;
import trangchuadmin.donghohanquoc.Model.Output.UserOutput;
import trangchuadmin.donghohanquoc.Service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
     @Autowired
     private UserService userService;

     @GetMapping
     public String getListUser(Model model)
     {
          List<UserOutput> userOutputList=userService.getListUser();
          model.addAttribute("danhsachtaikhoan",userOutputList );
          return PageConstant.PAGE_QUANLYTAIKHOAN;
     }
}
