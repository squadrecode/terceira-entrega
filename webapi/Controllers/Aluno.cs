using alunoapi.Repository;
using Microsoft.AspNetCore.Mvc;
using alunoapi.Model;

namespace alunoapi.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class AlunoController : ControllerBase
    {
        //injetar dependencia do repositorio
        private readonly IAlunoRepository _repository;

        public AlunoController(IAlunoRepository repository) {
           _repository = repository; 
        }

        [HttpGet]
        public async Task<IActionResult> GetAll(){
            var alunos = await _repository.GetAlunos();
            return alunos.Any() ? Ok(alunos) : NoContent();
        }
        [HttpGet("{id}")]
        public async Task<IActionResult> GetById(int id){
            var aluno = await _repository.GetAlunoById(id);
            return aluno != null
            ? Ok(aluno) : NotFound("Aluno não encontrado.");
        }

            [HttpPost]
        public async Task<IActionResult> Post(Aluno aluno){
           _repository.AddAluno(aluno);
           return await _repository.SaveChangesAsync() ? Ok("Aluno adicionado") : BadRequest("Algo deu errado.");
        }
        [HttpPut("{id}")]
        public async Task<IActionResult> Atualizar(int id, Aluno aluno){
            var alunoExiste = await _repository.GetAlunoById(id);
            if(alunoExiste == null) return NotFound("Aluno não encontrado.");

            alunoExiste.Nome = aluno.Nome ?? alunoExiste.Nome;
            object data_Nascimento = aluno.Idade;
            alunoExiste.Idade = aluno.Idade = new () ? aluno.Idade : alunoExiste.Idade;

            _repository.AtualizarAluno(alunoExiste);
            return await _repository.SaveChangesAsync() ? Ok("Aluno atualizado") : BadRequest("Algo de errado.");
        }

        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(int id) {
           var alunoExiste = await _repository.GetAlunoById(id);
            if(alunoExiste == null) return NotFound("Aluno não encontrado.");

            _repository.DeletarAluno(alunoExiste);
         
         return await _repository.SaveChangesAsync() ? Ok("Aluno atualizado") : BadRequest("Algo de errado.");
        }
        
        }
   }

