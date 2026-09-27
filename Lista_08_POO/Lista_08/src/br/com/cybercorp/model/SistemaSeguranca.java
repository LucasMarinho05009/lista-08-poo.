package br.com.cybercorp.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SistemaSeguranca {
    private final Veiculo[] vagasGaragem;
    private final List<Funcionario> catracaPrincipal = new ArrayList<>();
    private final Set<Credencial> cofreFisico = new HashSet<>();

    public SistemaSeguranca(int totalVagas) {
        vagasGaragem = new Veiculo[totalVagas];
    }

    public void estacionarVeiculo(Veiculo v, int vaga) {
        // O acesso direto é intencional: a RN06 exige a exceção para vaga 5.
        vagasGaragem[vaga] = v;
        System.out.println("Garagem: Veículo " + v.getPlaca() + " estacionado na vaga " + vaga);
    }

    public void registrarCatraca(Funcionario f) {
        catracaPrincipal.add(f);
        System.out.println("Catraca: Acesso liberado para " + f.getNome());
    }

    public void acessarCofre(Credencial cred) {
        if (cofreFisico.add(cred)) {
            System.out.println("Cofre: Acesso CONCEDIDO. Bem-vindo(a) " + cred.getTitular().getNome());
        } else {
            System.out.println("ALERTA MÁXIMO: Credencial " + cred.getCodigoHex()
                    + " bloqueada! Tentativa de clonagem detectada.");
        }
    }
}
