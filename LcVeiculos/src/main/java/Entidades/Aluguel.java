/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Date;
import java.util.Objects;


/**
 *
 * @author layla
 */
public class Aluguel {
    Integer idAluguel;
    Veiculo veiculo;
    Date dataEntrega;
    Date dataAluguel;
    Cliente cliente;
    Character entregue ;
    String observacao;
    Double valorPago;
   

    public Aluguel() {
    }

    public Aluguel(Integer idAluguel, Veiculo veiculo, Date dataEntrega, Date dataAluguel, Cliente cliente, Character entregue, String observacao, Double valorPago) {
        this.idAluguel = idAluguel;
        this.veiculo = veiculo;
        this.dataEntrega = dataEntrega;
        this.dataAluguel = dataAluguel;
        this.cliente = cliente;
        this.entregue = entregue;
        this.observacao = observacao;
        this.valorPago = valorPago;
    }

    public Integer getIdAluguel() {
        return idAluguel;
    }

    public void setIdAluguel(Integer idAluguel) {
        this.idAluguel = idAluguel;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }

    public void setDataAluguel(Date dataAluguel) {
        this.dataAluguel = dataAluguel;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Character getEntregue() {
        return entregue;
    }

    public void setEntregue(Character entregue) {
        this.entregue = entregue;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getValorPago() {
        return valorPago;
    }

    public void setValorPago(Double valorPago) {
        this.valorPago = valorPago;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.idAluguel);
        hash = 97 * hash + Objects.hashCode(this.veiculo);
        hash = 97 * hash + Objects.hashCode(this.dataEntrega);
        hash = 97 * hash + Objects.hashCode(this.dataAluguel);
        hash = 97 * hash + Objects.hashCode(this.cliente);
        hash = 97 * hash + Objects.hashCode(this.entregue);
        hash = 97 * hash + Objects.hashCode(this.observacao);
        hash = 97 * hash + Objects.hashCode(this.valorPago);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Aluguel other = (Aluguel) obj;
        if (!Objects.equals(this.observacao, other.observacao)) {
            return false;
        }
        if (!Objects.equals(this.idAluguel, other.idAluguel)) {
            return false;
        }
        if (!Objects.equals(this.veiculo, other.veiculo)) {
            return false;
        }
        if (!Objects.equals(this.dataEntrega, other.dataEntrega)) {
            return false;
        }
        if (!Objects.equals(this.dataAluguel, other.dataAluguel)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        if (!Objects.equals(this.entregue, other.entregue)) {
            return false;
        }
        return Objects.equals(this.valorPago, other.valorPago);
    }

    public Object getSelectedItem() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
