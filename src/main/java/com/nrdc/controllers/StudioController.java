package com.nrdc.controllers;

import com.nrdc.entities.Studio;
import com.nrdc.services.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/studios")
public class StudioController {
    private StudioService service;

    @Autowired
    public void setService(StudioService service) {
        this.service = service;
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
    public Page<Studio> index( @RequestParam(name = "page", required = false, defaultValue = "0") int page ) {
        return this.service.findAll(page);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.GET)
    public Studio show(@PathVariable int id) {
        return this.service.findOne(id);
    }

    @RequestMapping(path = {"", "/"}, method = RequestMethod.POST)
    public Studio create(@RequestBody Studio studio) {
        return this.service.create(studio);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.DELETE)
    public void destroy(@PathVariable int id) {
        this.service.destroy(id);
    }

    @RequestMapping(path = {"/{id}"}, method = RequestMethod.PUT)
    public Studio update(@PathVariable int id, @RequestBody Studio studio) {
        return this.service.update(id, studio);
    }
}
