
using alunoapi.Database;
using alunoapi.Model;
using Microsoft.EntityFrameworkCore;

namespace alunoapi.Repository
{
    public class AlunoRepository : IAlunoRepository
    {
        //injetar dependencia do contexto
         private readonly AlunoDbContext _context;

        public AlunoRepository(AlunoDbContext context){
            _context = context;
        }
       public void AddAluno(Aluno aluno) 
       {
          _context.Add(aluno);
       }
        public void AtualizarAluno(Aluno aluno)
        {
            _context.Update(aluno);
        }

        public void DeletarAluno(Aluno aluno)
        {
            _context.Remove(aluno);
        }

        public async Task<Aluno> GetAlunoById(int id)
        {
            return await _context.Alunos.Where(x => x.Id == id)
                .FirstOrDefaultAsync();
        }

        public async Task<IEnumerable<Aluno>> GetAluno()
        {
            return await _context.Alunos.ToListAsync();
        }

        public async Task<bool> SaveChangesAsync()
        {
            return await _context.SaveChangesAsync() > 0;
        }

        public Task<IEnumerable<Aluno>> GetAlunos()
        {
            throw new NotImplementedException();
        }

        Task<IEnumerable<Aluno>> IAlunoRepository.GetAlunos()
        {
            throw new NotImplementedException();
        }

        Task<Aluno> IAlunoRepository.GetAlunoById(int id)
        {
            throw new NotImplementedException();
        }

        public void AddAlunos(Aluno aluno)
        {
            throw new NotImplementedException();
        }

        public void AtualizarAlunos(Aluno aluno)
        {
            throw new NotImplementedException();
        }

        public void DeletarAlunos(Aluno aluno)
        {
            throw new NotImplementedException();
        }
    }
}