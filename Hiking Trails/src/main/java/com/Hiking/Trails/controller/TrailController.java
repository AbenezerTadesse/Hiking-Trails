package com.Hiking.Trails.controller;

import com.Hiking.Trails.model.Trail;
import com.Hiking.Trails.repository.TrailRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class TrailController {

    @Autowired
    private TrailRepository trailRepository;

    @RequestMapping(value = "trails", method = RequestMethod.GET)
    public List<Trail> list(){
        return trailRepository.findAll();
    }

    @RequestMapping(value = "trails", method = RequestMethod.POST)
    public Trail create(@RequestBody Trail trail){
        return trailRepository.saveAndFlush(trail);
    }

    @RequestMapping(value = "trails/{id}", method = RequestMethod.GET)
    public Optional<Trail> get(@PathVariable Long id){
        return trailRepository.findById(id);
    }

    @RequestMapping(value = "trails/{id}", method = RequestMethod.PUT)
    public Trail update(@PathVariable Long id, @RequestBody Trail trail){
        Trail existingTrail = trailRepository.getOne(id);
        BeanUtils.copyProperties(trail, existingTrail);
        return trailRepository.saveAndFlush(existingTrail);
    }

    @RequestMapping(value = "trails/{id}", method = RequestMethod.DELETE)
    public Optional <Trail> delete(@PathVariable Long id){
        trailRepository.deleteById(id);
        return trailRepository.findById(id);
    }
}
