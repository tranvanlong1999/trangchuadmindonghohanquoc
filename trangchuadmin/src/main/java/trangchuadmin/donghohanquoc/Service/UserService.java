package trangchuadmin.donghohanquoc.Service;
import org.springframework.stereotype.Service;
import trangchuadmin.donghohanquoc.Model.Output.UserOutput;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public interface UserService {
    /*ResponseData<Boolean> createUserByAdmin(UserInput userInput);*/
    /*UserOutput checkLogin(LoginInput loginInput);*//*

    ResponseData<List<UserOutput>> getListUser();
    ResponseData<Boolean> deleteUserById(Integer id);
    ResponseData<Boolean> updateUserByAdmin(UserUpdateInput userUpdateInput);*/
    /*String login(Model model, HttpSession session, HttpServletResponse response, LoginInput userForm);
    String register(Model model, UserInput userInput);*/
    List<UserOutput> getListUser();
   /* String pageLogout(Model model, HttpSession session, HttpServletResponse response);*/

}
