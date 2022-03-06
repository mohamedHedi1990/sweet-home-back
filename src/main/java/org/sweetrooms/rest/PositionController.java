package org.sweetrooms.rest;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.PositionService;
import org.sweetrooms.business.services.RoleService;
import org.sweetrooms.persistence.entities.Position;
import org.sweetrooms.persistence.entities.Role;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/position")
@Api(value = "Restfull APIs for positions")
public class PositionController {
    @Autowired
    PositionService positionService;
    @GetMapping("")
    public List<Position> getAllPositions()
    {
        return this.positionService.getAllPositions();
    }
    @GetMapping("/{id}")
    public Position getPositionById(@PathVariable(name = "id") Long id)
    {
        return this.positionService.getPositionById(id);
    }
    @PostMapping("")
    public Position savePosition(Position position)
    {
        return this.positionService.savePosition(position);
    }
    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable(name = "id")Long id)
    {
        this.positionService.deletePosition(id);
    }
}
