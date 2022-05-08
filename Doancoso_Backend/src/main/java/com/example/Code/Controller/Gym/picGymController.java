package com.example.Code.Controller.Gym;

import com.example.Code.Entity.Gym.gym;
import com.example.Code.Entity.Gym.picGym;
import com.example.Code.Model.Uploader;
import com.example.Code.Service.Gym.gymService;
import com.example.Code.Service.Gym.picGymService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
public class picGymController {

    @Autowired
    private picGymService picGymService;

    @Autowired
    private gymService _gymService;

    @PostMapping("/admin/picGym/save")
    private void save(
            @RequestParam("gifFile") MultipartFile gifFile,
            @RequestParam("gymId") int gymId
    ) throws IOException {
        picGym picGym = new picGym();
        Uploader uploader = new Uploader();
        gym gym = _gymService.findGymById(gymId);
        picGym.setGym(gym);
        picGym.setImg(uploader.uploadFile(gifFile));
        picGymService.save(picGym);
    }

    @GetMapping("/client/picGym/getByGym")
    public List<picGym> getByGym(int id){
        return picGymService.getByGym(id);
    }


}
