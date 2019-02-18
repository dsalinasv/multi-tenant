/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import server.system.domain.ClimData;
import server.system.persistence.ClimDataRepo;

@RestController
@RequestMapping("/climDataService")
public class ClimDataRest {
    
    @Autowired
    public ClimDataRepo repo;
    
    @GetMapping("/{year}")
    public Iterable<ClimData> getByYear(@PathVariable String year, 
            @RequestHeader String tenantId) {
        return repo.getByYear(year);
    }
    
    @PostMapping
    public void save(@RequestBody ClimData entity, @RequestHeader String tenantId) {
        repo.save(entity);
    }
    
}
