package com.agrovetlapa.lapabackend.repositories;

import com.agrovetlapa.lapabackend.entities.Dia;
import com.agrovetlapa.lapabackend.entities.Historico;
import com.agrovetlapa.lapabackend.entities.Venda;
import com.agrovetlapa.lapabackend.responses.VendaResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Objects;
@Repository
public interface VendaRepository extends JpaRepository<Venda,Long> {
    @Query("select obj FROM Venda obj WHERE obj.data = CURRENT_DATE ")
    List<Venda> findTodaySales();

    @Query("SELECT  SUM(valor) FROM Venda WHERE data = CURRENT_DATE ")
    Double totalDia();
    @Query( "SELECT obj FROM Venda obj where obj.data between :min and :max")
    List<Venda> getVendasByDateRange (LocalDate min, LocalDate max);

    @Query("select obj FROM Venda obj WHERE obj.data = :date ")
    List<Venda> findByData_Day(LocalDate date);

//    @Query("SELECT v.data, v.total_cartao, v.total_boleto, v.totalPix, v.totalVenda, SUM(c.valor) as totalConta " +
//            "FROM (" +
//            "   SELECT data, " +
//            "          SUM(CASE WHEN metodoPagamento = 'Cartão de crédito' THEN valor ELSE 0 END) AS total_cartao, " +
//            "          SUM(CASE WHEN metodoPagamento = 'Boleto' THEN valor ELSE 0 END) AS total_boleto, " +
//            "          SUM(CASE WHEN metodoPagamento = 'Pix' THEN valor ELSE 0 END) AS totalPix, " +
//            "          SUM(valor) as totalVenda " +
//            "   FROM Venda " +
//            "   WHERE data BETWEEN :min AND :max " +
//            "   GROUP BY data) v " +
//            "INNER JOIN Conta c ON v.data = c.data " +
//            "GROUP BY v.data, v.total_cartao, v.total_boleto, v.totalPix, v.totalVenda")
//    List<Object> getVendasByDateRange2 (LocalDate min, LocalDate max);

    @Query(nativeQuery = true, value ="SELECT v.data, v.total_cartao_cred,v.total_dinheiro,v.total_pix, v.total_deb, " +
            "v.total_venda, sum(c.valor) as total_conta FROM " +
            "(SELECT data," +
            "       SUM(CASE WHEN metodo_pagamento = 'Cartão de Crédito' THEN valor ELSE 0 END) AS total_cartao_cred," +
            "       SUM(CASE WHEN metodo_pagamento = 'Dinheiro' THEN valor ELSE 0 END) AS total_dinheiro," +
            "       SUM(CASE WHEN metodo_pagamento = 'Pix' THEN valor ELSE 0 END) AS total_pix," +
            "       SUM(CASE WHEN metodo_pagamento = 'Cartão de Dédito' THEN valor ELSE 0 END) AS total_deb," +
            "   sum(valor) as total_venda" +
            "   FROM venda" +
            "   GROUP BY data) AS v" +
            " Left JOIN conta c on v.data = c.data" +
            " GROUP BY v.data, v.total_cartao_cred, v.total_deb, v.total_dinheiro,v.total_Pix, v.total_venda" +
            " ORDER BY v.data DESC;")
    List<Historico> getHistoricoCompleto();

    @Query(nativeQuery = true, value ="SELECT v.data, v.total_cartao_cred,v.total_dinheiro,v.total_pix, v.total_deb, " +
            "v.total_venda, sum(c.valor) as total_conta FROM " +
            "(SELECT data," +
            "       SUM(CASE WHEN metodo_pagamento = 'Cartão de Crédito' THEN valor ELSE 0 END) AS total_cartao_cred," +
            "       SUM(CASE WHEN metodo_pagamento = 'Dinheiro' THEN valor ELSE 0 END) AS total_dinheiro," +
            "       SUM(CASE WHEN metodo_pagamento = 'Pix' THEN valor ELSE 0 END) AS total_pix," +
            "       SUM(CASE WHEN metodo_pagamento = 'Cartão de Dédito' THEN valor ELSE 0 END) AS total_deb," +
            "   sum(valor) as total_venda" +
            "   FROM venda" +
            " where data between ?1 and ?2" +
            "   GROUP BY data) AS v" +
            " Left JOIN conta c on v.data = c.data" +
            " GROUP BY v.data, v.total_cartao_cred, v.total_deb, v.total_dinheiro,v.total_Pix, v.total_venda" +
            " ORDER BY v.data DESC;")
    List<Historico> getHistoricoInRange(LocalDate min, LocalDate max);



}
