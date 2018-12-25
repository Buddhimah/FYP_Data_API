package com.fyp.UDP.FYP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Buddhima on 11/13/2018.
 */
@Controller
@CrossOrigin(origins = {"http://localhost:8081","*"})
@RequestMapping(path ="/meter")
@ResponseBody
public class MeterContoller {
    @Autowired
    private  MeterRepository meterRepository;

    @RequestMapping(value="/add", method = RequestMethod.POST)
   public boolean addData(@RequestBody MeterData m){
        Date date = new Date();
        Timestamp ts = new Timestamp(date.getTime());
       MeterData meterData = new MeterData();
       meterData.setId(m.getId());
       meterData.setData(m.getData());
       meterData.setTime(ts);
       meterRepository.save(meterData);
       return true;
   }

   @GetMapping(path="/all")
    public Iterable<MeterData> getAllData(){
       return meterRepository.findAll();
   }
}
