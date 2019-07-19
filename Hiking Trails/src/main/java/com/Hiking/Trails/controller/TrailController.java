package com.Hiking.Trails.controller;

import com.Hiking.Trails.model.Trail;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class TrailController {

    @RequestMapping(value = "trails", method = RequestMethod.GET)
    public List<Trail> list(){
        return TrailStub.list();
    }

    @RequestMapping(value = "trails", method = RequestMethod.POST)
    public Trail create(@RequestBody Trail trail){
        return TrailStub.create(trail);
    }

    @RequestMapping(value = "trails/{id}", method = RequestMethod.GET)
    public Trail get(@PathVariable Long id){
        return TrailStub.get(id);
    }

    @RequestMapping(value = "trails/{id}", method = RequestMethod.PUT)
    public Trail update(@PathVariable Long id, @RequestBody Trail trail){
        return TrailStub.update(id, trail);
    }

    @RequestMapping(value = "trails/{id}", method = RequestMethod.DELETE)
    public Trail delete(@PathVariable Long id){
        return TrailStub.delete(id);
    }
}
