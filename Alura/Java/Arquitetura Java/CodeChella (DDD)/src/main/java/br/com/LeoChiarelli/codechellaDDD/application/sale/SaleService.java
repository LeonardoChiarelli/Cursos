package br.com.LeoChiarelli.codechellaDDD.application.sale;

import br.com.LeoChiarelli.codechellaDDD.application.ticket.TicketTypeDataDTO;
import br.com.LeoChiarelli.codechellaDDD.application.user.UserDataDTO;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.sale.SaleEntity;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.TicketEntity;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.TypeEntity;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.user.UserEntity;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.ticket.TypeRepository;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.user.UserRepository;
import br.com.LeoChiarelli.codechellaDDD.infrastructure.sale.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TypeRepository typeRepository;

    public SaleDataDTO registrySale(RegistrySaleDTO dto) {
        UserEntity userEntity = userRepository.findById(dto.user_id())
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setUser(userEntity);

        List<TicketEntity> ticketEntities = new ArrayList<>();
        dto.tickets()
                .forEach(i -> {
                    TypeEntity typeEntity = typeRepository.findById(i.type_id())
                            .orElseThrow(() -> new IllegalArgumentException("TypeEntity de ticketEntity não encontrado"));
                    TicketEntity ticketEntity = new TicketEntity(i.code(), typeEntity);
                    ticketEntities.add(ticketEntity);
                });
        saleEntity.setTickets(ticketEntities);
        repository.save(saleEntity);
        return convertData(saleEntity);
    }

    public List<SaleDataDTO> listAll() {
        return repository.findAll().stream()
                .map(this::convertData)
                .collect(Collectors.toList());
    }

    private SaleDataDTO convertData(SaleEntity saleEntity) {
        List<TicketTypeDataDTO> ingressos =
                saleEntity.getTickets().stream()
                        .map(i -> new TicketTypeDataDTO(i.getCode(),
                                i.getType().getArea(), i.getType().getDefinition()))
                        .collect(Collectors.toList());


        return new SaleDataDTO(saleEntity.getId(),
                new UserDataDTO(saleEntity.getUser().getId(),
                        saleEntity.getUser().getSsn(),
                        saleEntity.getUser().getName(),
                        saleEntity.getUser().getBirth(),
                        saleEntity.getUser().getEmail()),
                ingressos);
    }
}
