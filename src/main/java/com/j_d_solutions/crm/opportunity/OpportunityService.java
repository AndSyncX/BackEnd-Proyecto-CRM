package com.j_d_solutions.crm.opportunity;

import com.j_d_solutions.crm.client.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
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
        OpportunityDto opportunityDto = new OpportunityDto();
        opportunityDto.setIdopportunity(opportunity.getIdopportunity());
        opportunityDto.setTitle(opportunity.getTitle());
        opportunityDto.setIdclient(opportunity.getClient().getIdclient());
        opportunityDto.setStatus(opportunity.getStatus());
        opportunityDto.setValue(opportunity.getValue());
        opportunityDto.setDue_date(opportunity.getDue_date());
        return opportunityDto;
    }

    public void saveOpportunity(OpportunityDto opportunityDto) {
        if (opportunityDto.getIdopportunity() != null ){
            opportunityRepository.updateParcialOpportunity(
                    opportunityDto.getTitle(),
                    opportunityDto.getIdclient(),
                    opportunityDto.getStatus(),
                    opportunityDto.getValue(),
                    opportunityDto.getDue_date(),
                    opportunityDto.getIdopportunity()
            );
        } else {
            Opportunity opportunity = new Opportunity();
            opportunity.setTitle(opportunityDto.getTitle());
            opportunity.setClient(clientRepository.findById(opportunityDto.getIdclient()).orElse(null));
            opportunity.setStatus(opportunityDto.getStatus());
            opportunity.setValue(opportunityDto.getValue());
            opportunity.setDue_date(opportunityDto.getDue_date());
            opportunityRepository.save(opportunity);
        }
    }
}
