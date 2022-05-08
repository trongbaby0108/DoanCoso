package com.example.Code.Controller.Gym;

import com.example.Code.Entity.Gym.gym;
import com.example.Code.Model.Uploader;
import com.example.Code.Service.Gym.gymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/admin/gym")
public class gymController {
    @Autowired
    private gymService _gymService;

    @GetMapping("/getAll")
    public List<gym> getAll(){
        return _gymService.getAll();
    }

    @PostMapping("/addGym")
    public HttpStatus save(@RequestParam("img") MultipartFile img ,
                           @RequestParam("email") String email ,
                           @RequestParam("address") String address ,
                           @RequestParam("name") String name ,
                           @RequestParam("phone") String phone ){
        gym gym = new gym();
        Uploader uploader = new Uploader();
        gym.setAddress(address);
        gym.setEmail(email);
        gym.setName(name);
        gym.setPhone(phone);
        gym.setAvatar(uploader.uploadFile(img));
        _gymService.signNewGym(gym);
        return HttpStatus.OK;
    }
}
