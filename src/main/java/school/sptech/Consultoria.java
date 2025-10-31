package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;
import java.util.List;
import java.util.ArrayList;

public class Consultoria {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public Consultoria() {}

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
    }

    public void contratar(Desenvolvedor desenvolvedor){
        if (desenvolvedores.size() < vagas){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (vagas > 0 && desenvolvedor.isFullstack()){
            desenvolvedores.add(desenvolvedor);
        }
    }

    public Double getTotalSalarios(){
        Double totalSalarios = 0.0;
        for (Desenvolvedor desenvolvedor:desenvolvedores){
            totalSalarios += desenvolvedor.calcularSalario();
        }
        return totalSalarios;
    }

    public Integer qtdDesenvolvedoresMobile(){
        Integer qtdDevsMobile = 0;
        for (Desenvolvedor desenvolvedor:desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorMobile){
                qtdDevsMobile++;
            }
        }
        return qtdDevsMobile;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        List<Desenvolvedor> devsSalario = new ArrayList<>();
        for (Desenvolvedor desenvolvedor:desenvolvedores){
            if (desenvolvedor.calcularSalario() >= salario){
                devsSalario.add(desenvolvedor);
            }
        }
        return devsSalario;
    }

    public Desenvolvedor buscarMenorSalario(){
        Desenvolvedor devMenorSalario = null;
        if (desenvolvedores.isEmpty()){
            return null;
        }
        for (Desenvolvedor desenvolvedor:desenvolvedores){

            if (devMenorSalario == null) {
                devMenorSalario = desenvolvedor;
            }
            if (desenvolvedor.calcularSalario() < devMenorSalario.calcularSalario()){
                devMenorSalario = desenvolvedor;
            }
        }
        return devMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> devsTech = new ArrayList<>();
        for (Desenvolvedor desenvolvedor:desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) desenvolvedor).getBackend() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getFrontend() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getSgbd() == tecnologia){
                    devsTech.add(desenvolvedor);
                }
            } else if (desenvolvedor instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedor).getLinguagem() == tecnologia || ((DesenvolvedorMobile) desenvolvedor).getPlataforma() == tecnologia){
                    devsTech.add(desenvolvedor);
                }
            }
        }
        return devsTech;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        Double salarioTech = 0.0;
        for (Desenvolvedor desenvolvedor:desenvolvedores){
            if (desenvolvedor instanceof DesenvolvedorWeb){
                if(((DesenvolvedorWeb) desenvolvedor).getBackend() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getFrontend() == tecnologia || ((DesenvolvedorWeb) desenvolvedor).getSgbd() == tecnologia){
                    salarioTech += desenvolvedor.calcularSalario();
                }
            } else if (desenvolvedor instanceof DesenvolvedorMobile){
                if (((DesenvolvedorMobile) desenvolvedor).getLinguagem() == tecnologia || ((DesenvolvedorMobile) desenvolvedor).getPlataforma() == tecnologia){
                    salarioTech += desenvolvedor.calcularSalario();
                }
            }
        }
        return salarioTech;
    }
}
