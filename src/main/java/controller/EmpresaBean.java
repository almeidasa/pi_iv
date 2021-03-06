package controller;

import DAO.EmpresaDAO;
import entities.Empresa;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @Autor Alexandre Almeida
 * @Data 07/11/2018
 */
@ManagedBean
@ViewScoped
public class EmpresaBean {

    private int id;
    private String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String responsavel;
    private String data_cadastro;
    private int fk_Usuario_id_user;
    
    private ArrayList<Empresa> empresa;

    private String botao = "Incluir";
    private String icone = "plus-circle";

    public EmpresaBean() {
        this.empresa = new ArrayList<>();
        obter();

    }

    private void obter() {
        empresa.clear();
        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresa = empresaDAO.obterEmpresa(LoginBean.id_logado);
    }

    public void limpaTela() {
        this.id = 0;
        this.cnpj = null;
        this.nome = null;
        this.telefone = null;
        this.email = null;
        this.responsavel = null;
        this.data_cadastro = null;
        this.fk_Usuario_id_user = 0;
    }

    public void add() {
        if (botao.equals("Incluir")) {
            EmpresaDAO empresaDAO = new EmpresaDAO();
            Empresa emp = new Empresa(cnpj, nome, telefone, email, responsavel, LoginBean.id_logado);
            empresaDAO.inserirEmpresa(emp);
            limpaTela();
            obter();
        } else {
            EmpresaDAO empresaDAO = new EmpresaDAO();
            Empresa emp = new Empresa(id, cnpj, nome, telefone, email, responsavel, data_cadastro, LoginBean.id_logado);
            empresaDAO.editarEmpresa(emp);
            limpaTela();
            obter();
            botao = "Incluir";
            icone = "plus-circle";
        }
    }

    public String cancelar() {
        limpaTela();
        return "cadastrarEmpresa";
    }

    public void editar(Empresa emp) {
        this.id = emp.getId();
        this.cnpj = emp.getCnpj();
        this.nome = emp.getNome();
        this.telefone = emp.getTelefone();
        this.email = emp.getEmail();
        this.responsavel = emp.getResponsavel();
        
        botao = "Alterar";
        icone = "fa-refresh";
    }
    
    public void remover(Empresa emp) {
        EmpresaDAO empresaDAO = new EmpresaDAO();
        empresaDAO.removerEmpresa(emp);
        obter();
    }

    //Getters e Seters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(String data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public int getFk_Usuario_id_user() {
        return fk_Usuario_id_user;
    }

    public void setFk_Usuario_id_user(int fk_Usuario_id_user) {
        this.fk_Usuario_id_user = fk_Usuario_id_user;
    }

    public ArrayList<Empresa> getEmpresa() {
        return empresa;
    }

    public void setEmpresa(ArrayList<Empresa> empresa) {
        this.empresa = empresa;
    }

    public String getBotao() {
        return botao;
    }

    public void setBotao(String botao) {
        this.botao = botao;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

}
