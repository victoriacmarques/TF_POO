package dados;

import java.util.ArrayList;

public class FilaLocacao {
    ArrayList<Locacao> listaLocacao = new ArrayList<>();

    public FilaLocacao(Locacao locacao) {
        this.listaLocacao.add(locacao);
        processarLocacao(locacao);
    }

    public ArrayList<Locacao> getLocacoesByStatus(Status status) {
        ArrayList<Locacao> listaLocacaoStatus = new ArrayList<>();
        for (Locacao locacao : listaLocacao) {
            if(locacao.getSituacao().equals(status.name())) {
                listaLocacaoStatus.add(locacao);
            }
        }
        return listaLocacaoStatus;
    }

//    Processar locações (a partir da fila de locações pendentes; o sistema fará o
//    processamento automático de cada locação. Verifica se é possível locar cada robô
//    solicitado. Se todos os robôs solicitados forem locados, a locação passa para a
//    situação EXECUTANDO. Se algum robô não estiver disponível, todos os robôs já
//    locados são liberados e a locação retorna para a fila de locações pendentes. [Se não
//    há locações na fila de locações pendentes, mostra uma mensagem de erro]).
    public ArrayList<Locacao> processarLocacao(Locacao locacao) {
        ArrayList<Robo> robos = locacao.getRobos();
        ArrayList<Robo> robosPendentes = new ArrayList<>();
        ArrayList<Robo> robosLocados = new ArrayList<>();
        for (Robo robo : robos) {
            if(robo.getStatus()) {
                //se o status for true quer dizer que o robo está disponível para locação
                robosLocados.add(robo);
            }else {
                robosPendentes.add(robo);
            }
        }
        if(robosPendentes.size() != 0) {
            for (Robo robo : robosLocados) {
                robosPendentes.add(robo);
                robosLocados.remove(robo);
            }

                if(listaLocacao.isEmpty()) {
                    System.out.println("Não há locações pendentes na fila");
                }

            return listaLocacao;
        }else{
            for(Robo robo : robosLocados) {
                robo.setStatus(false);
            }
            locacao.setSituacao(Status.EXECUTANDO);
        }
        return listaLocacao;
    }

//    Alterar a situação de uma locação (solicita o número de um locação; mostra os dados
//    da locação; solicita a nova situação [se não há locação com o código indicado, mostra
//    uma mensagem de erro; se o locação estiver na situação FINALIZADA ou
//    CANCELADA, não pode ser alterado e mostra uma mensagem de erro]).
    public String alterarSituacao(int numero, Status situacao) {
        Locacao locacaoComONumero = null;
        for (Locacao locacao : listaLocacao) {
            if(locacao.getNumero()==numero) {
                locacaoComONumero = locacao;
                Status status = locacao.getSituacao();

                if(status.equals(Status.FINALIZADA) || status.equals(Status.CANCELADA)) {
                    return "A locação não pode ser alterada pois sua situação é "+status.name();
                }
            }
        }

        if(locacaoComONumero.equals(null)) {
            return "Não existe uma locação com o número "+numero;
        }

        locacaoComONumero.setSituacao(situacao);
        return locacaoComONumero.toString();
    }
}
