
public class Usuario {
    private int id;                       // chave primária (auto_increment no MySQL)
    private String nome;
    private String senha;
    private String cpf;

    // --- Construtor vazio (necessário para frameworks/reflexão)
    public Usuario() {}

    // --- Construtor completo (sem id, usado no INSERT)
    public Usuario(String nome, String cpf, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    // --- Construtor com id (usado em UPDATE e DELETE)
    public Usuario(int id, String nome, String cpf, String senha) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    // --- Getters e Setters (necessários para acessar os atributos)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }

    // --- Facilita debug/impressão
    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }

    public boolean validar() {
        return validarNome(this.nome) &&
               validarCpf(this.cpf) &&
               validarSenha(this.senha);
    }

    public boolean validarNome(String nome) {
        return nome != null && !nome.trim().isEmpty();
    }

    public boolean validarCpf(String cpf) {
        return cpf != null && cpf.matches("\\d{11}") ;
    }

    public boolean validarSenha(String senha) {
        return senha != null && senha.matches("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$") ;
    }

  
}


