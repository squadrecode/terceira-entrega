using alunoapi.Model;
using Microsoft.EntityFrameworkCore;

namespace alunoapi.Database
{
    public class AlunoDbContext : DbContext
    {
        public AlunoDbContext(DbContextOptions<AlunoDbContext> options) : base(options){

        }

        public DbSet<Aluno> Alunos { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder){
            var aluno = modelBuilder.Entity<Aluno>();
            aluno.ToTable("aluno");
            aluno.HasKey(x => x.Id);
            aluno.Property(x => x.Id).HasColumnName("id").ValueGeneratedOnAdd();
            aluno.Property(x => x.Nome).HasColumnName("nome").IsRequired();
            aluno.Property(x => x.Idade).HasColumnName("idade").IsRequired();
            aluno.Property(x => x.Email).HasColumnName("email").IsRequired();
            aluno.Property(x => x.Senha).HasColumnName("senha").IsRequired();
            aluno.Property(x => x.Cpf).HasColumnName("cpf").IsRequired();
            aluno.Property(x => x.Rg).HasColumnName("rg").IsRequired();
            aluno.Property(x => x.Genero).HasColumnName("genero").IsRequired();
            aluno.Property(x => x.Telefone).HasColumnName("telefone").IsRequired();
            aluno.Property(x => x.Endereco).HasColumnName("endereco").IsRequired();
            aluno.Property(x => x.Escolaridade).HasColumnName("escolaridade").IsRequired();
        }
    }
}