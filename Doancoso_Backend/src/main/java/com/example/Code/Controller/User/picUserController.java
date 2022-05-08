package com.example.Code.Controller.User;

import com.example.Code.Entity.Gym.gym;
import com.example.Code.Entity.Gym.picGym;
import com.example.Code.Entity.User.picUser;
import com.example.Code.Entity.User.user;
import com.example.Code.Model.Uploader;
import com.example.Code.Service.User.picUserService;
import com.example.Code.Service.User.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/user/pics")
public class picUserController {
    @Autowired
    private picUserService picUserService;

    @Autowired
    private userService userService;

    @PostMapping("/save")
    private void save(@RequestParam("gifFile") MultipartFile gifFile, @RequestParam("username") String username) throws IOException {
        picUser picUser = new picUser();
        Uploader uploader = new Uploader();
        user user = userService.findByUserName(username);
        System.out.println(user.toString());
        picUser.setUser(user);
        picUser.setImg(uploader.uploadFile(gifFile));
        picUserService.save(picUser);
    }

    @GetMapping("/getByUser")
    private List<picUser> getByUser(@RequestParam("username") String  username){
        return picUserService.findByUser(username);
    }
}
