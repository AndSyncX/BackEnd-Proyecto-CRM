package com.j_d_solutions.crm.opportunity;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/opportunity")
@RequiredArgsConstructor
@RestController // -> convierte la clase en un "controlador" y convierte su contenido en un JSON
public class OpportunityController {
    private final OpportunityService opportunityService;

    // Obtener todas las oportunidades
    @GetMapping
    public List<Opportunity> getAllOpportunities() {
        return opportunityService.getOpportunities();
    }

    // Obtener oportunidad por ID
    @GetMapping("{id}")
    public Opportunity getOpportunityById(@PathVariable int id) {
        return opportunityService.getOpportunityById(id);
    }

    // Crear nueva oportunidad
    @PostMapping
    public Opportunity createOpportunity(@RequestBody OpportunityDto opportunityDto) { // RequestBody -> Toma el contenido del cuerpo (body) de la petición HTTP, lo convierte desde JSON a un objeto JAVA
        return opportunityService.createOpportunity(opportunityDto);
    }

    // Actualizar oportunidad
    @PutMapping("{id}")
    public OpportunityDto updateopportunity(@PathVariable int id, @RequestBody OpportunityDto opportunityDto) { // PathVariable -> Captura el valor de la URL y lo asigna a la variable id
        return opportunityService.updateOpportunity(opportunityDto, id);
    }
}
