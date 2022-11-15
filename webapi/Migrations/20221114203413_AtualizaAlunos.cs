using Microsoft.EntityFrameworkCore.Metadata;
using Microsoft.EntityFrameworkCore.Migrations;

#nullable disable

namespace alunoapi.Migrations
{
    public partial class AtualizaAlunos : Migration
    {
        protected override void Up(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropPrimaryKey(
                name: "PK_Alunos",
                table: "Alunos");

            migrationBuilder.RenameTable(
                name: "Alunos",
                newName: "aluno");

            migrationBuilder.RenameColumn(
                name: "Telefone",
                table: "aluno",
                newName: "telefone");

            migrationBuilder.RenameColumn(
                name: "Senha",
                table: "aluno",
                newName: "senha");

            migrationBuilder.RenameColumn(
                name: "Rg",
                table: "aluno",
                newName: "rg");

            migrationBuilder.RenameColumn(
                name: "Nome",
                table: "aluno",
                newName: "nome");

            migrationBuilder.RenameColumn(
                name: "Idade",
                table: "aluno",
                newName: "idade");

            migrationBuilder.RenameColumn(
                name: "Genero",
                table: "aluno",
                newName: "genero");

            migrationBuilder.RenameColumn(
                name: "Escolaridade",
                table: "aluno",
                newName: "escolaridade");

            migrationBuilder.RenameColumn(
                name: "Endereco",
                table: "aluno",
                newName: "endereco");

            migrationBuilder.RenameColumn(
                name: "Email",
                table: "aluno",
                newName: "email");

            migrationBuilder.RenameColumn(
                name: "Cpf",
                table: "aluno",
                newName: "cpf");

            migrationBuilder.RenameColumn(
                name: "Id",
                table: "aluno",
                newName: "id");

            migrationBuilder.AlterColumn<int>(
                name: "idade",
                table: "aluno",
                type: "int",
                nullable: false,
                oldClrType: typeof(int),
                oldType: "int")
                .Annotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn);

            migrationBuilder.AddPrimaryKey(
                name: "PK_aluno",
                table: "aluno",
                column: "id");
        }

        protected override void Down(MigrationBuilder migrationBuilder)
        {
            migrationBuilder.DropPrimaryKey(
                name: "PK_aluno",
                table: "aluno");

            migrationBuilder.RenameTable(
                name: "aluno",
                newName: "Alunos");

            migrationBuilder.RenameColumn(
                name: "telefone",
                table: "Alunos",
                newName: "Telefone");

            migrationBuilder.RenameColumn(
                name: "senha",
                table: "Alunos",
                newName: "Senha");

            migrationBuilder.RenameColumn(
                name: "rg",
                table: "Alunos",
                newName: "Rg");

            migrationBuilder.RenameColumn(
                name: "nome",
                table: "Alunos",
                newName: "Nome");

            migrationBuilder.RenameColumn(
                name: "idade",
                table: "Alunos",
                newName: "Idade");

            migrationBuilder.RenameColumn(
                name: "genero",
                table: "Alunos",
                newName: "Genero");

            migrationBuilder.RenameColumn(
                name: "escolaridade",
                table: "Alunos",
                newName: "Escolaridade");

            migrationBuilder.RenameColumn(
                name: "endereco",
                table: "Alunos",
                newName: "Endereco");

            migrationBuilder.RenameColumn(
                name: "email",
                table: "Alunos",
                newName: "Email");

            migrationBuilder.RenameColumn(
                name: "cpf",
                table: "Alunos",
                newName: "Cpf");

            migrationBuilder.RenameColumn(
                name: "id",
                table: "Alunos",
                newName: "Id");

            migrationBuilder.AlterColumn<int>(
                name: "Idade",
                table: "Alunos",
                type: "int",
                nullable: false,
                oldClrType: typeof(int),
                oldType: "int")
                .OldAnnotation("MySql:ValueGenerationStrategy", MySqlValueGenerationStrategy.IdentityColumn);

            migrationBuilder.AddPrimaryKey(
                name: "PK_Alunos",
                table: "Alunos",
                column: "Id");
        }
    }
}
