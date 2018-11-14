package com.fyp.UDP.FYP;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by Buddhima on 11/13/2018.
 */
@Controller
@RequestMapping(path ="/meter")
@ResponseBody
public class MeterContoller {
    @Autowired
    private  MeterRepository meterRepository;

    @RequestMapping(value="/add", method = RequestMethod.POST)
   public boolean addData(@RequestBody MeterData m){
       MeterData meterData = new MeterData();
       meterData.setId(m.getId());
       meterData.setData(m.getData());
       meterRepository.save(meterData);
       return true;
   }

   @GetMapping(path="/all")
    public Iterable<MeterData> getAllData(){
       return meterRepository.findAll();
   }
}
