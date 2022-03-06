package org.sweetrooms.business.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.sweetrooms.persistence.entities.Position;
import org.sweetrooms.persistence.repositories.PositionRepository;

import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;

    public List<Position> getAllPositions()
    {
        return this.positionRepository.findAll();
    }

    public Position getPositionById(Long id)
    {
        return this.positionRepository.getById(id);
    }
    public Position savePosition(Position position)
    {
        return this.positionRepository.save(position);
    }
    public void deletePosition(Long id)
    {
        this.positionRepository.deleteById(id);
    }
}
