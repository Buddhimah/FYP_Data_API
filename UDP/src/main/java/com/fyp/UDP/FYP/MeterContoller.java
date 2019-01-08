package com.fyp.UDP.FYP;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(Receiver.class);
    @Autowired
    private  MeterRepository meterRepository;
    @RequestMapping(value="{id}",method = RequestMethod.GET)
    public MeterData getData(@PathVariable Integer id){
        try {

            return meterRepository.findById(id).get();
        }catch (Exception e){
            logger.info("ID not available in the database");
            return new MeterData();

        }

    }

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
