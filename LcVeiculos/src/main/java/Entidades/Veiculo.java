/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.Objects;

/**
 *
 * @author layla
 */
public class Veiculo {
    Integer idVeiculo;
    String placa;
    String fabricante;
    String modelo;
    Integer AnoModelo;
    Integer qtdPortas;
    String acessorios;

    public Veiculo() {
    }    
    public Veiculo(Integer idVeiculo, String placa, String fabricante, String modelo, Integer AnoModelo, Integer qtdPortas, String acessorios) {
        this.idVeiculo = idVeiculo;
        this.placa = placa;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.AnoModelo = AnoModelo;
        this.qtdPortas = qtdPortas;
        this.acessorios = acessorios;
    }

    public Integer getNumero() {
        return idVeiculo;
    }

    public void setNumero(Integer numero) {
        this.idVeiculo = numero;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAnoModelo() {
        return AnoModelo;
    }

    public void setAnoModelo(Integer AnoModelo) {
        this.AnoModelo = AnoModelo;
    }

    public Integer getQtdPortas() {
        return qtdPortas;
    }

    public void setQtdPortas(Integer qtdPortas) {
        this.qtdPortas = qtdPortas;
    }

    public String getAcessorios() {
        return acessorios;
    }
    public Integer getIdVeiculo() {
        return idVeiculo;
    }
     public void setIdVeiculo(Integer id) {
        this.idVeiculo= id;
    }
   
    public void setAcessorios(String acessorios) {
        this.acessorios = acessorios;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + Objects.hashCode(this.idVeiculo);
        hash = 19 * hash + Objects.hashCode(this.placa);
        hash = 19 * hash + Objects.hashCode(this.fabricante);
        hash = 19 * hash + Objects.hashCode(this.modelo);
        hash = 19 * hash + Objects.hashCode(this.AnoModelo);
        hash = 19 * hash + Objects.hashCode(this.qtdPortas);
        hash = 19 * hash + Objects.hashCode(this.acessorios);
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
        final Veiculo other = (Veiculo) obj;
        if (!Objects.equals(this.idVeiculo, other.idVeiculo)) {
            return false;
        }
        if (!Objects.equals(this.placa, other.placa)) {
            return false;
        }
        if (!Objects.equals(this.fabricante, other.fabricante)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.acessorios, other.acessorios)) {
            return false;
        }
        if (!Objects.equals(this.AnoModelo, other.AnoModelo)) {
            return false;
        }
        return Objects.equals(this.qtdPortas, other.qtdPortas);
    }
          
}
