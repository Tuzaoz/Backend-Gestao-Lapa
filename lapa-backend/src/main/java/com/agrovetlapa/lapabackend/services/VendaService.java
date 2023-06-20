package com.agrovetlapa.lapabackend.services;

        import com.agrovetlapa.lapabackend.entities.Historico;
        import com.agrovetlapa.lapabackend.entities.Venda;
        import com.agrovetlapa.lapabackend.repositories.VendaRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.data.domain.Page;
        import org.springframework.data.domain.Pageable;

        import org.springframework.stereotype.Service;
        import com.agrovetlapa.lapabackend.services.exceptions.ResourceNotFoundException;


        import java.time.Instant;
        import java.time.LocalDate;
        import java.time.ZoneId;
        import java.util.List;
        import java.util.Objects;
        import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public List<Venda> findAll(){
        return vendaRepository.findAll();
    }

    public Venda findById(Integer id) {
        Optional<Venda> obj = vendaRepository.findById(Long.valueOf(id));
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Page<Venda> findTodayDate(Pageable pageable){
        return vendaRepository.findTodaySales(pageable);
    }

    public Double totalDia(){
        return vendaRepository.totalDia();
    }

    public Venda insert(Venda venda){
        venda.setValor();
        return vendaRepository.save(venda);
    }

    public List<Venda> getVendasByDateRange(String minDate, String maxDate){
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());

        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        return vendaRepository.getVendasByDateRange(min,max);
    }

    public List<Historico> getHistoricoInDateRange(String minDate, String maxDate){
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        LocalDate min = minDate.equals("") ? today.minusDays(365) : LocalDate.parse(minDate);
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        return vendaRepository.getHistoricoInRange(min,max);
    }
    public List<Historico> getHistoricoCompleto(){
        return vendaRepository.getHistoricoCompleto();
    }
}

