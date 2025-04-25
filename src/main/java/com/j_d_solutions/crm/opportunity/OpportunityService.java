package com.j_d_solutions.crm.opportunity;

import com.j_d_solutions.crm.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor // -> Genera el constructor de la clase con los atributos final
public class OpportunityService {
    private final OpportunityRepository opportunityRepository;
    private final ClientRepository clientRepository;

    public List<Opportunity> getOpportunities() {
        return opportunityRepository.findAll();
    }

    public Opportunity getOpportunityById(int id) {
        return opportunityRepository.findById(id).orElse(null);
    }

    public OpportunityDto getOpportunityDtoById(int id) {
        Opportunity opportunity = getOpportunityById(id);
        OpportunityDto dto = new OpportunityDto();
        dto.setIdopportunity(opportunity.getIdopportunity());
        dto.setTitle(opportunity.getTitle());
        dto.setIdclient(opportunity.getClient().getIdclient());
        dto.setStatus(opportunity.getStatus());
        dto.setValue(opportunity.getValue());
        dto.setClose_date(opportunity.getClose_date());
        return dto;
    }

    public Opportunity createOpportunity(OpportunityDto dto) {
        Opportunity opportunity = new Opportunity();
        opportunity.setTitle(dto.getTitle());
        opportunity.setClient(clientRepository.findById(dto.getIdclient()).orElse(null));
        opportunity.setStatus(dto.getStatus());
        opportunity.setValue(dto.getValue());
        opportunity.setClose_date(dto.getClose_date());
        return opportunityRepository.save(opportunity);
    }

    public OpportunityDto updateOpportunity(OpportunityDto dto, int id) {
        if (!opportunityRepository.existsById(id)){
            throw new RuntimeException("Oportunidad no encontrada");
        }
        opportunityRepository.updateParcialOpportunity(
                dto.getTitle(),
                dto.getIdclient(),
                dto.getStatus(),
                dto.getValue(),
                dto.getClose_date(),
                id
        );
        return dto;
    }
}
