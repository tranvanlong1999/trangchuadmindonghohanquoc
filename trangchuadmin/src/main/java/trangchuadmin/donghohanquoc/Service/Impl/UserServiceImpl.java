package trangchuadmin.donghohanquoc.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import trangchuadmin.donghohanquoc.Converter.UserConverter;
import trangchuadmin.donghohanquoc.Model.Entity.UserEntity;
import trangchuadmin.donghohanquoc.Model.Output.UserOutput;
import trangchuadmin.donghohanquoc.Repository.UserRepository;
import trangchuadmin.donghohanquoc.Service.UserService;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserConverter userConverter;


    @Override
    public List<UserOutput>  getListUser() {
        List<UserOutput> userOutputList= new LinkedList<>();
        try {
            List<UserEntity> userEntityList= userRepository.findAll();
            for (UserEntity userEntity:userEntityList) {
                userOutputList.add(new UserConverter().toUserEntity(userEntity));
            }
        } catch (Exception e) {
        }
        return  userOutputList;
    }

    /*@Override
    public String pageLogout(Model model, HttpSession session, HttpServletResponse response) {
        session.removeAttribute("user");
        model.addAttribute("error", null);
        // remove a cookie email
        Cookie cookieEmail = new Cookie("email", null);
        cookieEmail.setMaxAge(0); // expires in 7 days

        // remove a cookie password
        Cookie cookiePassword = new Cookie("password", null);
        cookiePassword.setMaxAge(0); // expires in 7 days

        // remove a cookie remember
        Cookie cookieRemember = new Cookie("remember", null);
        cookieRemember.setMaxAge(0); // expires in 7 days

        // add cookie to response
        response.addCookie(cookieEmail);
        response.addCookie(cookiePassword);
        response.addCookie(cookieRemember);

        return "redirect:/dang-nhap";
    }*/


    /* @Override*/
   /* public ResponseData<Boolean> deleteUserById(Integer id) {
        ResponseData<Boolean> responseData= new ResponseData<>();
        try
        {
            // get user by ID
            UserEntity userEntity= userRepository.findByID(id);
            if(ObjectUtils.isEmpty(userEntity))
            {
                throw new Exception();
            }
            userRepository.delete(userEntity);
            responseData.setCode(ResCode.SUCCESS.getCode());
            responseData.setMessage(ResCode.SUCCESS.getMessage());
            responseData.setData(true);

        } catch (Exception e) {
            responseData.setCode(ResCode.UNKNOWN_ERROR.getCode());
            responseData.setMessage(ResCode.UNKNOWN_ERROR.getMessage());
            responseData.setData(false);
        }
        return responseData;
    }*/

   /* @Override*/
    /*public ResponseData<Boolean> updateUserByAdmin(UserUpdateInput userUpdateInput) {
        ResponseData<Boolean> responseData= new ResponseData<>();
        try
        {
            // get user từ user ID
            UserEntity userEntity = userRepository.findByID(userUpdateInput.getId());
            boolean checkPassWordIsEmpty= false;
            if(userUpdateInput.getPassword().isEmpty())
                checkPassWordIsEmpty=true;
            // case email không tồn tại trong hệ thống
            if(ObjectUtils.isEmpty(userEntity))
            {
                throw new CustomException(Constants.ERROR_CODE,"user không tồn tại trong hệ thống");
            }
            // case email đã có trong hệ thống
            if(!ObjectUtils.isEmpty(userRepository.findByEmailAndIDNot(userUpdateInput.getEmail(),userUpdateInput.getId())))
            {
                throw new CustomException(Constants.ERROR_CODE,"Email tồn tại trong hệ thống");
            }
            if(checkPassWordIsEmpty==false && !BCrypt.checkpw(userUpdateInput.getPassword(),userEntity.getPassWord()))
            {
                throw new CustomException(Constants.ERROR_CODE,"Mật khẩu cũ không chính xác");
            }
            // save user vào database
            userEntity = userRepository.save(userConverter.toUserUpdateInput(userUpdateInput));
            // set data response
            responseData.setCode(ResCode.SUCCESS.getCode());
            responseData.setMessage(ResCode.SUCCESS.getMessage());
            responseData.setData(true);

        } catch (CustomException e) {
            responseData.setCode(e.getErrorCode());
            responseData.setMessage(e.getMessage());
            responseData.setData(false);
        }catch (Exception e)
        {
            responseData.setCode(ResCode.UNKNOWN_ERROR.getCode());
            responseData.setMessage(ResCode.UNKNOWN_ERROR.getMessage());
            responseData.setData(false);
        }
        return responseData;
    }*/

    /*@Override
    public String login(Model model, HttpSession session, HttpServletResponse response, LoginInput userForm) {
        String result = PageConstant.PAGE_LOGIN;
        String message = null;
        try {
            if (Validate.checkLogin(userForm)) {
                UserEntity user = userRepository.findByEmailAndPassWord(userForm.getEmail(),userForm.getPassword());

                if (ObjectUtils.isEmpty(user)) {
                    message = MessageConstant.LOGIN_ERROR;
                } else {
                    if (userForm.isRemember()) {
                        // create a cookie email
                        Cookie cookieEmail = new Cookie("email", user.getUserName());
                        cookieEmail.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days

                        // create a cookie password
                        Cookie cookiePassword = new Cookie("password", user.getPassWord());
                        cookiePassword.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days

                        // remove a cookie remember
                        Cookie cookieRemember = new Cookie("remember", "" + userForm.isRemember());
                        cookieRemember.setMaxAge(7 * 24 * 60 * 60); // expires in 7 days

                        // add cookie to response
                        response.addCookie(cookieEmail);
                        response.addCookie(cookiePassword);
                        response.addCookie(cookieRemember);
                    } else {
                        // remove a cookie email
                        Cookie cookieEmail = new Cookie("email", null);
                        cookieEmail.setMaxAge(0); // expires in 7 days

                        // remove a cookie password
                        Cookie cookiePassword = new Cookie("password", null);
                        cookiePassword.setMaxAge(0); // expires in 7 days

                        // remove a cookie remember
                        Cookie cookieRemember = new Cookie("remember", null);
                        cookieRemember.setMaxAge(0); // expires in 7 days

                        // add cookie to response
                        response.addCookie(cookieEmail);
                        response.addCookie(cookiePassword);
                        response.addCookie(cookieRemember);
                    }
                    // save session
                    session.setAttribute("user", user);
                    session.setAttribute("email",user.getEmail());
                    result= "redirect:/home";
                }
            } else {
                message = MessageConstant.LOGIN_ERROR;
            }
            } catch (Exception e) {
            message = MessageConstant.LOGIN_ERROR;
        }

        model.addAttribute("error", message);
        return result;
    }*/

    /*@Transactional(rollbackOn = Exception.class)
    @Override
    public String register(Model model, UserInput userInput) {

        String result = PageConstant.PAGE_REGISTER;
        String error = null;
        UserEntity user = null;
        userInput.setUsername(userInput.getEmail());
        System.out.println(userInput);
        try {
            // step 1: validate
            if (Validate.checkRegister(userInput)) {
                // step 2: check email exists
                if (ObjectUtils.isEmpty(userRepository.findByUserName(userInput.getEmail()))) {
                    // convert from register input to user entity
                    user = userConverter.toUserInput(userInput);
                    user.setStatus(Constant.STATUS_ENABLE);

//					user.setPassword(BCrypt.hashpw(userInput.getPassword(), BCrypt.gensalt(12)));

                    // step 3: save
                    userRepository.save(user);

                    // step 4: redirect page login
                    result = "redirect:/dang-nhap";
                } else {
                    error = MessageConstant.RIGISTER_ERROR;
                }
            } else {
                error = MessageConstant.RIGISTER_ERROR;
            }
        } catch (Exception e) {
            error = MessageConstant.RIGISTER_ERROR;
        }
        model.addAttribute("error", error);
        return result;
    }*/


}


