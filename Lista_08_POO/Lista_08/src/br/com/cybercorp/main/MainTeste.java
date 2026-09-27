package br.com.cybercorp.main;

import br.com.cybercorp.model.Departamento;
import br.com.cybercorp.model.Funcionario;
import br.com.cybercorp.model.Veiculo;
import br.com.cybercorp.model.Credencial;
import br.com.cybercorp.model.SistemaSeguranca;

public class MainTeste {
    public static void main(String[] args) {
        Departamento dep = new Departamento("TI", "Tecnologia", 2);
        Funcionario func = new Funcionario("C-001", "Lucas", dep);
        Veiculo carro = new Veiculo("ABC1D23", "Gol", func);
        SistemaSeguranca sistema = new SistemaSeguranca(2);
        Credencial c1 = new Credencial("FFF-999", true, func);
        Credencial clone = new Credencial("FFF-999", true, func);

        sistema.registrarCatraca(func);
        sistema.registrarCatraca(func);
        sistema.acessarCofre(c1);
        sistema.acessarCofre(clone);
        sistema.estacionarVeiculo(carro, 0);
        // Exceção NÃO capturada, exatamente como solicitado na lista.
        sistema.estacionarVeiculo(carro, 5);
    }
}
