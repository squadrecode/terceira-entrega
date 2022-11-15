using alunoapi.Controllers;
using alunoapi.Model;

namespace alunoapi.Repository
{
    public interface IAlunoRepository
    {
       Task<IEnumerable<Aluno>> GetAlunos();
       Task<Aluno> GetAlunoById(int id);
       void AddAluno(Aluno aluno);
       void AtualizarAluno(Aluno aluno);
       void DeletarAluno(Aluno aluno);
       Task<bool> SaveChangesAsync();


 
    }
}