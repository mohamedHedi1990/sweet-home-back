package org.sweetrooms.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.sweetrooms.business.services.PositionService;
import org.sweetrooms.persistence.entities.Position;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/position")
@Tag(description = "Restfull APIs for Position",name = "Posistion ressource")
public class PositionController {
    @Autowired
    PositionService positionService;
    @Operation(summary = "Get positions",
            description = "Provides all available positions list")
    @GetMapping("")
    public List<Position> getAllPositions()
    {
        return this.positionService.getAllPositions();
    }
    @Operation(summary = "Get position",
            description = "Provides specific position by ID")
    @GetMapping("/{id}")
    public Position getPositionById(@PathVariable(name = "id") Long id)
    {
        return this.positionService.getPositionById(id);
    }
    @Operation(summary = "save position",
            description = "save a new position")
    @PostMapping("")
    public Position savePosition(Position position)
    {
        return this.positionService.savePosition(position);
    }
    @Operation(summary = "Delete position",
            description = "Delete specific position By ID")
    @DeleteMapping("/{id}")
    public void deletePosition(@PathVariable(name = "id")Long id)
    {
        this.positionService.deletePosition(id);
    }
}
