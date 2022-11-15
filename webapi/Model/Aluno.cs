namespace alunoapi.Model
{
    public class Aluno
    {
        public int Id { get; set; }
        public string Nome { get; set; }
        public int Idade { get; set; }
        public string Email { get; set; }
        public string Senha { get; set; }
        public string Cpf { get; set; }
        public string Rg { get; set; }
        public string Genero { get; set; }
        public string Telefone { get; set;}
        public string Endereco { get; set; }
        public string Escolaridade { get; set; }
        public object Data_Nascimento { get; internal set; }
    }
}